package com.bootdo.system.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.ShiroUtils;
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

import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.service.MemberService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 会员表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 09:34:34
 */
 
@Controller
@RequestMapping("/system/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	DictService dictService;

	@GetMapping()
	@RequiresPermissions("system:member:member")
	String Member(){
	    return "system/member/member";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:member:member")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberDO> memberList = memberService.list(query);
		int total = memberService.count(query);
		PageUtils pageUtils = new PageUtils(memberList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:member:add")
	String add(Model model){
		model.addAttribute("sexList",dictService.getSexList());
		return "system/member/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:member:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		MemberDO member = memberService.get(id);
		model.addAttribute("member", member);

		model.addAttribute("sexList",dictService.getSexList());
	    return "system/member/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:member:add")
	public R save( MemberDO member){
		member.setIntegral(0);
		member.setCreateId(ShiroUtils.getUserId().intValue());
		member.setCreateTime(new Date());
		member.setUpdateId(member.getCreateId());
		member.setUpdateTime(member.getCreateTime());
		if(memberService.save(member)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:member:edit")
	public R update( MemberDO member){
		//禁止直接修改积分数据
		member.setIntegral(null);
		member.setUpdateId(ShiroUtils.getUserId().intValue());
		member.setUpdateTime(new Date());
		memberService.update(member);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:member:remove")
	public R remove( Integer id){
		if(memberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:member:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		memberService.batchRemove(ids);
		return R.ok();
	}
	
}
