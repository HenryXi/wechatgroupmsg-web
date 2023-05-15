package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.bean.GroupMsgBean;
import com.wechatgroupmsg.service.GroupMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class GroupMsgController {
    @Autowired
    private GroupMsgService groupMsgService;

    @RequestMapping(value = "/gm/{groupId}", method = RequestMethod.GET)
    @Deprecated
    public String todayGroupMsg(@PathVariable String groupId) {
        try {
            return groupMsgService.getRecentMsgByGroupId(groupId);
        } catch (Exception e) {
            log.error("todayGroupMsg:", e);
        }
        return "error";
    }

    @RequestMapping(value = "/groupMsg/{groupId}", method = RequestMethod.GET)
    public String groupMsg(@PathVariable String groupId, Model model) {
        try {
            GroupMsgBean groupMsgBean = groupMsgService.getGroupMsgByGroupId(groupId);
            model.addAttribute("groupMsgBean", groupMsgBean);
        } catch (Exception e) {
            log.error("todayGroupMsg:", e);
        }
        return "group_msg";
    }
}
