package com.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.appinfo.pojo.Project;

public interface ProjectMapper {

	/**
	 * ��ҳ��ѯ��Ŀ��Ϣ
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
	 * ͳ����Ŀ����
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int getPorCount(@Param("name") String name) throws Exception;

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

	public Project getproject(@Param("id") String id);

	/**
	 * ���ͨ���޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int adoptModify(Project project) throws Exception;

	/**
	 * ���δͨ���޸�
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int Revoke(Project project) throws Exception;

	// ǰ̨��ʼ
	/**
	 * ��ҳ������Ŀ��Ϣ��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public List<Project> porlist(@Param("id") String id);

	/**
	 * �����ύ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int again(@Param("id") String id) throws Exception;

	/**
	 * ��ѯ�Լ����µ���Ŀ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Project> listdowload(@Param("buyer") String buyer)
			throws Exception;

	/**
	 * ��Ŀ�ļ��ϴ�
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project dowload(@Param("id") String id) throws Exception;

	/**
	 * �����Ŀ
	 * 
	 * @return
	 * @throws Exception
	 */
	public int Add(Project project) throws Exception;
}
