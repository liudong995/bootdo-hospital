package com.bootdo.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;



/**
 * 预约表
 * 
 * @author liudong
 * @email 1992lcg@163.com
 * @date 2020-04-01 10:44:06
 */
public class SubscribeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//医生
	private Long userId;

	String userName;
	//病人
	private Integer memberId;

	String memberName;
	//时间段
	private Integer dictId;

	String dictValue;
	//时间（天）
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	//是否接待
	private Integer isReceive;

	//
	private Long createId;
	//
	private Date createTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：医生
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：医生
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：病人
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：病人
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：时间段
	 */
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：时间段
	 */
	public Integer getDictId() {
		return dictId;
	}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
	 * 设置：是否接待
	 */
	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}
	/**
	 * 获取：是否接待
	 */
	public Integer getIsReceive() {
		return isReceive;
	}
}
