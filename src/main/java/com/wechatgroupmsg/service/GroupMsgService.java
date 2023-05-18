package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.GroupMsgBean;
import com.wechatgroupmsg.bean.GroupMsgReq;
import com.wechatgroupmsg.bean.MsgCountItem;
import com.wechatgroupmsg.bean.MsgItem;
import com.wechatgroupmsg.dao.GroupMsgDao;
import com.wechatgroupmsg.entity.GroupMsgEntity;
import com.wechatgroupmsg.util.DateUtil;
import com.wechatgroupmsg.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GroupMsgService {
    @Autowired
    private GroupMsgDao groupMsgDao;

    public void saveInToDB(List<GroupMsgReq> groupMsgReqList) {
        //todo if data big there will oom
        Map<String, List<GroupMsgReq>> groupedMsg = groupMsgReqList.stream().collect(Collectors.groupingBy(GroupMsgReq::getGroupId));
        for (String groupId : groupedMsg.keySet()) {
            String resultContent = convertMsgListToString(groupedMsg.get(groupId));
            GroupMsgEntity groupMsg = new GroupMsgEntity();
            groupMsg.setGroupId(groupId);
            groupMsg.setContent(resultContent);
            groupMsg.setUpdateTime(System.currentTimeMillis());
            groupMsgDao.save(groupMsg);
        }
    }

    private String convertMsgListToString(List<GroupMsgReq> groupMsgReqs) {
        GroupMsgBean groupMsgBean = new GroupMsgBean();
        groupMsgBean.setGroupName(groupMsgReqs.get(0).getGroupName());
        List<MsgItem> msgItemList = new ArrayList<>();
        for (GroupMsgReq msg : groupMsgReqs) {
            MsgItem msgItem = new MsgItem();
            msgItem.setContent(msg.getContent());
            msgItem.setCreateTime(DateUtil.getYMDHMS(msg.getCreateTime()));
            msgItem.setSender(msg.getSender());
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
