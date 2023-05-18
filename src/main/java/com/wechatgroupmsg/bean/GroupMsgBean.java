package com.wechatgroupmsg.bean;

import lombok.Data;

import java.util.List;

@Data
public class GroupMsgBean {
    private String groupId;
    private String groupName;
    private String summary;
    private List<MsgItem> msgItemList;
    private List<MsgCountItem> msgCount;

    public boolean hasMsgItems() {
        return msgItemList != null && msgItemList.size() > 0;
    }

    public boolean hasMsgCountItems() {
        return msgCount != null && msgCount.size() > 0;
    }
}
