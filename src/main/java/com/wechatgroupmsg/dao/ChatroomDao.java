package com.wechatgroupmsg.dao;

import com.wechatgroupmsg.entity.ChatroomEntity;
import com.wechatgroupmsg.entity.ChatroomEntityExample;
import com.wechatgroupmsg.mapper.ChatroomEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatroomDao {

    @Autowired
    private ChatroomEntityMapper chatroomEntityMapper;

    public void batchSave(List<ChatroomEntity> tobeSavedChatrooms) {
        log.info("[batchSave]:"+tobeSavedChatrooms);
        for (ChatroomEntity entity : tobeSavedChatrooms) {
            save(entity);
        }
    }

    public void save(ChatroomEntity entity) {
        try {
            if (chatroomExist(entity.getChatroomname())) {
                ChatroomEntityExample example = new ChatroomEntityExample();
                ChatroomEntityExample.Criteria criteria = example.createCriteria();
                criteria.andChatroomnameEqualTo(entity.getChatroomname());
                chatroomEntityMapper.updateByExampleSelective(entity, example);
                return;
            }
            chatroomEntityMapper.insert(entity);
        } catch (Exception e) {
            log.error("[save]error,", e);
        }
    }

    private boolean chatroomExist(String chatroomName) {
        ChatroomEntityExample example = new ChatroomEntityExample();
        ChatroomEntityExample.Criteria criteria = example.createCriteria();
        criteria.andChatroomnameEqualTo(chatroomName);
        return chatroomEntityMapper.countByExample(example) > 0;
    }
}
