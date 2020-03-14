package com.appinfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.appinfo.dao.AuctionMapper;
import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;

@Service
public class AuctionServicesImpl implements AuctionServices {

	@Resource
	AuctionMapper auctionMapper;

	@Override
	public List<Auction> AuctionList(String projectname, Integer currentPageNo,
			Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.AuctionList(projectname, currentPageNo, pageSize);
	}

	@Override
	public int Auctioncount(String projectname) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.Auctioncount(projectname);
	}

	@Override
	public List<Auction> AuctionListbyid(String projectid) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.AuctionListbyid(projectid);
	}

	@Override
	public int AuctionModif(Project project) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.AuctionModify(project);
	}

	@Override
	public int userid(String id) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.userid(id);
	}

	@Override
	public int buuser(String name) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.buuser(name);
	}

	@Override
	public int upuserid(String id, String balance) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.upuserid(id, balance);
	}

	@Override
	public int upbyuserid(String name, String balance) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.upbyuserid(name, balance);
	}

	@Override
	public List<Auction> AuctionListUser(String userid, String projectname,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.AuctionListUser(userid, projectname,
				currentPageNo, pageSize);
	}

	@Override
	public int AuctioncountUser(String userid, String projectname)
			throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.AuctioncountUser(userid, projectname);
	}

	@Override
	public List<Project> selectauction(String projecttype, String projectname)
			throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.selectauction(projecttype, projectname);
	}

	@Override
	public int addauction(Auction auction) throws Exception {
		// TODO Auto-generated method stub
		return auctionMapper.addauction(auction);
	}

	@Override
	public int balance(String id) {
		// TODO Auto-generated method stub
		return auctionMapper.balance(id);
	}

}
