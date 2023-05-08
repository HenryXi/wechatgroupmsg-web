package com.wechatgroupmsg.service;

import com.wechatgroupmsg.req.GroupMsgReq;
import com.wechatgroupmsg.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GroupMsgService {
    private Map<String, String> groupMsgMap = new HashMap<>();

    public void saveInToDB(List<GroupMsgReq> groupMsgReqList) {
        Map<String, List<GroupMsgReq>> groupedMsg = groupMsgReqList.stream().collect(Collectors.groupingBy(GroupMsgReq::getGroupId));
        for (String groupId : groupedMsg.keySet()) {
            String resultContent = convertMsgListToString(groupedMsg.get(groupId));
            groupMsgMap.put(groupId, resultContent);
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
        return groupMsgMap.get(groupId);
    }
}
