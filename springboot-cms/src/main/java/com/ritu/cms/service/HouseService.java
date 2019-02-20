package com.ritu.cms.service;

import com.ritu.cms.response.Result;

public interface HouseService {
	Result getList();
	
	Result add();
	
	Result getCascadeList();
}
