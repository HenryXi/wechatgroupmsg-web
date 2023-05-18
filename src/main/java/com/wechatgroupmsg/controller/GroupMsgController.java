package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.bean.GroupMsgBean;
import com.wechatgroupmsg.service.GroupMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GroupMsgController {
    @Autowired
    private GroupMsgService groupMsgService;

    @RequestMapping(value = "/groupMsg/{groupId}", method = RequestMethod.GET)
    public String groupMsg(@PathVariable String groupId, @RequestParam(name = "s", defaultValue = "") String searchWord, Model model) {
        try {
            GroupMsgBean groupMsgBean = groupMsgService.getGroupMsgByGroupId(groupId, searchWord);
            model.addAttribute("groupMsgBean", groupMsgBean);
            model.addAttribute("searchWord", searchWord);
        } catch (Exception e) {
            log.error("todayGroupMsg:", e);
        }
        return "group_msg";
    }
}
