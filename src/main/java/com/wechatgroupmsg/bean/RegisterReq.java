package com.wechatgroupmsg.bean;

import lombok.Data;

@Data
public class RegisterReq {
    private String mail;
    private String password;
    private String verifyCode;
}
