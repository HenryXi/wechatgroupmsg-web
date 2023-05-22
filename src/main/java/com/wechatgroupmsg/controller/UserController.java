package com.wechatgroupmsg.controller;

import com.wechatgroupmsg.bean.RegisterReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Slf4j
public class UserController {

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody RegisterReq registerReq) {
        return "";
    }
}
