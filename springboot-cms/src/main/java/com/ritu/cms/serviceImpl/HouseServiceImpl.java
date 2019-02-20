package com.ritu.cms.serviceImpl;

import org.springframework.stereotype.Service;

import com.ritu.cms.base.dao.impl.BaseDaoImpl;
import com.ritu.cms.base.where.Where;
import com.ritu.cms.pojo.HouseDO;
import com.ritu.cms.response.Result;
import com.ritu.cms.service.HouseService;

@Service
public class HouseServiceImpl extends BaseDaoImpl<HouseDO> implements HouseService {

	@Override
	public Result getList() {
		return null;
	}

	@Override
	public Result add() {
		return null;
	}
	
	public Result getCascadeList(){
		Where where = new Where();
		getCascadeList(where);
		return null;
	}

}
