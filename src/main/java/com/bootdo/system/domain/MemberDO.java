package com.bootdo.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 09:34:34
 */
public class MemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//名字
	private String name;
	//性别(0 男 1女)
	private Integer sex;
	//生日
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	//地址
	private String address;
	//身份证号
	private String peopleId;
	//现有积分
	private Integer integral;
	//图片
	private String img;
	//
	private Integer createId;
	//
	private Date createTime;
	//
	private Integer updateId;
	//
	private Date updateTime;

	String phone;


	String createName;
	String updateName;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	 * 设置：名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别(0 男 1女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0 男 1女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：身份证号
	 */
	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}
	/**
	 * 获取：身份证号
	 */
	public String getPeopleId() {
		return peopleId;
	}
	/**
	 * 设置：现有积分
	 */
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	/**
	 * 获取：现有积分
	 */
	public Integer getIntegral() {
		return integral;
	}
	/**
	 * 设置：图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateId() {
		return createId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateId() {
		return updateId;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
}
