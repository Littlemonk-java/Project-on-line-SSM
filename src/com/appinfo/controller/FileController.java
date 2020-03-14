package com.appinfo.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.appinfo.pojo.User;
import com.appinfo.service.UserService;
import com.appinfo.tools.Constants;

/**
 * 文件上传
 * 
 * @author Waitforyou
 * 
 */
@Controller
@RequestMapping("/sys")
public class FileController {

	@Resource
	UserService userService;//用户业务层

	/**
	 * 修改用户头像
	 * 
	 * @param request
	 * @param session
	 * @param id
	 * @param attach
	 * @return
	 */
	@RequestMapping(value = "/fileLoad.html", method = RequestMethod.POST)
	public String fileLoad(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "pictureid", required = false) String id,
			@RequestParam(value = "attachs", required = false) MultipartFile attach) {
		boolean flag = true;
		String idPicPath = null;
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("assets" + File.separator + "img");
			String oldfilename = attach.getOriginalFilename();
			String prefix = FilenameUtils.getExtension(oldfilename);// 后缀
			int filesize = 5000000;
			if (attach.getSize() > filesize) {
				request.setAttribute("uploadFileError", "上传文件大小不得超过500kb");
				return "standardadd";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")) {
				String fileName = System.currentTimeMillis()
						+ RandomUtils.nextInt(1000000) + "_Personal." + prefix;
				File file = new File(path, fileName);
				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					attach.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				idPicPath = fileName;

				System.out.println(idPicPath);
				User user = new User();
				user.setPicture(idPicPath);
				user.setId(Integer.parseInt(id));
				System.out.println(user.getId());
				userService.update(user);
			} else {
				request.setAttribute("uploadFileError", "上传文件格式不正确");
				return "standardadd";
			}
		}
		return "login";
	}
}
