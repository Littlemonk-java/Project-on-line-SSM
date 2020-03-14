package com.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.appinfo.pojo.User;
import com.appinfo.service.UserService;
import com.appinfo.tools.PageSupport;

@Controller
public class UserController {
	@Resource
	UserService userService;// 用户业务层

	@RequestMapping(value = "/sys/managerUser.html")
	public String Userlist(
			Model model,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "jurisdiction", required = false) String jurisdiction) {

		List<User> list = null;
		// 设置页面容量
		int pageSize = 5;
		// 当前页码
		int currentPageNo = 0;
		if (name == "") {
			name = null;
		}
		if (jurisdiction == "") {
			jurisdiction = null;
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
			totalCount = userService.usercont(name, jurisdiction);
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
			list = userService.getUserList(name, jurisdiction, currentPageNo,
					pageSize);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------totalCount" + totalCount);
		System.out.println("----------------totalPageCount" + totalPageCount);
		System.out.println("----------------currentPageNo:" + currentPageNo);
		System.out.println("----------------jurisdiction:" + jurisdiction);
		model.addAttribute("list", list);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "managerUser";
	}

	@RequestMapping(value = "/sys/deleteuser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String id) throws Exception {
		int count = userService.deleteUser(id);
		if (count > 0) {
			return "redirect:/sys/managerUser.html";
		} else {
			return "redirect:/sys/managerUser.html";
		}
	}

	@RequestMapping(value = "/addsave.html", method = RequestMethod.POST)
	public String addSave(
			User user,
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "pictu", required = false) MultipartFile pictu) {
		boolean flag = true;
		String idPicPath = null;
		if (!pictu.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("assets" + File.separator + "img");
			String oldfilename = pictu.getOriginalFilename();
			String prefix = FilenameUtils.getExtension(oldfilename);
			int filesize = 5000000;
			if (pictu.getSize() > filesize) {
				request.setAttribute("uploadFileError", "上传文件大小不得超过500kb");
				return "standardadd";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")) {
				String fileName = System.currentTimeMillis()
						+ RandomUtils.nextInt(1000000) + "_Personal.jpg";
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					pictu.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				idPicPath = fileName;
			} else {

				System.out.println("文件格式有误");

			}
		}
		user.setPicture(idPicPath);
		if (flag) {
			try {
				if (userService.add(user)) {
					return "redirect:/sys/managerUser.html";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return "";
	}

}
