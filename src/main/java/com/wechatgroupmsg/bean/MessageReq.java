package com.wechatgroupmsg.bean;

import lombok.Data;

@Data
public class MessageReq {
    private String msgSvrId;
    private long createTime;
    private String talker;
    private String content;
}
