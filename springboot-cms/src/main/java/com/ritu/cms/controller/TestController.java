package com.ritu.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritu.cms.base.vo.Res;
import com.ritu.cms.common.utils.CommonUtils;
import com.ritu.cms.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;
	
	@ResponseBody
	@RequestMapping("/test/list")
	public String selectTest(){
		return CommonUtils.filterNullToResponse(testService.getList(), Res.JSON.getType());
	}
	
	@ResponseBody
	@RequestMapping("/test/add")
	public String add(){
		return CommonUtils.filterNullToResponse(testService.add(), Res.JSON.getType());
	}
}
