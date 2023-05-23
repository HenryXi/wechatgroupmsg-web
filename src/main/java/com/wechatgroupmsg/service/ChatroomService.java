package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.ChatroomReq;
import com.wechatgroupmsg.dao.ChatroomDao;
import com.wechatgroupmsg.entity.ChatroomEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChatroomService {

    @Autowired
    private ChatroomDao chatroomDao;
    public void saveInToDB(List<ChatroomReq> chatroomReqs) {
        if (CollectionUtils.isEmpty(chatroomReqs)) {
            return;
        }
        List<ChatroomEntity> tobeSavedChatrooms = chatroomReqs.stream()
                .map(this::convert).collect(Collectors.toList());
        chatroomDao.batchSave(tobeSavedChatrooms);
    }

    private ChatroomEntity convert(ChatroomReq chatroomReq) {
        ChatroomEntity entity = new ChatroomEntity();
        entity.setChatroomname(chatroomReq.getChatroomname());
        entity.setMemberlist(chatroomReq.getMemberlist());
        entity.setRoomowner(chatroomReq.getRoomowner());
        entity.setUpdateTime(chatroomReq.getUpdateTime());
        return entity;
    }
}
