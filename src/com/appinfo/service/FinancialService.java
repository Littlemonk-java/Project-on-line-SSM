package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Financial;
import com.appinfo.pojo.Project;

public interface FinancialService {
	/**
	 * ͳ�ƾ�������
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Financial> getfinanciallist(String start, String end);

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
	public boolean insertfin(Financial financial) throws Exception;
	/**
	 * ��ѯ����ͳ��
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Financial> FinancialList(String incometime, Integer currentPageNo,
			Integer pageSize) throws Exception;
	/**
	 * ��ѯ��������
	 * 
	 * @param incometime
	 * @return
	 * @throws Exception
	 */
	public int getFinancialCount(String incometime)
			throws Exception;
	/**
	 * ɾ������������Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delFinancial( String id)throws Exception;
}
