package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;

public interface ProjectService {
	/**
	 * 分页查询
	 * 
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Project> getUserList(String name, Integer currentPageNo,
			Integer pageSize) throws Exception;

	/**
	 * 查询记录数
	 */
	public int getCount(String name) throws Exception;

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

	public Project getproject(String id);

	/**
	 * 审核通过修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public boolean adoptModify(Project project) throws Exception;

	/**
	 * 审核未通过修改
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public boolean Revoke(Project project) throws Exception;

	// 前台开始
	/**
	 * 首页个人项目信息查询
	 * 
	 * @param id
	 * @return
	 */
	public List<Project> porlist(String id);
	/**
	 * 重新提交
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int again( String id) throws Exception;
	/**
	 * 查询自己拍下单项目
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Project> listdowload(String buyer)
			throws Exception;
	/**
	 * 项目文件下载
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project dowload( String id) throws Exception;
	/**
	 * 添加项目
	 * @return
	 * @throws Exception
	 */
	public boolean Add(Project project)throws Exception;
}
