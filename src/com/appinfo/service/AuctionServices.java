package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;

public interface AuctionServices {
	/**
	 * 竞拍跟踪查询
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
	 * 查询总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int Auctioncount(String projectname) throws Exception;

	/**
	 * 按id查询项目竞拍流程
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListbyid(String projectid) throws Exception;

	/**
	 * 统计完成修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int AuctionModif(Project project) throws Exception;

	/**
	 * 装备项目上传者的到账金额
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int userid(String id) throws Exception;

	/**
	 * 买受人扣去余额
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int buuser(String name) throws Exception;

	/**
	 * 到账
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int upuserid(String id, String balance) throws Exception;

	/**
	 * 剪掉余额
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int upbyuserid(String name, String balance) throws Exception;

	// y开始前台
	/**
	 * 竞拍跟踪查询
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
	 * 查询总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int AuctioncountUser(String userid, String projectname)
			throws Exception;

	/**
	 * 查询项目市场
	 * 
	 * @param projecttype
	 * @param projectname
	 * @return
	 * @throws Exception
	 */
	public List<Project> selectauction(String projecttype, String projectname)
			throws Exception;

	/**
	 * 添加跟踪流程
	 * 
	 * @param auction
	 * @return
	 * @throws Exception
	 */
	public int addauction(Auction auction) throws Exception;
	/**
	 * 查询账户余额
	 * @param id
	 * @return
	 */
	public int balance( String id);

}
