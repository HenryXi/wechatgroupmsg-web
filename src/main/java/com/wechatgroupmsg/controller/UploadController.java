package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.bean.GroupMsgReq;
import com.wechatgroupmsg.service.GroupMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private GroupMsgService groupMsgService;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestBody List<GroupMsgReq> groupMsgReqList) {
        //todo change request body: group_info + msg_info
        try {
            log.info("[upload]:" + groupMsgReqList.size());
            groupMsgService.saveInToDB(groupMsgReqList);
            return "success";
        } catch (Exception e) {
            log.error("upload:", e);
        }
        return "error";
    }
}
