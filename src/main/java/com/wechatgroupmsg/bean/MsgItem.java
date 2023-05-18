package com.wechatgroupmsg.bean;

import lombok.Data;

@Data
public class MsgItem {
    private String createTime;
    private String sender;
    private String content;
}
