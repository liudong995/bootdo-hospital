package com.bootdo.system.service.impl;

import com.bootdo.system.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.MemberDao;
import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.service.MemberService;



@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDO get(Integer id){
		return memberDao.get(id);
	}

	@Override
	public MemberDO getModel(String id){
		return memberDao.getModel(id);
	}
	
	@Override
	public List<MemberDO> list(Map<String, Object> map){
		return memberDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberDao.count(map);
	}
	
	@Override
	public int save(MemberDO member){
		return memberDao.save(member);
	}
	
	@Override
	public int update(MemberDO member){
		return memberDao.update(member);
	}
	
	@Override
	public int remove(Integer id){
		return memberDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return memberDao.batchRemove(ids);
	}

	@Override
	public List<MemberVO> selectVo() {
		return memberDao.selectVo();
	}

}
