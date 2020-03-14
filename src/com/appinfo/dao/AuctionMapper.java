package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Range;

import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;

public interface AuctionMapper {
	/**
	 * 竞拍跟踪查询
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
	 * 查询总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int Auctioncount(@Param("projectname") String projectname)
			throws Exception;

	/**
	 * 按id查询项目竞拍流程
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auction> AuctionListbyid(@Param("projectid") String projectid)
			throws Exception;

	/**
	 * 统计完成修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int AuctionModify(Project project) throws Exception;

	/**
	 * 装备项目上传者的到账金额
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int userid(@Param("id") String id) throws Exception;

	/**
	 * 买受人扣去余额
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int buuser(@Param("name") String name) throws Exception;

	/**
	 * 到账
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int upuserid(@Param("id") String id, @Param("balance") String balance)
			throws Exception;

	/**
	 * 剪掉余额
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int upbyuserid(@Param("name") String name,
			@Param("balance") String balance) throws Exception;

	/**
	 * 竞拍跟踪查询
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
	 * 查询总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int AuctioncountUser(@Param("userid") String userid,
			@Param("projectname") String projectname) throws Exception;

	/**
	 * 查询项目市场
	 * @param projecttype
	 * @param projectname
	 * @return
	 * @throws Exception
	 */
	public List<Project> selectauction(
			@Param("projecttype") String projecttype,
			@Param("projectname") String projectname) throws Exception;
	/**
	 * 添加跟踪流程
	 * @param auction
	 * @return
	 * @throws Exception
	 */
	public int addauction(Auction auction)throws Exception;
	/**
	 * 查询账户余额
	 * @param id
	 * @return
	 */
	public int balance(@Param("id") String id);

}
