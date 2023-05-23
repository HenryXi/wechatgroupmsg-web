package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.MessageReq;
import com.wechatgroupmsg.dao.MessageDao;
import com.wechatgroupmsg.entity.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public void saveInToDB(List<MessageReq> messageReqs) {
        if (CollectionUtils.isEmpty(messageReqs)) {
            return;
        }
        List<MessageEntity> tobeSavedMessages = messageReqs.stream().map(this::convert).collect(Collectors.toList());
        messageDao.batchSave(tobeSavedMessages);
    }

    private MessageEntity convert(MessageReq messageReq) {
        MessageEntity entity = new MessageEntity();
        entity.setContent(messageReq.getContent());
        entity.setCreateTime(messageReq.getCreateTime());
        entity.setMsgSvrId(messageReq.getMsgSvrId());
        entity.setTalker(messageReq.getTalker());
        return entity;
    }
}
