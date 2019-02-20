package com.ritu.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritu.cms.base.vo.Res;
import com.ritu.cms.common.utils.CommonUtils;
import com.ritu.cms.service.HouseService;

@RestController
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@ResponseBody
	@RequestMapping("/house/cascade")
	public String add(){
		return CommonUtils.filterNullToResponse(houseService.getCascadeList(), Res.JSON.getType());
	}
}
