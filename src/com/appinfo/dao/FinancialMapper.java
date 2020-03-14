package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Financial;

public interface FinancialMapper {
	/**
	 * ͳ�ƾ�������
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Financial> getfinanciallist(@Param("start") String start,
			@Param("end") String end);

	/**
	 * �õ�����������Ϣ
	 * 
	 * @return
	 */
	public List<Financial> getfrade();

	/**
	 * ���������Ϣ
	 * 
	 * @param financial
	 * @return
	 * @throws Exception
	 */
	public int insertfin(Financial financial) throws Exception;

	/**
	 * ��ѯ����ͳ��
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
	 * ��ѯ��������
	 * 
	 * @param incometime
	 * @return
	 * @throws Exception
	 */
	public int getFinancialCount(@Param("incometime") String incometime)
			throws Exception;
	/**
	 * ɾ������������Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delFinancial(@Param("id") String id)throws Exception;
}
