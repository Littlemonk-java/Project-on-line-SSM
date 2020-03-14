package com.appinfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.appinfo.dao.ProjectMapper;
import com.appinfo.pojo.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	ProjectMapper pRojectMapper;

	@Override
	public List<Project> getUserList(String name, Integer currentPageNo, Integer pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		
		return pRojectMapper.getPorList( name,currentPageNo, pageSize);
	}

	@Override
	public int getCount(String name) throws Exception {
		// TODO Auto-generated method stub
		return pRojectMapper.getPorCount(name);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return  pRojectMapper.delete(id);
	}

	@Override
	public Project getproject(String id) {
		// TODO Auto-generated method stub
		return pRojectMapper.getproject(id);
	}

	@Override
	public boolean adoptModify(Project project) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pRojectMapper.adoptModify(project) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean Revoke(Project project) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pRojectMapper.Revoke(project) > 0)
			flag = true;
		return flag;
	}

	@Override
	public List<Project> porlist(String id) {
		// TODO Auto-generated method stub
		return pRojectMapper.porlist(id);
	}

	@Override
	public int again(String id) throws Exception {
		// TODO Auto-generated method stub
		return pRojectMapper.again(id);
	}

	@Override
	public List<Project> listdowload(String buyer) throws Exception {
		// TODO Auto-generated method stub
		return pRojectMapper.listdowload(buyer);
	}

	@Override
	public Project dowload(String id) throws Exception {
		// TODO Auto-generated method stub
		return pRojectMapper.dowload(id);
	}

	@Override
	public boolean Add(Project project) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pRojectMapper.Add(project) > 0)
			flag = true;
		return flag;
	}

}
