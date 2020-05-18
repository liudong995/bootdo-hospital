package com.bootdo.system.dao;

import com.bootdo.system.domain.MemberDO;

import java.util.List;
import java.util.Map;

import com.bootdo.system.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 09:34:34
 */
@Mapper
public interface MemberDao {

	MemberDO get(Integer id);

	MemberDO getModel(String peopleId);

	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int addIntegral(@Param("id") int id ,@Param("integral") int integral);

	List<MemberVO> selectVo();
}
