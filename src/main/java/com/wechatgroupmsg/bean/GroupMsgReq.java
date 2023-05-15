package com.wechatgroupmsg.bean;

import lombok.Data;

@Data
public class GroupMsgReq {
    private String msgSvrId ;
    private long createTime ;
    private String groupName ;
    private String groupId ;
    private String sender ;
    private String content ;

}
