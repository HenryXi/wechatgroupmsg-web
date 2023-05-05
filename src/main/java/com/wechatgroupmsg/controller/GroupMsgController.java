package com.wechatgroupmsg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GroupMsgController {
    @RequestMapping(value = "/gm/{groupMaster}", method = RequestMethod.GET)
    public String todayGroupMsg(@PathVariable String groupMaster) {
        try {
            return groupMaster;
        } catch (Exception e) {
            log.error("todayGroupMsg:", e);
        }
        return "error";
    }
}
