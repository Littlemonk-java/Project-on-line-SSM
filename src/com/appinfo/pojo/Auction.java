package com.appinfo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Auction {

	private int id;
	private int projectid;
	private String contributive;
	private int contributiveuserid;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String contributivetime;
	private String name;
	private String projectname;
	private String auctionnum;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String auctionend;
	private String bzmoney;
	private String state;

	public Auction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getContributive() {
		return contributive;
	}

	public void setContributive(String contributive) {
		this.contributive = contributive;
	}

	public int getContributiveuserid() {
		return contributiveuserid;
	}

	public void setContributiveuserid(int contributiveuserid) {
		this.contributiveuserid = contributiveuserid;
	}

	public String getContributivetime() {
		return contributivetime;
	}

	public void setContributivetime(String contributivetime) {
		this.contributivetime = contributivetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getAuctionnum() {
		return auctionnum;
	}

	public void setAuctionnum(String auctionnum) {
		this.auctionnum = auctionnum;
	}

	public String getAuctionend() {
		return auctionend;
	}

	public void setAuctionend(String auctionend) {
		this.auctionend = auctionend;
	}

	public String getBzmoney() {
		return bzmoney;
	}

	public void setBzmoney(String bzmoney) {
		this.bzmoney = bzmoney;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Auction(int id, int projectid, String contributive,
			int contributiveuserid, String contributivetime, String name,
			String projectname, String auctionnum, String auctionend,
			String bzmoney, String state) {
		super();
		this.id = id;
		this.projectid = projectid;
		this.contributive = contributive;
		this.contributiveuserid = contributiveuserid;
		this.contributivetime = contributivetime;
		this.name = name;
		this.projectname = projectname;
		this.auctionnum = auctionnum;
		this.auctionend = auctionend;
		this.bzmoney = bzmoney;
		this.state = state;
	}



}
