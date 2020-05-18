package com.bootdo.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.service.AddIntegralService;
import com.bootdo.system.service.MemberService;
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

import com.bootdo.system.domain.IntegralDO;
import com.bootdo.system.service.IntegralService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 积分明细表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 14:11:01
 */
 
@Controller
@RequestMapping("/system/integral")
public class IntegralController {
	@Autowired
	private IntegralService integralService;
	@Autowired
	private AddIntegralService addIntegralService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping()
	@RequiresPermissions("system:integral:integral")
	String Integral(){
	    return "system/integral/integral";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:integral:integral")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IntegralDO> integralList = integralService.list(query);
		int total = integralService.count(query);
		PageUtils pageUtils = new PageUtils(integralList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:integral:add")
	String add(Model model){
		model.addAttribute("members",memberService.selectVo());
	    return "system/integral/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:integral:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		IntegralDO integral = integralService.get(id);
		model.addAttribute("integral", integral);
	    return "system/integral/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:integral:add")
	public R save( IntegralDO integral){
		integral.setCreateId(ShiroUtils.getUserId().intValue());
		integral.setCreateTime(new Date());
		if(addIntegralService.addIntegral(integral)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
//	@ResponseBody
//	@RequestMapping("/update")
//	@RequiresPermissions("system:integral:edit")
//	public R update( IntegralDO integral){
//		integralService.update(integral);
//		return R.ok();
//	}
	
	/**
	 * 删除
	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("system:integral:remove")
//	public R remove( Integer id){
//		if(integralService.remove(id)>0){
//		return R.ok();
//		}
//		return R.error();
//	}
	
	/**
	 * 删除
	 */
//	@PostMapping( "/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("system:integral:batchRemove")
//	public R remove(@RequestParam("ids[]") Integer[] ids){
//		integralService.batchRemove(ids);
//		return R.ok();
//	}
	
}
