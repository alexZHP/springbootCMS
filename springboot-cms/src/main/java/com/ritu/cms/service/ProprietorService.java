package com.ritu.cms.service;

import com.ritu.cms.response.Result;

public interface ProprietorService {
	Result getList();
	
	Result add();
	
	Result update();
	
	Result delete();
}
