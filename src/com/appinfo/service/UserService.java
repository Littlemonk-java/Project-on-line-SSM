package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;

public interface UserService {

	/**
	 * �û���¼
	 * 
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String name, String pwd) throws Exception;

	/**
	 * �޸��û�ͷ��
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(User user);

	/**
	 * ����vip�û�
	 * 
	 * @return
	 * @throws Exception
	 */
	public User getheightUser() throws Exception;

	/**
	 * ������Ŀ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public User userinfo(String id) throws Exception;

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
	public List<User> getUserList(String name, String jurisdiction,
			Integer currentPageNo, Integer pageSize) throws Exception;

	/**
	 * ��ѯ�û�����
	 * 
	 * @param name
	 * @param jurisdiction
	 * @return
	 * @throws Exception
	 */
	public int usercont(String name, String jurisdiction) throws Exception;

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(String id) throws Exception;
	/**
	 * ����û�
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean add(User user) throws Exception;
	/**
	 * �û���¼
	 * 
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User loginuser(String name, String pwd) throws Exception;
}
