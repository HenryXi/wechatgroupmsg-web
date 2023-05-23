package com.wechatgroupmsg.service;

import com.wechatgroupmsg.bean.RContactReq;
import com.wechatgroupmsg.dao.ContactDao;
import com.wechatgroupmsg.entity.ContactEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    public void saveInToDB(List<RContactReq> contactReqs) {
        if (CollectionUtils.isEmpty(contactReqs)) {
            return;
        }
        List<ContactEntity> contactEntityList = contactReqs.stream()
                .map(this::convert).collect(Collectors.toList());
        contactDao.batchSave(contactEntityList);
    }

    private ContactEntity convert(RContactReq contactReq) {
        ContactEntity entity = new ContactEntity();
        entity.setNickname(contactReq.getNickname());
        entity.setUsername(contactReq.getUsername());
        entity.setUpdateTime(System.currentTimeMillis());
        return entity;
    }
}
