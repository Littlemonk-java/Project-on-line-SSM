<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="<%=basePath%>assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=basePath%>assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="http://cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=basePath%>assets/css/app.css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script language="javascript">
	function preview(oper) {
		if (oper < 10) {
			bdhtml = window.document.body.innerHTML;//获取当前页的html代码
			sprnstr = "<!--startprint" + oper + "-->";//设置打印开始区域
			eprnstr = "<!--endprint" + oper + "-->";//设置打印结束区域
			prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 18); //从开始代码向后取html
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));//从结束代码向前取html
			window.document.body.innerHTML = prnhtml;
			window.print();
			window.document.body.innerHTML = bdhtml;
		} else {
			window.print();
		}
	}
</script>

</head>

<body data-type="widgets">
	<script src="<%=basePath%>assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 头部 -->
		<header>
			<!-- logo -->
			<div class="am-fl tpl-header-logo">
				<a href="javascript:;"><img
					src="<%=basePath%>assets/img/logo.png" alt=""></a>
			</div>
			<!-- 右侧内容 -->
			<div class="tpl-header-fluid">
				<!-- 侧边切换 -->
				<div class="am-fl tpl-header-switch-button am-icon-list">
					<span> </span>
				</div>

				<!-- 其它功能-->
				<div class="am-fr tpl-header-navbar">
					<ul>
						<!-- 欢迎语 -->
						<li class="am-text-sm tpl-header-navbar-welcome"><a
							href="javascript:;">欢迎你, <span>${userSession.name}</span>
						</a></li>

						<!-- 退出 -->
						<li class="am-text-sm"><a href="javascript:;"> <span
								class="am-icon-sign-out"></span> 退出
						</a></li>
					</ul>
				</div>
			</div>

		</header>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog"></div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">选择主题</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<!-- 侧边导航栏 -->
		<div class="left-sidebar">
			<!-- 用户信息 -->
			<div class="tpl-sidebar-user-panel">
				<div class="tpl-user-panel-slide-toggleable">
					<div class="tpl-user-panel-profile-picture">
						<form id="frm2" method="post" enctype="multipart/form-data"
							action="${pageContext.request.contextPath }/sys/fileLoad.html">
							<input type="file" name="attachs" id="btn_file"
								style="display:none"> <input type="hidden"
								name="pictureid" value="${userSession.id}" />
						</form>
						<img onclick="picture()"
							src="<%=basePath %>assets/img/${userSession.picture}" alt="">
					</div>
					<span class="user-panel-logged-in-text"> <i
						class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
						${userSession.name}
					</span> <a href="javascript:;" class="tpl-user-panel-action-link"> <span
						class="am-icon-pencil"></span> 账号设置
					</a>
				</div>
			</div>

			<!-- 菜单 -->
			<ul class="sidebar-nav">
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/mamagerindex.html">
						<i class="am-icon-home sidebar-nav-link-logo"></i> 首页
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerUser.html">
						<i class="am-icon-table sidebar-nav-link-logo"></i> 用户管理
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerFinance.html">
						<i class="am-icon-calendar sidebar-nav-link-logo"></i> 财务统计
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerAuction.html">
						<i class="am-icon-wpforms sidebar-nav-link-logo"></i> 竞拍跟踪

				</a></li>


			</ul>
		</div>


		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">
			<div class="row-content am-cf">
				<div class="row">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">财务列表</div>


							</div>
							<div class="widget-body  am-fr">

								<div class="am-u-sm-12 am-u-md-6 am-u-lg-8">
									<div class="am-form-group">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
												<button onclick="preview(1)" type="button"
													class="am-btn am-btn-default am-btn-success">
													<span class="am-icon-plus"></span> 打印
												</button>
												<button type="button"
													class="am-btn am-btn-default am-btn-danger">
													<span class="am-icon-trash-o"></span> 清空
												</button>
											</div>
										</div>
									</div>
								</div>
								<form id="fem"
									action="${pageContext.request.contextPath }/sys/managerFinance.html"
									method="post">
									<div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
										<div
											class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
											<input type="text" name="incometime" class="am-form-field ">
											<span class="am-input-group-btn">
												<button
													class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
													type="button" onclick="frmsubmit()"></button>
											</span> <input type="hidden" name="pageIndex" id="pageIndex" />
										</div>
									</div>
								</form>

								<div class="am-u-sm-12">
									<!--startprint1-->
									<table width="100%"
										class="am-table am-table-compact am-table-striped tpl-table-black "
										id="example-r">
										<thead>
											<tr>
												<th>财务编号</th>
												<th>收入原由</th>
												<th>收入时间</th>
												<th>收入金额</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list }" var="list">
												<tr class="gradeX">
													<td>${list.id }</td>
													<td>${list.projectname }</td>
													<td>${list.incometime }</td>
													<td>${list.income }￥</td>
													<td>
														<div class="tpl-table-black-operation">

															<a
																href="${pageContext.request.contextPath }/sys/delFinancial/${list.id}"
																class="tpl-table-black-operation-del"> <i
																class="am-icon-trash"></i> 删除
															</a>
														</div>
													</td>
												</tr>
											</c:forEach>
											<!-- more data -->
										</tbody>
									</table>
									<!--endprint1-->
								</div>
								<div class="am-u-lg-12 am-cf">
									<div class="am-fr">
										<ul class="am-pagination tpl-pagination">
											<c:if test="${currentPageNo >0}">
												<li><a href="javascript:page_nav(document.forms[0],0);">首页</a></li>
												<li><a
													href="javascript:page_nav(document.forms[0],${currentPageNo-1});">上一页</a></li>
											</c:if>
											<c:if test="${currentPageNo+1 < totalPageCount }">
												<li><a
													href="javascript:page_nav(document.forms[0],${currentPageNo+1 });">下一页</a></li>

												<li><a
													href="javascript:page_nav(document.forms[0],${totalPageCount-1 });">最后一页</a>
												</li>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
	<script src="<%=basePath%>assets/js/amazeui.datatables.min.js"></script>
	<script src="<%=basePath%>assets/js/dataTables.responsive.min.js"></script>
	<script src="<%=basePath%>assets/js/app.js"></script>
	<script src="<%=basePath%>assets/js/rollpage1.js"></script>

</body>
<script type="text/javascript">
	function frmsubmit() {
		$("#fem").submit();
	}
</script>
</html>