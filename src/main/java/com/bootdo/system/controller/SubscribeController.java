package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.SubscribeVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.SubscribeDO;
import com.bootdo.system.service.SubscribeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 预约表
 * 
 * @author liudong
 * @email 1992lcg@163.com
 * @date 2020-04-01 10:44:06
 */
 
@Controller
@RequestMapping("/system/subscribe")
public class SubscribeController {
	@Autowired
	private SubscribeService subscribeService;
	@Autowired
	DictService dictService;
	@Autowired
	UserService userService;
	
	@GetMapping()
	@RequiresPermissions("system:subscribe:subscribe")
	String Subscribe(){
	    return "system/subscribe/subscribe";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:subscribe:subscribe")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubscribeDO> subscribeList = subscribeService.list(query);
		int total = subscribeService.count(query);
		PageUtils pageUtils = new PageUtils(subscribeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:subscribe:add")
	String add(Model model){
		model.addAttribute("doctors",userService.getDoctors());
		model.addAttribute("timeList",dictService.listByType("time_group"));
		return "system/subscribe/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:subscribe:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SubscribeDO subscribe = subscribeService.get(id);
		model.addAttribute("subscribe", subscribe);
	    return "system/subscribe/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:subscribe:add")
	public R save( SubscribeVo subscribe){
		if(subscribeService.save(subscribe, ShiroUtils.getUserId())>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:subscribe:edit")
	public R update( SubscribeDO subscribe){
		subscribeService.update(subscribe);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:subscribe:remove")
	public R remove( Integer id){
		if(subscribeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 接待
	 * @param id
	 * @return
	 */
	@PostMapping( "/receive")
	@ResponseBody
	@RequiresPermissions("system:subscribe:receive")
	public R receive( Integer id){
		if(subscribeService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:subscribe:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		subscribeService.batchRemove(ids);
		return R.ok();
	}
	
}
