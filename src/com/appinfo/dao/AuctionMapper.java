package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Range;

import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;

public interface AuctionMapper {
	/**
	 * ���ĸ��ٲ�ѯ
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionList(@Param("projectname") String projectname,
			@Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * ��ѯ����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int Auctioncount(@Param("projectname") String projectname)
			throws Exception;

	/**
	 * ��id��ѯ��Ŀ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListbyid(@Param("projectid") String projectid)
			throws Exception;

	/**
	 * ͳ������޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int AuctionModify(Project project) throws Exception;

	/**
	 * װ����Ŀ�ϴ��ߵĵ��˽��
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int userid(@Param("id") String id) throws Exception;

	/**
	 * �����˿�ȥ���
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int buuser(@Param("name") String name) throws Exception;

	/**
	 * ����
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int upuserid(@Param("id") String id, @Param("balance") String balance)
			throws Exception;

	/**
	 * �������
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int upbyuserid(@Param("name") String name,
			@Param("balance") String balance) throws Exception;

	/**
	 * ���ĸ��ٲ�ѯ
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListUser(@Param("userid") String userid,
			@Param("projectname") String projectname,
			@Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * ��ѯ����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int AuctioncountUser(@Param("userid") String userid,
			@Param("projectname") String projectname) throws Exception;

	/**
	 * ��ѯ��Ŀ�г�
	 * @param projecttype
	 * @param projectname
	 * @return
	 * @throws Exception
	 */
	public List<Project> selectauction(
			@Param("projecttype") String projecttype,
			@Param("projectname") String projectname) throws Exception;
	/**
	 * ��Ӹ�������
	 * @param auction
	 * @return
	 * @throws Exception
	 */
	public int addauction(Auction auction)throws Exception;
	/**
	 * ��ѯ�˻����
	 * @param id
	 * @return
	 */
	public int balance(@Param("id") String id);

}
