package com.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appinfo.pojo.Financial;
import com.appinfo.pojo.User;
import com.appinfo.service.FinancialService;
import com.appinfo.tools.PageSupport;

@Controller
public class FinancialController {
	@Resource
	FinancialService fInancialService;

	@RequestMapping(value = "/sys/managerFinance.html")
	public String Financiallist(
			Model model,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			@RequestParam(value = "incometime", required = false) String incometime) {
		List<Financial> list = null;

		int pageSize = 15;
		// 当前页码
		int currentPageNo = 0;
		if (incometime == "") {
			incometime = null;
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
			totalCount = fInancialService.getFinancialCount(incometime);
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
			list = fInancialService.FinancialList(incometime, currentPageNo,
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
		return "managerfinancil";

	}

	@RequestMapping(value = "/sys/delFinancial/{id}")
	public String delFinancil(@PathVariable String id) throws Exception {
		int count = fInancialService.delFinancial(id);
		if (count > 0) {
			return "redirect:/sys/managerFinance.html";
		} else {
			return "redirect:/sys/managerFinance.html";
		}

	}
}
