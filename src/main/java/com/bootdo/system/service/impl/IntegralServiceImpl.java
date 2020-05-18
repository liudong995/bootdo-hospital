package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.IntegralDao;
import com.bootdo.system.domain.IntegralDO;
import com.bootdo.system.service.IntegralService;



@Service
public class IntegralServiceImpl implements IntegralService {
	@Autowired
	private IntegralDao integralDao;
	
	@Override
	public IntegralDO get(Integer id){
		return integralDao.get(id);
	}
	
	@Override
	public List<IntegralDO> list(Map<String, Object> map){
		return integralDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return integralDao.count(map);
	}
	
	@Override
	public int save(IntegralDO integral){
		return integralDao.save(integral);
	}
	
	@Override
	public int update(IntegralDO integral){
		return integralDao.update(integral);
	}
	
	@Override
	public int remove(Integer id){
		return integralDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return integralDao.batchRemove(ids);
	}
	
}
