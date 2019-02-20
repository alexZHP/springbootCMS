package com.ritu.cms.serviceImpl;

import org.springframework.stereotype.Service;

import com.ritu.cms.base.dao.impl.BaseDaoImpl;
import com.ritu.cms.base.where.Where;
import com.ritu.cms.constant.ConstantResponse;
import com.ritu.cms.pojo.ProprietorDO;
import com.ritu.cms.response.Result;
import com.ritu.cms.service.ProprietorService;

@Service
public class ProprietorServiceImpl extends BaseDaoImpl<ProprietorDO> implements ProprietorService {

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
		ProprietorDO test = new ProprietorDO();
		test.setName("测试");
		test.setBankCard("45453487");
		test.setBankName("广发银行");
		test.setIntentionality(3);
		test.setSettlementCycle("1");
		add(test);
		return res;
	}

	@Override
	public Result update() {
		Result res = new Result(ConstantResponse.OK_STATUS, ConstantResponse.OK_MSG);
		ProprietorDO test = new ProprietorDO();
		test.setName("测试");
		test.setBankCard("123456789");
		test.setBankName("光大银行");
		test.setIntentionality(2);
		test.setSettlementCycle("2");
		test.setId(1);
		update(test);
		return res;
	}

	@Override
	public Result delete() {
		Result res = new Result(ConstantResponse.OK_STATUS, ConstantResponse.OK_MSG);
		ProprietorDO test = new ProprietorDO();
		test.setId(1);
		delete(test.getId());
		return res;
	}
	
}
