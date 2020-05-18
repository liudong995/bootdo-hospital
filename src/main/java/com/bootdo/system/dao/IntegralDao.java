package com.bootdo.system.dao;

import com.bootdo.system.domain.IntegralDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 积分明细表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 14:11:01
 */
@Mapper
public interface IntegralDao {

	IntegralDO get(Integer id);
	
	List<IntegralDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(IntegralDO integral);
	
	int update(IntegralDO integral);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
