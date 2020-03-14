package com.appinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.appinfo.pojo.Financial;
import com.appinfo.pojo.Project;
import com.appinfo.pojo.User;
import com.appinfo.service.*;
import com.appinfo.tools.Constants;
import com.appinfo.tools.PageSupport;

/**
 * 核心控制器
 * 
 * @author Waitforyou
 * 
 */
@Controller
public class ProjectController {

	@Resource
	ProjectService pRojectService;// 项目业务层
	@Resource
	UserService userService;// 用户业务层
	@Resource
	FinancialService FinancialService;// 财务业务层

	/**
	 * 查找未审核的项目
	 * 
	 * @param model
	 * @param pageIndex
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/sys/mamagerindex.html")
	public String proList(
			Model model,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "name", required = false) String name) {
		List<Project> proList = null;
		User userlist = null;
		List<Financial> finaList = null;
		List<Financial> gradeList = null;

		try {
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
			int offset1 = 1 - dayOfWeek;
			int offset2 = 8 - dayOfWeek;
			calendar1.add(Calendar.DATE, offset1 - 7);
			calendar2.add(Calendar.DATE, offset2 - 7);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// System.out.println(sdf.format(calendar1.getTime()));// last
			// Monday
			String lastBeginDate = format.format(calendar1.getTime());
			// System.out.println(sdf.format(calendar2.getTime()));// last
			// Sunday
			String lastEndDate = format.format(calendar2.getTime());
			finaList = FinancialService.getfinanciallist(lastBeginDate,
					lastEndDate);
			userlist = userService.getheightUser();
			gradeList = FinancialService.getfrade();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 设置页面容量
		int pageSize = 5;
		// 当前页码
		int currentPageNo = 0;

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
			totalCount = pRojectService.getCount(name);
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
			proList = pRojectService.getUserList(name, currentPageNo, pageSize);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("finaList", finaList);
		model.addAttribute("proList", proList);
		model.addAttribute("userlist", userlist);
		model.addAttribute("gradeList", gradeList);

		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		System.out.println("控制器打印" + currentPageNo);
		System.out.println("控制器打印" + totalCount);
		System.out.println("控制器打印" + totalPageCount);

		return "mamagerindex";

	}

	/**
	 * 直接删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sys/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		System.out.println(id);
		int count = pRojectService.delete(id);
		System.err.println(count);
		System.out.println(id);
		if (count > 0) {
			System.err.println("成功");
			return "redirect:/sys/mamagerindex.html";
		} else {
			return "redirect:/sys/mamagerindex.html";
		}
	}

	/**
	 * 获取审核信息
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/views/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable String id) throws Exception {
		Project project = null;
		project = pRojectService.getproject(id);
		User userlist = null;
		User userinfoproject = null;
		userinfoproject = userService.userinfo(id);
		model.addAttribute("userinfoproject", userinfoproject);
		model.addAttribute("priject", project);
		userlist = userService.getheightUser();
		model.addAttribute("userlist", userlist);
		return "managertables";
	}

	/**
	 * 成功审核
	 * 
	 * @param project
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sys/adopt.html", method = RequestMethod.POST)
	public String adopt(Project project, HttpSession session,
			HttpServletRequest request) {
		System.out.println(project.getId());
		System.out.println(project.getBzmoney());
		boolean flag = true;
		if (flag) {
			try {

				if (pRojectService.adoptModify(project)) {

					Financial financial = new Financial();
					financial
							.setIncomepeojectid(String.valueOf(project.getId()));
					int num = Integer.parseInt(project.getBzmoney());
					double num1 = num * 0.03;
					financial.setIncome(String.valueOf(num1));

					if (FinancialService.insertfin(financial)) {
						return "redirect:/sys/mamagerindex.html";
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 撤销审核
	 * 
	 * @param project
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sys/Revoke.html", method = RequestMethod.POST)
	public String Revoke(Project project, HttpSession session,
			HttpServletRequest request) {
		System.out.println(project.getExamine());
		System.out.println(project.getAuctionstart());
		System.out.println(project.getAuctionend());
		boolean flag = true;
		if (flag) {
			try {

				if (pRojectService.Revoke(project)) {
					return "redirect:/sys/mamagerindex.html";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	// 开始前台
	@RequestMapping(value = "/sys/index.html")
	public String index(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_SESSION);

		List<Project> list = null;
		List<Project> listdowload = null;
		List<Financial> gradeList = null;
		listdowload = pRojectService.listdowload(user.getName());
		gradeList = FinancialService.getfrade();
		list = pRojectService.porlist(String.valueOf(user.getId()));
		model.addAttribute("list", list);
		model.addAttribute("listdowload", listdowload);
		model.addAttribute("gradeList", gradeList);
		return "index";
	}

	/**
	 * 直接删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sys/deletepor/{id}", method = RequestMethod.GET)
	public String deletepor(@PathVariable String id) {
		System.out.println(id);
		int count = pRojectService.delete(id);
		System.err.println(count);
		System.out.println(id);
		if (count > 0) {
			System.err.println("成功");
			return "redirect:/sys/index.html";
		} else {
			return "redirect:/sys/index.html";
		}
	}

	@RequestMapping(value = "/sys/again/{id}", method = RequestMethod.GET)
	public String again(@PathVariable String id) throws Exception {
		int count = pRojectService.again(id);
		if (count > 0) {
			System.err.println("成功");
			return "redirect:/sys/index.html";
		} else {
			return "redirect:/sys/index.html";
		}
	}

	@RequestMapping("/download/{id}")
	public String fileDownload(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String id) {
		// 获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
		Project project = new Project();
		try {
			project = pRojectService.dowload(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path = project.getFilepor();
		if (null != path && !"".equals(path)) {
			// 通过文件路径获得File对象(假如此路径中有一个download.pdf文件)
			File file = new File(path);
			String filename = file.getName();
			// String ext = filename.substring(filename.lastIndexOf(".") +
			// 1).toUpperCase();

			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ filename);
			ServletOutputStream out;

			try {
				FileInputStream inputStream = new FileInputStream(file);

				// 3.通过response获取ServletOutputStream对象(out)
				out = response.getOutputStream();

				int b = 0;
				byte[] buffer = new byte[1024*10000];
				while (b != -1) {

					b = inputStream.read(buffer);
					// 4.写到输出流(out)中
					out.write(buffer, 0, b);
				}
				inputStream.close();
				out.close();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("error_path", "当前用户没有上传附件");
			return "redirect:/sys/index.html";
		}
		return "/sys/index.html";
	}

	@RequestMapping("/sys/addporject.html")
	public String addporject() {
		return "Addproject";
	}

	@RequestMapping(value = "/sys/addpor.html", method = RequestMethod.POST)
	public String addUserSave(
			Project project,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {

		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		boolean flag = true;
		String path = request.getSession().getServletContext()
				.getRealPath("assets" + File.separator + "uploadfiles");

		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];
			if (!attach.isEmpty()) {
				if (i == 0) {
					errorInfo = "uploadFileError";
				} else if (i == 1) {
					errorInfo = "uploadWpError";
				}
				@SuppressWarnings("unused")
				String oldFileName = attach.getOriginalFilename();
				String prefix = FilenameUtils.getExtension(oldFileName);
				int filesize = 500000;
				if (attach.getSize() > filesize) { 
					flag = false;
				} else if (prefix.equalsIgnoreCase("jpg")
						|| prefix.equalsIgnoreCase("png")
						|| prefix.equalsIgnoreCase("rar")
						|| prefix.equalsIgnoreCase("zip")) {
					String fileName = System.currentTimeMillis()
							+ RandomUtils.nextInt(1000000) + "_Personal.jpg";
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					try {
						attach.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
						
						flag = false;
					}
					if (i == 0) {
						idPicPath = path + File.separator + fileName;
					} else if (i == 1) {
						workPicPath = fileName;
					}
					System.out.println("idPicPath: " + idPicPath);
					System.out.println("workPicPath: " + workPicPath);
				} else {
					
					flag = false;
				}
			}
		}
		if (flag) {
			project.setFilepor(idPicPath);
			project.setProjectintr(workPicPath);
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			project.setUserid(user.getId());
			try {
				if (pRojectService.Add(project)) {
					return "redirect:/sys/index.html";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/sys/addporject.html";
	}

}
