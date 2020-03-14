<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">



<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="http://cdn.bootcss.com/echarts/3.3.2/echarts.min.js"></script>
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="assets/css/app.css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
</head>

<body data-type="index">
	<script src="assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 头部 -->
		<header> <!-- logo -->
		<div class="am-fl tpl-header-logo">
			<a href="javascript:;"><img src="assets/img/logo.png" alt=""></a>
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
						<img onclick="picture()" src="assets/img/${userSession.picture}"
							alt="">
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
					href="${pageContext.request.contextPath }/sys/mamagerindex.html"
					class="active"> <i class="am-icon-home sidebar-nav-link-logo"></i>
						首页
				</a></li>

				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerUser.html">
						<i class="am-icon-calendar sidebar-nav-link-logo"></i> 用户管理
				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerFinance.html">
						<i class="am-icon-wpforms sidebar-nav-link-logo"></i> 财务统计

				</a></li>
				<li class="sidebar-nav-link"><a
					href="${pageContext.request.contextPath }/sys/managerAuction.html">
						<i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 竞拍跟踪

				</a></li>
			</ul>
		</div>

		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">


			<div style="display: none;">
				<table id="tongji">
					<tr>
						<td>1111</td>
					</tr>
					<c:forEach items="${finaList}" var="fin">
						<tr>
							<td>${fin.num}</td>
							<td>${fin.projectname}</td>
						</tr>
					</c:forEach>
				</table>
			</div>


			<div class="row-content am-cf">

				<div class="row  am-cf">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">月度财务收支计划</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>
							<div class="widget-body am-fr">
								<div class="am-fl">
									<div class="widget-fluctuation-period-text">
										￥61746.45
										<button class="widget-fluctuation-tpl-btn">
											<i class="am-icon-calendar"></i> 更多月份
										</button>
									</div>
								</div>
								<div class="am-fr am-cf">
									<div class="widget-fluctuation-description-amount text-success"
										am-cf>+￥30420.56</div>
									<div class="widget-fluctuation-description-text am-text-right">
										8月份收入</div>
								</div>
							</div>
						</div>

					</div>

					<div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
						<div class="widget widget-primary am-cf">
							<div class="widget-statistic-header">本季度利润</div>
							<div class="widget-statistic-body">
								<div class="widget-statistic-value">￥27,294</div>
								<div class="widget-statistic-description">
									本季度比去年多收入 <strong>2593元</strong> 人民币
								</div>
								<span class="widget-statistic-icon am-icon-credit-card-alt"></span>
							</div>
						</div>

					</div>

					<div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
						<div class="widget widget-purple am-cf">
							<div class="widget-statistic-header">本季度利润</div>
							<div class="widget-statistic-body">
								<div class="widget-statistic-value">￥27,294</div>
								<div class="widget-statistic-description">
									本季度比去年多收入 <strong>2593元</strong> 人民币
								</div>
								<span class="widget-statistic-icon am-icon-support"></span>
							</div>
						</div>
					</div>
				</div>

				<div class="row am-cf">
					<div class="am-u-sm-12 am-u-md-8">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">上周财务收入</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>
							<div
								class="widget-body-md widget-body tpl-amendment-echarts am-fr"
								id="tpl-echarts"></div>
						</div>
					</div>

					<div class="am-u-sm-12 am-u-md-4">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">项目竞标指数</div>
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
				</div>


				<div class="row am-cf">
					<div
						class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
						<div class="tpl-user-card am-text-center widget-body-lg">
							<div class="tpl-user-card-title">${userlist.name}</div>
							<div class="achievement-subheading" style="font-size: 20px">上传项目最多的用户</div>
							<img onclick="show()" class="achievement-image"
								src="assets/img/${userlist.picture}" width="90px" height="90px">
							<div class="achievement-description">
								<strong>${userlist.name}是所有用户中上传项目做多的 人。</strong>
							</div>
						</div>
					</div>

					<div
						class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">

						<div class="widget am-cf widget-body-lg">

							<div class="widget-body  am-fr">
								<div class="am-scrollable-horizontal ">
									<table width="100%"
										class="am-table am-table-compact am-text-nowrap tpl-table-black "
										id="example-r">
										<thead>
											<tr>
												<th>项目名称</th>
												<th width="150px">作者</th>
												<th width="150px">审核状态</th>
												<th width="150px">时间</th>
												<th align="center" width="150px">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${proList}" var="por">
												<tr class="gradeX">
													<td>${por.projectname }</td>
													<td>${por.name }</td>
													<td><fmt:formatDate value="${por.starttime }"
															pattern="yyyy-MM-dd" /></td>
													<td>${por.examine }</td>
													<td>
														<div class="tpl-table-black-operation">
															<a
																href="${pageContext.request.contextPath }/sys/views/${por.id}">
																<i class="am-icon-pencil"></i> 审核
															</a> <a
																href="${pageContext.request.contextPath }/sys/delete/${por.id}"
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
								</div>
							</div>
							<form id="frmfoth" method="post"
								action="${pageContext.request.contextPath }/sys/mamagerindex.html">
								<input type="hidden" name="pageIndex" id="pageIndex" />
							</form>
							<input type="hidden" id="nameone" value="${userlist.name}" />

							<div align="right" class="page-bar">
								<ul class="page-num-ul clearfix">

									<c:if test="${currentPageNo > 0}">
										<a href="javascript:page_nav(document.forms[1],0);">首页</a>
										<a
											href="javascript:page_nav(document.forms[1],${currentPageNo-1});">上一页</a>
									</c:if>
									<c:if test="${currentPageNo >= totalPageCount }">
										<a
											href="javascript:page_nav(document.forms[1],${currentPageNo+1 });">下一页</a>

										<a
											href="javascript:page_nav(document.forms[1],${totalPageCount });">最后一页</a>
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
	<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
	<script src="assets/js/amazeui.datatables.min.js"></script>
	<script src="assets/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/app.js"></script>
	<script type="text/javascript" src="assets/js/rollpage1.js"></script>

</body>
<script type="text/javascript">
	var tab = document.getElementById("tongji");
	var rows = tab.rows;
	var one = rows[1].cells[0].innerHTML;
	var two = rows[2].cells[0].innerHTML;
	var three = rows[3].cells[0].innerHTML;
	var foth = rows[4].cells[0].innerHTML;
	var five = rows[5].cells[0].innerHTML;
	var six = rows[6].cells[0].innerHTML;
	var seven = rows[7].cells[0].innerHTML;

	function picture() {
		document.getElementById("btn_file").click();
		var path = $("#btn_file").val();
		$("#frm2").submit();

	}
	function show() {
		var num = $("#nameone").val();
		$("#frmfoth").html(
				"<input type='hidden' name='name' value='${userlist.name}'>");
		$("#frmfoth").submit();
	}
	$(function() {
		//获取table序号 
		var tab = document.getElementById("tongji");
		//获取行数 
		var rows = tab.rows;
		//遍历行 
		
		//遍历表格列 

	});
</script>
</html>
