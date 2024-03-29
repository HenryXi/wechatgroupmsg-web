package com.wechatgroupmsg.mapper;

import com.wechatgroupmsg.entity.ContactEntity;
import com.wechatgroupmsg.entity.ContactEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    long countByExample(ContactEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int deleteByExample(ContactEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int insert(ContactEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int insertSelective(ContactEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    List<ContactEntity> selectByExample(ContactEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    ContactEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ContactEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rcontact
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ContactEntity record);
}