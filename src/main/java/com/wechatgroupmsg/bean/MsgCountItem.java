package com.wechatgroupmsg.bean;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MsgCountItem {
    private String content;
    private Long count;

    public MsgCountItem(String content, Long count) {
        if (content.length() > 18) {
            content = StringUtils.substring(content, 0, 18) + "...";
        }
        this.content = content;
        this.count = count;
    }

}
