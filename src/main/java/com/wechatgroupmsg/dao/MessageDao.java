package com.wechatgroupmsg.dao;

import com.wechatgroupmsg.entity.MessageEntity;
import com.wechatgroupmsg.entity.MessageEntityExample;
import com.wechatgroupmsg.mapper.MessageEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageDao {

    @Autowired
    private MessageEntityMapper messageEntityMapper;

    public void batchSave(List<MessageEntity> tobeSavedMessages) {
        for (MessageEntity entity : tobeSavedMessages) {
            save(entity);
        }
    }

    public void save(MessageEntity messageEntity) {
        try {
            if (messageExist(messageEntity.getMsgSvrId())) {
                return;
            }
            messageEntityMapper.insert(messageEntity);
        } catch (Exception e) {
            log.error("[save]error,", e);
        }
    }

    public boolean messageExist(String msgSvrId) {
        MessageEntityExample example = new MessageEntityExample();
        MessageEntityExample.Criteria criteria = example.createCriteria();
        criteria.andMsgSvrIdEqualTo(msgSvrId);
        return messageEntityMapper.countByExample(example) > 0;
    }

    public List<MessageEntity> queryLastestMessages(String chatroomName, long latestTimestamp) {
        MessageEntityExample example = new MessageEntityExample();
        MessageEntityExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeGreaterThan(latestTimestamp);
        criteria.andTalkerEqualTo(chatroomName);
        example.setOrderByClause("create_time desc");
        return messageEntityMapper.selectByExample(example);
    }
}
