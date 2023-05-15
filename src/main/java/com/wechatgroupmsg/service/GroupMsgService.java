package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.GroupMsgBean;
import com.wechatgroupmsg.bean.GroupMsgReq;
import com.wechatgroupmsg.bean.MsgBean;
import com.wechatgroupmsg.dao.GroupMsgDao;
import com.wechatgroupmsg.entity.GroupMsgEntity;
import com.wechatgroupmsg.util.DateUtil;
import com.wechatgroupmsg.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<MsgBean> msgBeanList = new ArrayList<>();
        for (GroupMsgReq msg : groupMsgReqs) {
            MsgBean msgBean = new MsgBean();
            msgBean.setContent(msg.getContent());
            msgBean.setCreateTime(DateUtil.getYMDHMS(msg.getCreateTime()));
            msgBean.setSender(msg.getSender());
            msgBeanList.add(msgBean);
        }
        groupMsgBean.setMsgBeanList(msgBeanList);
        return JsonUtil.toJsonString(groupMsgBean);
    }

    public String getRecentMsgByGroupId(String groupId) {
        GroupMsgEntity groupMsg = groupMsgDao.selectByGroupId(groupId);
        return groupMsg.getContent();
    }

    public GroupMsgBean getGroupMsgByGroupId(String groupId) {
        GroupMsgEntity groupMsg = groupMsgDao.selectByGroupId(groupId);
        return JsonUtil.fromJson(groupMsg.getContent(), GroupMsgBean.class);
    }
}
