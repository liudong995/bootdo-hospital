package com.bootdo.system.vo;

import java.util.Date;
import java.util.List;

/**
 * @author liudong
 * @Date: 2020/4/2 14:34
 * @DESC
 * @since JDK 1.8
 */
public class UserSubscribeVo {
    int deptId;
    String deptName;
    int doctId;
    String doctorName;
    Date date;
    int id;
    String dictValue;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDoctId() {
        return doctId;
    }

    public void setDoctId(int doctId) {
        this.doctId = doctId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
