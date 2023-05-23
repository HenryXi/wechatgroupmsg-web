package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.bean.ChatroomReq;
import com.wechatgroupmsg.bean.GroupMsgReq;
import com.wechatgroupmsg.bean.MessageReq;
import com.wechatgroupmsg.bean.RContactReq;
import com.wechatgroupmsg.service.ChatroomService;
import com.wechatgroupmsg.service.ContactService;
import com.wechatgroupmsg.service.GroupMsgService;
import com.wechatgroupmsg.service.MessageService;
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

    @Autowired
    private ContactService contactService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatroomService chatroomService;

    @RequestMapping("/upload_rcontact")
    @ResponseBody
    public String uploadContact(@RequestBody List<RContactReq> rContactReqs) {
        try {
            log.info("[uploadContact]:" + rContactReqs.size());
            contactService.saveInToDB(rContactReqs);
            return "success";
        } catch (Exception e) {
            log.error("upload:", e);
        }
        return "error";
    }

    @RequestMapping("/upload_message")
    @ResponseBody
    public String uploadMessage(@RequestBody List<MessageReq> messageReqs) {
        try {
            log.info("[uploadMessage]:" + messageReqs.size());
            messageService.saveInToDB(messageReqs);
            return "success";
        } catch (Exception e) {
            log.error("upload:", e);
        }
        return "error";
    }

    @RequestMapping("/upload_chatroom")
    @ResponseBody
    public String uploadChatroom(@RequestBody List<ChatroomReq> chatroomReqs) {
        try {
            log.info("[uploadChatroom]:" + chatroomReqs.size());
            chatroomService.saveInToDB(chatroomReqs);
            return "success";
        } catch (Exception e) {
            log.error("upload:", e);
        }
        return "error";
    }
}
