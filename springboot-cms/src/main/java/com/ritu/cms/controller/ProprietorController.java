package com.ritu.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritu.cms.base.vo.Res;
import com.ritu.cms.common.utils.CommonUtils;
import com.ritu.cms.service.ProprietorService;

@RestController
public class ProprietorController {
	@Autowired
	private ProprietorService proprietorService;
	
	@ResponseBody
	@RequestMapping("/proprietor/list")
	public String selectTest(){
		return CommonUtils.filterNullToResponse(proprietorService.getList(), Res.JSON.getType());
	}
	
	@ResponseBody
	@RequestMapping("/proprietor/add")
	public String add(){
		return CommonUtils.filterNullToResponse(proprietorService.add(), Res.JSON.getType());
	}
	
	@ResponseBody
	@RequestMapping("/proprietor/update")
	public String update(){
		return CommonUtils.filterNullToResponse(proprietorService.update(), Res.JSON.getType());
	}
	
	@ResponseBody
	@RequestMapping("/proprietor/delete")
	public String delete(){
		return CommonUtils.filterNullToResponse(proprietorService.delete(), Res.JSON.getType());
	}
}
