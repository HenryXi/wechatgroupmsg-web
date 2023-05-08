package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.service.GroupMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GroupMsgController {
    @Autowired
    private GroupMsgService groupMsgService;

    @RequestMapping(value = "/gm/{groupId}", method = RequestMethod.GET)
    public String todayGroupMsg(@PathVariable String groupId) {
        try {
            return groupMsgService.getRecentMsgByGroupId(groupId);
        } catch (Exception e) {
            log.error("todayGroupMsg:", e);
        }
        return "error";
    }
}
