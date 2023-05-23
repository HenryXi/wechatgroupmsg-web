package com.wechatgroupmsg.dao;

import com.wechatgroupmsg.entity.ContactEntity;
import com.wechatgroupmsg.entity.ContactEntityExample;
import com.wechatgroupmsg.mapper.ContactEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactDao {

    @Autowired
    private ContactEntityMapper contactEntityMapper;

    public void batchSave(List<ContactEntity> contactEntityList) {
        for (ContactEntity entity : contactEntityList) {
            save(entity);
        }
    }

    public void save(ContactEntity entity) {
        try {
            if (userExist(entity)) {
                return;
            }
            contactEntityMapper.insert(entity);
        } catch (Exception e) {
            log.error("[save]error,", e);
        }
    }

    public boolean userExist(ContactEntity contactEntity) {
        ContactEntityExample example = new ContactEntityExample();
        ContactEntityExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(contactEntity.getUsername());
        criteria.andNicknameEqualTo(contactEntity.getNickname());
        return contactEntityMapper.countByExample(example) > 0;
    }

    public List<ContactEntity> queryByUserNames(List<String> newMsgChatroomNames) {
        ContactEntityExample example = new ContactEntityExample();
        ContactEntityExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameIn(newMsgChatroomNames);
        return contactEntityMapper.selectByExample(example);
    }
}
