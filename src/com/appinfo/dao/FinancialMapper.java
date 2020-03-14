package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Financial;

public interface FinancialMapper {
	/**
	 * 统计竞拍人数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Financial> getfinanciallist(@Param("start") String start,
			@Param("end") String end);

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
	public int insertfin(Financial financial) throws Exception;

	/**
	 * 查询财务统计
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Financial> FinancialList(
			@Param("incometime") String incometime,
			@Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 查询财务总数
	 * 
	 * @param incometime
	 * @return
	 * @throws Exception
	 */
	public int getFinancialCount(@Param("incometime") String incometime)
			throws Exception;
	/**
	 * 删除单个财务信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delFinancial(@Param("id") String id)throws Exception;
}
