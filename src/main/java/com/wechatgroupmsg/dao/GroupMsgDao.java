package com.wechatgroupmsg.dao;

import com.wechatgroupmsg.entity.GroupMsgEntity;
import com.wechatgroupmsg.entity.GroupMsgEntityExample;
import com.wechatgroupmsg.mapper.GroupMsgEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupMsgDao {
    @Autowired
    private GroupMsgEntityMapper mapper;

    public int save(GroupMsgEntity groupMsg) {
        GroupMsgEntity groupMsgInDB = selectByGroupId(groupMsg.getGroupId());
        if (groupMsgInDB == null) {
            return mapper.insert(groupMsg);
        } else {
            groupMsg.setId(groupMsgInDB.getId());
            return mapper.updateByPrimaryKeyWithBLOBs(groupMsg);
        }
    }

    public GroupMsgEntity selectByGroupId(String groupId) {
        GroupMsgEntityExample example = new GroupMsgEntityExample();
        GroupMsgEntityExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        List<GroupMsgEntity> groupMsgs = mapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(groupMsgs)) {
            return null;
        }
        return groupMsgs.get(0);
    }
}
