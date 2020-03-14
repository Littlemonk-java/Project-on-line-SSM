package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;

public interface AuctionServices {
	/**
	 * ���ĸ��ٲ�ѯ
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionList(String projectname, Integer currentPageNo,
			Integer pageSize) throws Exception;

	/**
	 * ��ѯ����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int Auctioncount(String projectname) throws Exception;

	/**
	 * ��id��ѯ��Ŀ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListbyid(String projectid) throws Exception;

	/**
	 * ͳ������޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int AuctionModif(Project project) throws Exception;

	/**
	 * װ����Ŀ�ϴ��ߵĵ��˽��
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int userid(String id) throws Exception;

	/**
	 * �����˿�ȥ���
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int buuser(String name) throws Exception;

	/**
	 * ����
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int upuserid(String id, String balance) throws Exception;

	/**
	 * �������
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int upbyuserid(String name, String balance) throws Exception;

	// y��ʼǰ̨
	/**
	 * ���ĸ��ٲ�ѯ
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListUser(String userid, String projectname,
			Integer currentPageNo, Integer pageSize) throws Exception;

	/**
	 * ��ѯ����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int AuctioncountUser(String userid, String projectname)
			throws Exception;

	/**
	 * ��ѯ��Ŀ�г�
	 * 
	 * @param projecttype
	 * @param projectname
	 * @return
	 * @throws Exception
	 */
	public List<Project> selectauction(String projecttype, String projectname)
			throws Exception;

	/**
	 * ��Ӹ�������
	 * 
	 * @param auction
	 * @return
	 * @throws Exception
	 */
	public int addauction(Auction auction) throws Exception;
	/**
	 * ��ѯ�˻����
	 * @param id
	 * @return
	 */
	public int balance( String id);

}
