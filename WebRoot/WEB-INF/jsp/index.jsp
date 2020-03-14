<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	href="<%=basePath%>assets/style/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=basePath%>assets/style/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="http://cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>assets/style/css/amazeui.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>assets/style/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=basePath%>assets/style/css/app.css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

</head>

<body data-type="index">
	<script src="<%=basePath%>assets/style/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 头部 -->
		<header>
			<!-- logo -->
			<div class="am-fl tpl-header-logo">
				<a href="javascript:;"><img
					src="<%=basePath%>assets/style/img/logo.png" alt=""></a>
			</div>
			<!-- 右侧内容 -->
			<div class="tpl-header-fluid">
				<!-- 侧边切换 -->
				<div class="am-fl tpl-header-switch-button am-icon-list">
					<span> </span>
				</div>
				<!-- 搜索 -->
				<div class="am-fl tpl-header-search">
					<form class="tpl-header-search-form" action="javascript:;">
						<button class="tpl-header-search-btn am-icon-search"></button>
						<input class="tpl-header-search-box" type="text"
							placeholder="搜索内容...">
					</form>
				</div>
				<!-- 其它功能-->
				<div class="am-fr tpl-header-navbar">
					<ul>
						<!-- 欢迎语 -->
						<li class="am-text-sm tpl-header-navbar-welcome"><a
							href="javascript:;">欢迎你, <span>Amaze UI</span>
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
					href="${pageContext.request.contextPath }/sys/index.html"
					class="active"> <i class="am-icon-home sidebar-nav-link-logo"></i>
						首页
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/startaution.html">
						<i class="am-icon-table sidebar-nav-link-logo"></i> 项目市场
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/addporject.html">
						<i class="am-icon-calendar sidebar-nav-link-logo"></i> 上传项目
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/Auction.html"> <i
						class="am-icon-wpforms sidebar-nav-link-logo"></i> 竞拍跟踪
				</a></li>

			</ul>
		</div>

		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">

			<div class="row-content am-cf">

				<div class="row am-cf">

					<div class="am-u-sm-12 am-u-md-4">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">目前项目排行</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>
							<div class="widget-body widget-body-md am-fr">

								<c:forEach items="${gradeList }" var="grade">
									<div class="am-progress-title">
										${grade.projectname } <span
											class="am-fr am-progress-title-more">${grade.one }% /
											100%</span>
									</div>
									<div class="am-progress">
										<div class="am-progress-bar" style="width: ${grade.one }%"></div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="am-u-sm-8 am-u-md-8 am-u-lg-8 widget-margin-bottom-lg">

						<div class="widget am-cf widget-body-lg">
							<div style="width:100%; height:275px; overflow:scroll;">
								<div class="widget-head am-cf">
									<div class="widget-title am-fl">拍到的项目</div>
									<div class="widget-function am-fr">
										<a href="javascript:;" class="am-icon-cog"></a>
									</div>
								</div>
								<div class="widget-body  am-fr">

									<div class="am-scrollable-horizontal ">


										<table width="100%"
											class="am-table am-table-compact am-text-nowrap tpl-table-black "
											id="example-r">
											<thead>
												<tr>
													<th>项目名称</th>
													<th>项目类型</th>
													<th>项目起拍价</th>
													<th>最终拍价</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listdowload }" var="listdowload">
													<tr class="gradeX">
														<td>${listdowload.projectname }</td>
														<td>${listdowload.projecttype }</td>
														<td>${listdowload.bzmoney }￥</td>
														<td>${listdowload.auctionmoney }￥</td>
														<td>
															<div class="tpl-table-black-operation">
																<a
																	href="${pageContext.request.contextPath }/download/${listdowload.id}">
																	<i class="am-icon-pencil"></i> 下载
																</a>
															</div>
														</td>
													</tr>
												</c:forEach>

												<!-- more data -->
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="row am-cf">

					<div
						class="am-u-sm-12 am-u-md-12 am-u-lg-12 widget-margin-bottom-lg">
						<div style="width:100%; height:475px; overflow:scroll;">

							<div class="widget am-cf widget-body-lg">
								<div class="widget-head am-cf">
									<div class="widget-title am-fl">项目信息</div>
									<div class="widget-function am-fr">
										<a href="javascript:;" class="am-icon-cog"></a>
									</div>
								</div>
								<div class="widget-body  am-fr">
									<div class="am-scrollable-horizontal ">
										<table width="100%"
											class="am-table am-table-compact am-text-nowrap tpl-table-black "
											id="example-r">
											<thead>
												<tr>
													<th style="text-align:center;">项目名称</th>
													<th style="text-align:center;">项目类型</th>
													<th style="text-align:center;">上传时间</th>
													<th style="text-align:center;">审核状态</th>
													<th style="text-align:center;">竞拍时间(始)</th>
													<th style="text-align:center;">竞拍时间(终)</th>
													<th style="text-align:center;">竞拍人数</th>
													<th style="text-align:center;">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list }" var="list">
													<tr class="gradeX">
														<td style="text-align:center;">${list.projectname }</td>
														<td style="text-align:center;">${list.projecttype }</td>
														<td style="text-align:center;"><fmt:formatDate
																value="${list.starttime }" pattern="yyyy-MM-dd" /></td>
														<td style="text-align:center;">${list.examine }</td>
														<td style="text-align:center;"><fmt:formatDate
																value="${list.auctionstart }" pattern="yyyy-MM-dd" /></td>
														<td style="text-align:center;"><fmt:formatDate
																value="${list.auctionend }" pattern="yyyy-MM-dd" /></td>
														<td style="text-align:center;"><c:if
																test="${list.auctionnum !=0}">
														${list.auctionnum }(人)
														</c:if></td>
														<td style="text-align:center;"><c:if
																test="${list.examine!='通过'}">
																<div class="tpl-table-black-operation">
																	<a
																		href="${pageContext.request.contextPath }/sys/again/${list.id}">
																		<i class="am-icon-pencil"></i> 重新提交
																	</a> <a
																		href="${pageContext.request.contextPath }/sys/deletepor/${list.id}"
																		class="tpl-table-black-operation-del"> <i
																		class="am-icon-trash"></i> 删除
																	</a>
																</div>
															</c:if> <c:if test="${list.examine=='通过'}">
																<div class="tpl-table-black-operation">
																	<a href="javascript:;"
																		class="tpl-table-black-operation-del"> <i
																		class="am-icon-trash"></i> 禁止操作
																	</a>
																</div>
															</c:if></td>
													</tr>
												</c:forEach>


												<!-- more data -->
											</tbody>
										</table>
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
	<script src="<%=basePath%>assets/style/js/amazeui.datatables.min.js"></script>
	<script src="<%=basePath%>assets/style/js/dataTables.responsive.min.js"></script>
	<script src="<%=basePath%>assets/style/js/app.js"></script>

</body>
<script type="text/javascript">
	function picture() {
		document.getElementById("btn_file").click();
		var path = $("#btn_file").val();
		$("#frm2").submit();

	}
</script>
</html>