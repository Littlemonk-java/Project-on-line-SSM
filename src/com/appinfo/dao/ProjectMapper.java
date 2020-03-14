package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;

public interface ProjectMapper {

	/**
	 * 分页查询项目信息
	 * 
	 * @param name
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Project> getPorList(@Param("name") String name,
			@Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 统计项目数量
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int getPorCount(@Param("name") String name) throws Exception;

	/**
	 * 删除项目信息
	 * 
	 * @param id
	 * @return
	 */
	public int delete(@Param("id") String id);

	/**
	 * 查询项目信息
	 * 
	 * @param id
	 * @return
	 */

	public Project getproject(@Param("id") String id);

	/**
	 * 审核通过修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int adoptModify(Project project) throws Exception;

	/**
	 * 审核未通过修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int Revoke(Project project) throws Exception;

	// 前台开始
	/**
	 * 首页个人项目信息查询
	 * 
	 * @param id
	 * @return
	 */
	public List<Project> porlist(@Param("id") String id);

	/**
	 * 重新提交
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int again(@Param("id") String id) throws Exception;

	/**
	 * 查询自己拍下单项目
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Project> listdowload(@Param("buyer") String buyer)
			throws Exception;

	/**
	 * 项目文件上传
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project dowload(@Param("id") String id) throws Exception;

	/**
	 * 添加项目
	 * 
	 * @return
	 * @throws Exception
	 */
	public int Add(Project project) throws Exception;
}
