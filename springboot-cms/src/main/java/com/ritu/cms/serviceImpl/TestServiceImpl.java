package com.ritu.cms.serviceImpl;

import org.springframework.stereotype.Service;

import com.ritu.cms.base.dao.impl.BaseDaoImpl;
import com.ritu.cms.base.where.Where;
import com.ritu.cms.constant.ConstantResponse;
import com.ritu.cms.pojo.TestDO;
import com.ritu.cms.response.Result;
import com.ritu.cms.service.TestService;

@Service
public class TestServiceImpl extends BaseDaoImpl<TestDO> implements TestService {

	@Override
	public Result getList() {
		Result res = new Result(ConstantResponse.OK_STATUS, ConstantResponse.OK_MSG);
		Where where = new Where();
		res.setResult(list(where)); 
		res.setTotal(count(where));
		return res;
	}

	@Override
	public Result add() {
		Result res = new Result(ConstantResponse.OK_STATUS, ConstantResponse.OK_MSG);
		TestDO test = new TestDO();
		test.setName("测试");
		add(test);
		return res;
	}
}
