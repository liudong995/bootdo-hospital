package com.bootdo.system.vo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liudong
 * @Date: 2020/4/1 17:19
 * @DESC 预约添加类
 * @since JDK 1.8
 */
public class SubscribeVo {
    List<Long> userIds;
    String date;
    List<Integer> dictIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Integer> getDictIds() {
        return dictIds;
    }

    public void setDictIds(List<Integer> dictIds) {
        this.dictIds = dictIds;
    }
}
