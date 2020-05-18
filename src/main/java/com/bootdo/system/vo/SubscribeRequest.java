package com.bootdo.system.vo;

import java.util.Date;

/**
 * @author liudong
 * @Date: 2020/4/3 15:21
 * @DESC
 * @since JDK 1.8
 */
public class SubscribeRequest {
    String peopleId;
    String name;
    int sex;
    Date brithday;
    String address;
    String phone;
    int subcribeId;

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSubcribeId() {
        return subcribeId;
    }

    public void setSubcribeId(int subcribeId) {
        this.subcribeId = subcribeId;
    }
}
