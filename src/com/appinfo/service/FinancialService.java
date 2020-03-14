package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Financial;
import com.appinfo.pojo.Project;

public interface FinancialService {
	/**
	 * 统计竞拍人数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Financial> getfinanciallist(String start, String end);

	/**
	 * 拿到财务收入信息
	 * 
	 * @return
	 */
	public List<Financial> getfrade();

	/**
	 * 插入财务信息
	 * 
	 * @param financial
	 * @return
	 * @throws Exception
	 */
	public boolean insertfin(Financial financial) throws Exception;
	/**
	 * 查询财务统计
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Financial> FinancialList(String incometime, Integer currentPageNo,
			Integer pageSize) throws Exception;
	/**
	 * 查询财务总数
	 * 
	 * @param incometime
	 * @return
	 * @throws Exception
	 */
	public int getFinancialCount(String incometime)
			throws Exception;
	/**
	 * 删除单个财务信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delFinancial( String id)throws Exception;
}
