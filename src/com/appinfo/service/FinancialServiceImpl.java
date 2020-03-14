package com.appinfo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import com.appinfo.dao.FinancialMapper;

import org.springframework.stereotype.Service;

import com.appinfo.pojo.Financial;

@Service
public class FinancialServiceImpl implements FinancialService {

	@Resource
	FinancialMapper FinancialMapper;

	@Override
	public List<Financial> getfinanciallist(String start, String end) {
		// TODO Auto-generated method stub

		return FinancialMapper.getfinanciallist(start, end);
	}

	@Override
	public List<Financial> getfrade() {
		// TODO Auto-generated method stub
		return FinancialMapper.getfrade();
	}

	@Override
	public boolean insertfin(Financial financial) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (FinancialMapper.insertfin(financial) > 0)
			flag = true;
		return flag;
	}

	@Override
	public List<Financial> FinancialList(String incometime,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return FinancialMapper.FinancialList(incometime, currentPageNo,
				pageSize);
	}

	@Override
	public int getFinancialCount(String incometime) throws Exception {
		// TODO Auto-generated method stub
		return FinancialMapper.getFinancialCount(incometime);
	}

	@Override
	public int delFinancial(String id) throws Exception {
		// TODO Auto-generated method stub
		return FinancialMapper.delFinancial(id);
	}

}
