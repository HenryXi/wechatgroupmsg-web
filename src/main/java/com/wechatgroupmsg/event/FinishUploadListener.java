package com.wechatgroupmsg.event;

import com.wechatgroupmsg.bean.FinishUploadEvent;
import com.wechatgroupmsg.service.GroupMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FinishUploadListener {

    @Autowired
    private GroupMsgService groupMsgService;


        @EventListener
    public void myEvent(PayloadApplicationEvent<FinishUploadEvent> payloadApplicationEvent) {
            FinishUploadEvent finishUploadEvent = payloadApplicationEvent.getPayload();
            groupMsgService.prepareData(finishUploadEvent.getNewMsgChatroomNames());
        }

}
