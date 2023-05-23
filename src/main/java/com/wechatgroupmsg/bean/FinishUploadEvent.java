package com.wechatgroupmsg.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class FinishUploadEvent {

    public FinishUploadEvent(List<String> newMsgChatroomNames) {
        this.newMsgChatroomNames = newMsgChatroomNames;
    }

    private List<String> newMsgChatroomNames;


    public static FinishUploadEvent of(List<MessageReq> messageReqs) {
        List<String> chatroomNames = messageReqs.stream().map(MessageReq::getTalker)
                .filter(s -> !StringUtils.startsWith(s, "wxid") && StringUtils.contains(s, "@chatroom")).distinct().collect(Collectors.toList());
        return new FinishUploadEvent(chatroomNames);
    }
}
