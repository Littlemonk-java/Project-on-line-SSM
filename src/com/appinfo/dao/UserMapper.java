package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;

public interface UserMapper {
	/**
	 * 通过userCode获取User
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("name") String name) throws Exception;

	/**
	 * 修改头像
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 查询等级最高的用户
	 */
	public User getheightUser() throws Exception;

	/**
	 * 查找项目上传者信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User userinfo(@Param("id") String id) throws Exception;

	/**
	 * 用户管理查询用户
	 * 
	 * @param name
	 * @param jurisdiction
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<User> getuserlist(@Param("name") String name,
			@Param("jurisdiction") String jurisdiction,
			@Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 查询用户总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int usercont(@Param("name") String name,
			@Param("jurisdiction") String jurisdiction) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int dletetUser(@Param("id") String id) throws Exception;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user) throws Exception;
	/**
	 * 通过userCode获取User
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User LoginUser(@Param("name") String name) throws Exception;
}
