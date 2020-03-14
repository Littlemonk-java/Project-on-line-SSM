package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;

public interface UserMapper {
	/**
	 * ͨ��userCode��ȡUser
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("name") String name) throws Exception;

	/**
	 * �޸�ͷ��
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * ��ѯ�ȼ���ߵ��û�
	 */
	public User getheightUser() throws Exception;

	/**
	 * ������Ŀ�ϴ�����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User userinfo(@Param("id") String id) throws Exception;

	/**
	 * �û������ѯ�û�
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
	 * ��ѯ�û�����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int usercont(@Param("name") String name,
			@Param("jurisdiction") String jurisdiction) throws Exception;

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int dletetUser(@Param("id") String id) throws Exception;

	/**
	 * ����û�
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user) throws Exception;
	/**
	 * ͨ��userCode��ȡUser
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User LoginUser(@Param("name") String name) throws Exception;
}
