package com.appinfo.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {
	private int id;
	private int userid;
	private String name;
	private String bzmoney;
	private String projectname;
	private String projecttype;
	private String projectintr;
	private String examine;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date auctionstart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date auctionend;
	private int auctionnum;
	private String auctionmoney;
	private String buyer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date starttime;
	private String notice;
	private String state;
	private String filepor;

	public Project (){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBzmoney() {
		return bzmoney;
	}

	public void setBzmoney(String bzmoney) {
		this.bzmoney = bzmoney;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public String getProjectintr() {
		return projectintr;
	}

	public void setProjectintr(String projectintr) {
		this.projectintr = projectintr;
	}

	public String getExamine() {
		return examine;
	}

	public void setExamine(String examine) {
		this.examine = examine;
	}

	public Date getAuctionstart() {
		return auctionstart;
	}

	public void setAuctionstart(Date auctionstart) {
		this.auctionstart = auctionstart;
	}

	public Date getAuctionend() {
		return auctionend;
	}

	public void setAuctionend(Date auctionend) {
		this.auctionend = auctionend;
	}

	public int getAuctionnum() {
		return auctionnum;
	}

	public void setAuctionnum(int auctionnum) {
		this.auctionnum = auctionnum;
	}

	public String getAuctionmoney() {
		return auctionmoney;
	}

	public void setAuctionmoney(String auctionmoney) {
		this.auctionmoney = auctionmoney;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFilepor() {
		return filepor;
	}

	public void setFilepor(String filepor) {
		this.filepor = filepor;
	}

	public Project(int id, int userid, String name, String bzmoney,
			String projectname, String projecttype, String projectintr,
			String examine, Date auctionstart, Date auctionend, int auctionnum,
			String auctionmoney, String buyer, Date starttime, String notice,
			String state, String filepor) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.bzmoney = bzmoney;
		this.projectname = projectname;
		this.projecttype = projecttype;
		this.projectintr = projectintr;
		this.examine = examine;
		this.auctionstart = auctionstart;
		this.auctionend = auctionend;
		this.auctionnum = auctionnum;
		this.auctionmoney = auctionmoney;
		this.buyer = buyer;
		this.starttime = starttime;
		this.notice = notice;
		this.state = state;
		this.filepor = filepor;
	}

	
}
