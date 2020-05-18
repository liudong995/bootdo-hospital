package com.bootdo.system.service.impl;

import com.bootdo.system.dao.MemberDao;
import com.bootdo.system.dao.SubscribeDao;
import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.domain.SubscribeDO;
import com.bootdo.system.service.SubscribeService;
import com.bootdo.system.vo.SubscribeRequest;
import com.bootdo.system.vo.SubscribeVo;
import com.bootdo.system.vo.UserSubscribeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;


@Service
public class SubscribeServiceImpl implements SubscribeService {
	@Autowired
	private SubscribeDao subscribeDao;
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public SubscribeDO get(Integer id){
		return subscribeDao.get(id);
	}
	
	@Override
	public List<SubscribeDO> list(Map<String, Object> map){
		return subscribeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subscribeDao.count(map);
	}
	
	@Override
	public int save(SubscribeVo subscribe,long createId){
		String[] dates =subscribe.getDate().split(" - ");
		List<LocalDate> localDates = new ArrayList<>();
		LocalDate startDate = LocalDate.parse(dates[0]);
		LocalDate endDate = LocalDate.parse(dates[1]);
		localDates.add(startDate);
		while (endDate.isAfter(startDate)){
			startDate = startDate.plusDays(1);
			localDates.add(startDate);
		}
		Date date = new Date();
		List<SubscribeDO> models = new ArrayList<>();
		SubscribeDO model = null;
		for (LocalDate localDate : localDates){
			for (Long userId:subscribe.getUserIds()){
				for (int dictId:subscribe.getDictIds()){
					model = new SubscribeDO();
					model.setDate(localDateToDate(localDate));
					model.setCreateId(createId);
					model.setCreateTime(date);
					model.setUserId(userId);
					model.setDictId(dictId);
					models.add(model);
				}
			}
		}
		return subscribeDao.saveList(models);
	}
	
	@Override
	public int update(SubscribeDO subscribe){
		return subscribeDao.update(subscribe);
	}
	
	@Override
	public int remove(Integer id){
		return subscribeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return subscribeDao.batchRemove(ids);
	}
	@Override
	public List<HashMap> getUserSubcirbe(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<UserSubscribeVo> list =  subscribeDao.getUserSubscribe("sd.dept_id",null,null,null);
		List<HashMap> modelMap = new ArrayList<>();
		for (UserSubscribeVo model:list){
			HashMap<String,Object> modelModel = new HashMap<>(16);
			List<UserSubscribeVo> doctors = subscribeDao.getUserSubscribe("sd.dept_id,su.user_id",model.getDeptId(),null,null);
			List<HashMap> doctorMap = new ArrayList<>();
			for (UserSubscribeVo doctor:doctors){
				HashMap<String,Object> doctorModel = new HashMap<>(16);
				List<UserSubscribeVo> dates = subscribeDao.getUserSubscribe("sd.dept_id,su.user_id,bs.date",model.getDeptId(),doctor.getDoctId(),null);
				List<HashMap> dateMap = new ArrayList<>();

				for (UserSubscribeVo date:dates){
					HashMap<String,Object> dateModel = new HashMap<>(16);
					//根据时间出具体数据
					List<UserSubscribeVo> dicts = subscribeDao.getUserSubscribe("sd.dept_id,su.user_id,bs.date,bs.id",model.getDeptId(),doctor.getDoctId(),date.getDate());
					List<HashMap> dictMap = new ArrayList<>();

					for (UserSubscribeVo dict:dicts){
						HashMap<String,Object> dictModel = new HashMap<>(16);
						dictModel.put("id",dict.getId());
						dictModel.put("dictValue",dict.getDictValue());
						dictMap.add(dictModel);
					}

					dateModel.put("key",dateFormat.format(date.getDate()));
					dateModel.put("value",dictMap);
					dateMap.add(dateModel);
				}
				doctorModel.put("key",doctor.getDoctorName());
				doctorModel.put("value",dateMap);
				doctorMap.add(doctorModel);
			}
			modelModel.put("key",model.getDeptName());
			modelModel.put("value",doctorMap);
			modelMap.add(modelModel);
		}
		return modelMap;
	}
    @Override
    public List<UserSubscribeVo> getUserSubscribeHistory(String peopleId) {
        return subscribeDao.getUserSubscribeHistory(peopleId);
    }

    @Transactional(rollbackFor = Exception.class)
	@Override
	public int userSave(SubscribeRequest request) {
		//查询是否存在会员 存在则修改 不存在则创建
		MemberDO member = memberDao.getModel(request.getPeopleId());
		if (member!=null){
			member.setName(request.getName());
			member.setAddress(request.getAddress());
			member.setBirthday(request.getBrithday());
			member.setPhone(request.getPhone());
			member.setIntegral(null);
			memberDao.update(member);
		}else {
			member = new MemberDO();
			member.setPeopleId(request.getPeopleId());
			member.setName(request.getName());
			member.setAddress(request.getAddress());
			member.setBirthday(request.getBrithday());
			member.setPhone(request.getPhone());
			member.setIntegral(null);
			memberDao.save(member);
		}
		//开始占用预约
		int result = subscribeDao.updateSubcribe(request.getSubcribeId(),member.getId());
		return result;
	}

	private static Date localDateToDate(LocalDate localDate) {
		if(null == localDate) {
			return null;
		}
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
		return Date.from(zonedDateTime.toInstant());
	}
	
}
