package com.bootdo.blog.controller;

import com.bootdo.blog.domain.ContentDO;
import com.bootdo.blog.service.ContentService;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.MemberDO;
import com.bootdo.system.service.MemberService;
import com.bootdo.system.service.SubscribeService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.SubscribeRequest;
import com.bootdo.system.vo.UserSubscribeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bootdo 1992lcg@163.com
 */
@RequestMapping("/blog")
@Controller
public class BlogController {
	@Autowired
    ContentService bContentService;
	@Autowired
	UserService userService;
	@Autowired
	DictService dictService;
	@Autowired
	SubscribeService subscribeService;
	@Autowired
	MemberService memberService;
	@GetMapping()
	String blog() {
		return "blog/index/main";
	}

	@ResponseBody
	@GetMapping("/open/list")
	public PageUtils opentList(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<ContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);
		PageUtils pageUtils = new PageUtils(bContentList, total);
		return pageUtils;
	}

	@GetMapping("/open/post/{cid}")
	String post(@PathVariable("cid") Long cid, Model model) {
		ContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		model.addAttribute("gtmModified", DateUtils.format(bContentDO.getGtmModified()));
		return "blog/index/post";
	}
	@GetMapping("/open/page/{categories}")
	String about(@PathVariable("categories") String categories, Model model) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("categories", categories);
		ContentDO bContentDO =null;
		if(bContentService.list(map).size()>0){
			 bContentDO = bContentService.list(map).get(0);
		}
		model.addAttribute("bContent", bContentDO);
		return "blog/index/post";
	}


	@GetMapping("/open/userSubscribe")
	String userSubscribe(Model model) {
		List<HashMap> userSubscribeVos = subscribeService.getUserSubcirbe();
		model.addAttribute("subscribes",userSubscribeVos);
		model.addAttribute("sexList",dictService.getSexList());
		model.addAttribute("doctors",userService.getDoctors());
		return "blog/index/userSubscribe";
	}
	@ResponseBody
	@PostMapping("/open/userSubscribe/getMessage")
	MemberDO getPeopleMessage(String peopleId) {
		return memberService.getModel(peopleId);
	}

	@ResponseBody
	@GetMapping("/userSubscribe/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<UserSubscribeVo> subscribeList = subscribeService.getUserSubscribeHistory(params.get("peopleId").toString());
		int total = subscribeList.size();
		PageUtils pageUtils = new PageUtils(subscribeList, total);
		return pageUtils;
	}

	@ResponseBody
	@PostMapping("/open/userSubscribe/save")
	R save(SubscribeRequest request) {
		if(subscribeService.userSave(request)>0){
			return R.ok();
		}
		return R.error("时间已被占用，请选择其它时间段");
	}
}
