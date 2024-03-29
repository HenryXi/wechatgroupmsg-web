package com.wechatgroupmsg.entity;

public class MessageEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.msg_svr_id
     *
     * @mbg.generated
     */
    private String msgSvrId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.talker
     *
     * @mbg.generated
     */
    private String talker;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.create_time
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.msg_svr_id
     *
     * @return the value of message.msg_svr_id
     *
     * @mbg.generated
     */
    public String getMsgSvrId() {
        return msgSvrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.msg_svr_id
     *
     * @param msgSvrId the value for message.msg_svr_id
     *
     * @mbg.generated
     */
    public void setMsgSvrId(String msgSvrId) {
        this.msgSvrId = msgSvrId == null ? null : msgSvrId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.talker
     *
     * @return the value of message.talker
     *
     * @mbg.generated
     */
    public String getTalker() {
        return talker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.talker
     *
     * @param talker the value for message.talker
     *
     * @mbg.generated
     */
    public void setTalker(String talker) {
        this.talker = talker == null ? null : talker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.create_time
     *
     * @return the value of message.create_time
     *
     * @mbg.generated
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.create_time
     *
     * @param createTime the value for message.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.content
     *
     * @return the value of message.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.content
     *
     * @param content the value for message.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}