package com.appinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;

public interface ProjectService {
	/**
	 * ��ҳ��ѯ
	 * 
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Project> getUserList(String name, Integer currentPageNo,
			Integer pageSize) throws Exception;

	/**
	 * ��ѯ��¼��
	 */
	public int getCount(String name) throws Exception;

	/**
	 * ɾ����Ŀ��Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public int delete(@Param("id") String id);

	/**
	 * ��ѯ��Ŀ��Ϣ
	 * 
	 * @param id
	 * @return
	 */

	public Project getproject(String id);

	/**
	 * ���ͨ���޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public boolean adoptModify(Project project) throws Exception;

	/**
	 * ���δͨ���޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public boolean Revoke(Project project) throws Exception;

	// ǰ̨��ʼ
	/**
	 * ��ҳ������Ŀ��Ϣ��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public List<Project> porlist(String id);
	/**
	 * �����ύ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int again( String id) throws Exception;
	/**
	 * ��ѯ�Լ����µ���Ŀ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Project> listdowload(String buyer)
			throws Exception;
	/**
	 * ��Ŀ�ļ�����
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project dowload( String id) throws Exception;
	/**
	 * �����Ŀ
	 * @return
	 * @throws Exception
	 */
	public boolean Add(Project project)throws Exception;
}
