package com.bootdo.system.service;

import com.bootdo.system.domain.IntegralDO;

import java.util.List;
import java.util.Map;

/**
 * 积分明细表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 14:11:01
 */
public interface IntegralService {
	
	IntegralDO get(Integer id);
	
	List<IntegralDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IntegralDO integral);
	
	int update(IntegralDO integral);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
