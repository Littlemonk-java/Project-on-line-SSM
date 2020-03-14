package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;

public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String name, String pwd) throws Exception;

	/**
	 * 修改用户头像
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(User user);

	/**
	 * 查找vip用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public User getheightUser() throws Exception;

	/**
	 * 查找项目主人
	 * 
	 * @return
	 * @throws Exception
	 */
	public User userinfo(String id) throws Exception;

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
	public List<User> getUserList(String name, String jurisdiction,
			Integer currentPageNo, Integer pageSize) throws Exception;

	/**
	 * 查询用户总数
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int usercont(String name, String jurisdiction) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(String id) throws Exception;
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean add(User user) throws Exception;
	/**
	 * 用户登录
	 * 
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User loginuser(String name, String pwd) throws Exception;
}
