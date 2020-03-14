package com.appinfo.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.appinfo.pojo.Auction;
import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;
import com.appinfo.service.AuctionServices;
import com.appinfo.tools.Constants;
import com.appinfo.tools.PageSupport;

@Controller
public class AuctionController {
	@Resource
	AuctionServices auctionServices;

	@RequestMapping(value = "/sys/managerAuction.html")
	public String AuctionList(
			Model model,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "projectname", required = false) String projectname) {
		List<Auction> list = null;
		int pageSize = 15;
		// 当前页码
		int currentPageNo = 0;
		if (projectname == "") {
			projectname = null;
		}
		if (pageIndex != null) {
			try {
				// Integer.valueof()返回的是Integer的对象。 Integer.parseInt()
				// 返回的是一个int的值
				currentPageNo = Integer.valueOf(pageIndex);
				System.out.println("+++++++++++++++++++" + currentPageNo);
			} catch (NumberFormatException e) {
				// return "redirect:/syserror.html";
			}
		}
		// 总数量（表）
		int totalCount = 0;
		try {
			totalCount = auctionServices.Auctioncount(projectname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 0) {
			currentPageNo = 0;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		try {
			list = auctionServices.AuctionList(projectname, currentPageNo,
					pageSize);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------totalCount" + totalCount);
		System.out.println("----------------totalPageCount" + totalPageCount);
		System.out.println("----------------currentPageNo:" + currentPageNo);
		model.addAttribute("list", list);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "managerauction";
	}

	@RequestMapping(value = "/sys/autio", method = RequestMethod.GET)
	@ResponseBody
	public Object ObjList(@RequestParam String id,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		List<Auction> listAuctio = null;
		listAuctio = auctionServices.AuctionListbyid(id);
		String JSONAuction = JSON.toJSONString(listAuctio);
		System.out.println(JSONAuction);
		return JSONAuction;
	}

	@RequestMapping(value = "/sys/porject")
	public String Auction(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("pon") String porname,
			@RequestParam("porid") String porid) throws Exception {
		System.out.println(id);
		System.out.println(name);
		Project project = new Project();
		project.setAuctionmoney(id);
		project.setId(Integer.parseInt(porid));
		project.setBuyer(name);
		int count = auctionServices.AuctionModif(project);
		if (count > 0) {

			int num1 = auctionServices.userid(porid);
			int sum = num1 + Integer.parseInt(id);
			int num = auctionServices.buuser(name);
			int snm = num - Integer.parseInt(id);
			int cun = auctionServices.upbyuserid(porname, String.valueOf(sum));
			if (cun > 0) {
				int c = auctionServices.upuserid(porid, String.valueOf(snm));
				if (c > 0) {
					return "redirect:/sys/managerAuction.html";
				}
			}
		} else {

		}
		return "";

	}

	// 前台开始
	@RequestMapping(value = "/sys/Auction.html")
	public String AuctionListUser(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "projectname", required = false) String projectname) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		List<Auction> list = null;
		int pageSize = 15;
		// 当前页码
		int currentPageNo = 0;
		if (projectname == "") {
			projectname = null;
		}
		if (pageIndex != null) {
			try {
				// Integer.valueof()返回的是Integer的对象。 Integer.parseInt()
				// 返回的是一个int的值
				currentPageNo = Integer.valueOf(pageIndex);
				System.out.println("+++++++++++++++++++" + currentPageNo);
			} catch (NumberFormatException e) {
				// return "redirect:/syserror.html";
			}
		}
		// 总数量（表）
		int totalCount = 0;
		try {
			totalCount = auctionServices.AuctioncountUser(
					String.valueOf(user.getId()), projectname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 0) {
			currentPageNo = 0;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		try {
			list = auctionServices.AuctionListUser(
					String.valueOf(user.getId()), projectname, currentPageNo,
					pageSize);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------totalCount" + totalCount);
		System.out.println("----------------totalPageCount" + totalPageCount);
		System.out.println("----------------currentPageNo:" + currentPageNo);
		model.addAttribute("list", list);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "auction";
	}

	// 开始竞拍
	@RequestMapping(value = "/sys/startaution.html")
	public String startaution(Model model,HttpSession session,HttpServletRequest request,
			@RequestParam(value="projecttype" ,required = false ) String projecttype,
			@RequestParam(value="projectname" ,required = false) String projectname) throws Exception {
		List<Project> list = null;
		if(projectname==""){
			projectname=null;
		}
		if(projecttype==""){
			projecttype=null;
		}
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		
		int num = auctionServices.balance(String.valueOf(user.getId()));
		request.setAttribute("num",num);
	
		list = auctionServices.selectauction(projecttype, projectname);
		model.addAttribute("list", list);
		
		return "satrtauction";
	}
	@RequestMapping(value="/sys/addauction.html")
	public String addauction( HttpSession session, Auction auction,HttpServletResponse response,HttpServletRequest request) throws Exception{
		
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		auction.setContributiveuserid(user.getId());
		
		int count = auctionServices.addauction(auction);
		if(count>0){
			return "redirect:/sys/startaution.html";
		}else {
			return "";
		}
	}
}
