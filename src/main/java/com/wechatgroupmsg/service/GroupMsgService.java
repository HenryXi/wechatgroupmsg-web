package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.GroupMsgBean;
import com.wechatgroupmsg.bean.MsgCountItem;
import com.wechatgroupmsg.bean.MsgItem;
import com.wechatgroupmsg.dao.ChatroomDao;
import com.wechatgroupmsg.dao.ContactDao;
import com.wechatgroupmsg.dao.GroupMsgDao;
import com.wechatgroupmsg.dao.MessageDao;
import com.wechatgroupmsg.entity.ChatroomEntity;
import com.wechatgroupmsg.entity.ContactEntity;
import com.wechatgroupmsg.entity.GroupMsgEntity;
import com.wechatgroupmsg.entity.MessageEntity;
import com.wechatgroupmsg.util.DateUtil;
import com.wechatgroupmsg.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GroupMsgService {
    @Autowired
    private GroupMsgDao groupMsgDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ChatroomDao chatroomDao;

    @Autowired
    private ContactDao contactDao;

    public void prepareData(List<String> newMsgChatroomNames) {
        List<ContactEntity> contactEntities = contactDao.queryByUserNames(newMsgChatroomNames);
        Map<String, String> groupNameMap = contactEntities.stream()
                .collect(Collectors.toMap(ContactEntity::getUsername, ContactEntity::getNickname));
        List<ChatroomEntity> chatroomEntities = chatroomDao.queryByChatroomNames(newMsgChatroomNames);
        for (ChatroomEntity entity : chatroomEntities) {
            String groupName = groupNameMap.get(entity.getChatroomname());
            prepareData(entity, groupName);
        }
    }

    private void prepareData(ChatroomEntity entity, String groupName) {
        List<String> usernames = Arrays.asList(StringUtils.split(entity.getMemberlist(), ";"));
        List<ContactEntity> contactEntities = contactDao.queryByUserNames(usernames);
        Map<String, String> nameMap = contactEntities.stream().collect(Collectors.toMap(ContactEntity::getUsername, ContactEntity::getNickname));
        long twoDaysAgoMill = System.currentTimeMillis() - (2 * 86400 * 1000);
        List<MessageEntity> messageEntities = messageDao.queryLatestMessages(entity.getChatroomname(), twoDaysAgoMill);
        List<MessageEntity> okMessages = messageEntities.stream().filter(m -> okMessage(m, entity.getRoomowner())).collect(Collectors.toList());
        String resultContent = convertMsgListToString(okMessages, groupName, nameMap);
        GroupMsgEntity groupMsg = new GroupMsgEntity();
        groupMsg.setGroupId(entity.getChatroomname());
        groupMsg.setContent(resultContent);
        groupMsg.setUpdateTime(System.currentTimeMillis());
        groupMsgDao.save(groupMsg);

    }

    private boolean okMessage(MessageEntity entity, String roomOwner) {
        String content = entity.getContent();
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        if (StringUtils.containsAny(content, "<msg>", "<sysmsg")) {
            return false;
        }
        if (StringUtils.startsWith(content, roomOwner)) {
            return false;
        }
        return true;
    }

    private String convertMsgListToString(List<MessageEntity> messageEntityList, String groupName, Map<String, String> nameMap) {
        GroupMsgBean groupMsgBean = new GroupMsgBean();
        groupMsgBean.setGroupName(groupName);
        List<MsgItem> msgItemList = new ArrayList<>();
        for (MessageEntity messageEntity : messageEntityList) {
            String[] senderAndContent = StringUtils.split(messageEntity.getContent(), ":\\n");
            if (senderAndContent.length != 2) {
                continue;
            }
            MsgItem msgItem = new MsgItem();
            msgItem.setContent(senderAndContent[1]);
            msgItem.setCreateTime(DateUtil.getYMDHMS(messageEntity.getCreateTime()));
            msgItem.setSender(nameMap.get(senderAndContent[0]));
            msgItemList.add(msgItem);
        }
        groupMsgBean.setMsgItemList(msgItemList);
        return JsonUtil.toJsonString(groupMsgBean);
    }

    public GroupMsgBean getGroupMsgByGroupId(String groupId, String searchWord) {
        GroupMsgEntity groupMsg = groupMsgDao.selectByGroupId(groupId);
        GroupMsgBean groupMsgBean = JsonUtil.fromJson(groupMsg.getContent(), GroupMsgBean.class);
        groupMsgBean.setGroupId(groupId);
        if (StringUtils.isEmpty(searchWord)) {
            return groupMsgBean;
        }
        List<MsgItem> afterFilterList = groupMsgBean.getMsgItemList().stream()
                .filter(m -> StringUtils.contains(m.getContent(), searchWord))
                .collect(Collectors.toList());
        Map<String, Long> msgCountMap = afterFilterList.stream().collect(Collectors.groupingBy(MsgItem::getContent, Collectors.counting()));
        List<MsgCountItem> msgCountItemList = new ArrayList<>();
        for (String content : msgCountMap.keySet()) {
            msgCountItemList.add(new MsgCountItem(content, msgCountMap.get(content)));
        }
        msgCountItemList.sort(Comparator.comparing(MsgCountItem::getCount, Comparator.reverseOrder()));
        groupMsgBean.setMsgCount(msgCountItemList);
        groupMsgBean.setMsgItemList(afterFilterList);
        return groupMsgBean;
    }
}
