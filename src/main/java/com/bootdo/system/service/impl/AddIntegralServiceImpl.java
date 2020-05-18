package com.bootdo.system.service.impl;

import com.bootdo.system.dao.IntegralDao;
import com.bootdo.system.dao.MemberDao;
import com.bootdo.system.domain.IntegralDO;
import com.bootdo.system.service.AddIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liudong
 * @Date: 2020/3/31 14:30
 * @DESC
 * @since JDK 1.8
 */
@Service
public class AddIntegralServiceImpl implements AddIntegralService {
    @Autowired
    private IntegralDao integralDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addIntegral(IntegralDO model) {
        int a = integralDao.save(model);
        if (a>0){
            return memberDao.addIntegral(model.getMemberId(),model.getNumber());
        }
        return a;
    }
}
