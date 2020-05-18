package com.bootdo.system.dao;

import com.bootdo.system.domain.SubscribeDO;
import com.bootdo.system.vo.UserSubscribeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 预约表
 * @author liudong
 * @email 1992lcg@163.com
 * @date 2020-04-01 10:44:06
 */
@Mapper
public interface SubscribeDao {

	SubscribeDO get(Integer id);
	
	List<SubscribeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubscribeDO subscribe);

	int saveList(@Param("list") List<SubscribeDO> subscribes);

	int update(SubscribeDO subscribe);
	
	int remove(Integer id);

	int batchRemove(Integer[] ids);

	int updateSubcribe(@Param("id") Integer id,@Param("memberId") Integer memberId);

	List<UserSubscribeVo> getUserSubscribe(@Param("groupStr") String groupString,
										   @Param("deptId") Integer deptId,
										   @Param("doctId") Integer doctId,
										   @Param("date")Date date);
    List<UserSubscribeVo> getUserSubscribeHistory(@Param("peopelId") String peopleId);
}
