package com.bootdo.system.service;

import com.bootdo.system.domain.IntegralDO;

/**
 * @author liudong
 * @Date: 2020/3/31 14:29
 * @DESC
 * @since JDK 1.8
 */
public interface AddIntegralService {
    /**
     * 增加积分
     * @param model
     * @return
     */
    int addIntegral(IntegralDO model);
}
