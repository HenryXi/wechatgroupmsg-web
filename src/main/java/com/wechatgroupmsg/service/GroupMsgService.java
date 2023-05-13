package com.wechatgroupmsg.service;

import com.wechatgroupmsg.dao.GroupMsgDao;
import com.wechatgroupmsg.entity.GroupMsg;
import com.wechatgroupmsg.req.GroupMsgReq;
import com.wechatgroupmsg.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GroupMsgService {
    @Autowired
    private GroupMsgDao groupMsgDao;

    public void saveInToDB(List<GroupMsgReq> groupMsgReqList) {
        Map<String, List<GroupMsgReq>> groupedMsg = groupMsgReqList.stream().collect(Collectors.groupingBy(GroupMsgReq::getGroupId));
        for (String groupId : groupedMsg.keySet()) {
            String resultContent = convertMsgListToString(groupedMsg.get(groupId));
            GroupMsg groupMsg = new GroupMsg();
            groupMsg.setGroupId(groupId);
            groupMsg.setContent(resultContent);
            groupMsg.setUpdateTime(System.currentTimeMillis());
            groupMsgDao.save(groupMsg);
        }
    }

    private String convertMsgListToString(List<GroupMsgReq> groupMsgReqs) {
        StringBuilder sb = new StringBuilder(groupMsgReqs.get(0).getGroupName()).append("<br>");
        for (GroupMsgReq msg : groupMsgReqs) {
            sb.append(DateUtil.getYMDHMS(msg.getCreateTime())).append("&nbsp;").append(msg.getSender()).append(":").append(msg.getContent()).append("<br>");
        }
        return sb.toString();
    }

    public String getRecentMsgByGroupId(String groupId) {
        GroupMsg groupMsg = groupMsgDao.selectByGroupId(groupId);
        return groupMsg.getContent();
    }
}
