package com.wechatgroupmsg.dao;

import com.wechatgroupmsg.entity.GroupMsg;
import com.wechatgroupmsg.entity.GroupMsgExample;
import com.wechatgroupmsg.mapper.GroupMsgMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupMsgDao {
    @Autowired
    private GroupMsgMapper mapper;

    public int save(GroupMsg groupMsg) {
        return mapper.insert(groupMsg);
    }

    public int update(GroupMsg groupMsg) {
        GroupMsg groupMsgInDB = selectByGroupId(groupMsg.getGroupId());
        if (groupMsgInDB == null) {
            return 0;
        }
        groupMsg.setId(groupMsg.getId());
        return mapper.updateByPrimaryKeyWithBLOBs(groupMsg);
    }

    public GroupMsg selectByGroupId(String groupId) {
        GroupMsgExample example = new GroupMsgExample();
        GroupMsgExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        List<GroupMsg> groupMsgs = mapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(groupMsgs)) {
            return null;
        }
        return groupMsgs.get(0);
    }
}
