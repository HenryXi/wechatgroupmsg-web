package com.wechatgroupmsg.bean;

import lombok.Data;

import java.util.List;

@Data
public class GroupMsgBean {
    private String groupName;
    private String summary;
    private List<MsgBean> msgBeanList;
}
