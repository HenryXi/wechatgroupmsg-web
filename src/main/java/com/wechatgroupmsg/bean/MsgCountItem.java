package com.wechatgroupmsg.bean;

import lombok.Data;

@Data
public class MsgCountItem {
    private String content;
    private Long count;

    public MsgCountItem(String content, Long count) {
        this.content = content;
        this.count = count;
    }

}
