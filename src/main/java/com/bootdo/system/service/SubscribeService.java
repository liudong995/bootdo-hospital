package com.bootdo.system.service;

import com.bootdo.system.domain.SubscribeDO;
import com.bootdo.system.vo.SubscribeRequest;
import com.bootdo.system.vo.SubscribeVo;
import com.bootdo.system.vo.UserSubscribeVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预约表
 * 
 * @author liudong
 * @email 1992lcg@163.com
 * @date 2020-04-01 10:44:06
 */
public interface SubscribeService {
	
	SubscribeDO get(Integer id);
	
	List<SubscribeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubscribeVo subscribe,long createId);
	
	int update(SubscribeDO subscribe);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    List<HashMap> getUserSubcirbe();

    List<UserSubscribeVo> getUserSubscribeHistory(String peopleId);

	/**
	 * 用户预约
	 * @param request
	 * @return
	 */
    int userSave(SubscribeRequest request);
}
