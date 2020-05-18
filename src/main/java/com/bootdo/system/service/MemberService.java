package com.bootdo.system.service;

import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.vo.MemberVO;

import java.util.List;
import java.util.Map;

/**
 * 会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 09:34:34
 */
public interface MemberService {
	
	MemberDO get(Integer id);

	MemberDO getModel(String peopleId);

	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<MemberVO> selectVo();
}
