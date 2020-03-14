package com.appinfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.appinfo.dao.UserMapper;
import com.appinfo.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;

	@Override
	public User login(String name, String pwd) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		user = userMapper.getLoginUser(name);
		// ∆•≈‰√‹¬Î
		if (null != user) {
			if (!user.getPwd().equals(pwd))
				user = null;
		}
		return user;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (userMapper.update(user) > 0)
			flag = true;
		return flag;
	}

	@Override
	public User getheightUser() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getheightUser();
	}

	@Override
	public User userinfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.userinfo(id);
	}

	@Override
	public List<User> getUserList(String name, String jurisdiction,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getuserlist(name, jurisdiction, currentPageNo
				* pageSize, pageSize);
	}

	@Override
	public int usercont(String name, String jurisdiction) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.usercont(name, jurisdiction);
	}

	@Override
	public int deleteUser(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.dletetUser(id);
	}

	@Override
	public boolean add(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (userMapper.add(user) > 0)
			flag = true;
		return flag;
	}

	@Override
	public User loginuser(String name, String pwd) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		user = userMapper.LoginUser(name);
		// ∆•≈‰√‹¬Î
		if (null != user) {
			if (!user.getPwd().equals(pwd))
				user = null;
		}
		return user;
	}

}
