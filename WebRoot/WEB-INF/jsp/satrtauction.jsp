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
	href="<%=basePath%>assets/style/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=basePath%>assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="<%=basePath%>assets/style/css/amazeui.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>assets/style/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=basePath%>assets/style/css/app.css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

</head>

<body data-type="widgets">
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
							src="<%=basePath%>assets/img/${userSession.picture}" alt="">
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
					href="${pageContext.request.contextPath }/sys/index.html"> <i
						class="am-icon-home sidebar-nav-link-logo"></i> 首页
				</a></li>
				<li class="sidebar-nav-link"><a class="active"
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
				</a>
			</ul>

		</div>



		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">
			<div class="row-content am-cf">
				<div class="row">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">项目列表</div>


							</div>
							<div class="widget-body  am-fr">
								<div style="width:100%; height:775px; overflow:scroll;">
									<div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
										<div class="am-form-group">
											<div class="am-u-sm-0 am-u-md-1 am-u-lg-1"></div>

										</div>
									</div>

									<form method="post"
										action="${pageContext.request.contextPath }/sys/startaution.html">
										<div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
											<div class="am-form-group tpl-table-list-select">
												<select name="projecttype"
													data-am-selected="{btnSize: 'sm'}">
													<option value=""></option>
													<option value="网站">网站</option>
													<option value="工具">工具</option>
													<option value="游戏">游戏</option>

												</select>
											</div>
										</div>
										<div class="am-u-sm-12 am-u-md-12 am-u-lg-3">

											<div
												class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
												<input name="projectname" type="text" class="am-form-field ">
												<span class="am-input-group-btn">
													<button
														class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
														type="submit"></button>
												</span>
											</div>
										</div>
									</form>


									<div class="am-u-sm-12">
										<table width="100%"
											class="am-table am-table-compact am-table-striped tpl-table-black ">
											<thead>
												<tr>
													<th>项目标准</th>
													<th>项目名称</th>
													<th>项目类型</th>
													<th>项目起价</th>
													<th>竞拍时间(始)</th>
													<th>竞拍时间(终)</th>
													<th>操作</th>

												</tr>
											</thead>
											<tbody>

												<c:forEach items="${list }" var="list">
													<tr class="gradeX">
														<td><img
															src="<%=basePath%>assets/uploadfiles/${list.projectintr}"
															class="tpl-table-line-img" alt=""></td>
														<td class="am-text-middle">${list.projectname }</td>
														<td class="am-text-middle">${list.projecttype }</td>
														<td class="am-text-middle">${list.bzmoney }</td>
														<td class="am-text-middle"><fmt:formatDate
																value="${list.auctionstart }"
																pattern="yyyy-MM-dd HH:mm:ss" /></td>
														<td class="am-text-middle"><fmt:formatDate
																value="${list.auctionend }"
																pattern="yyyy-MM-dd HH:mm:ss" /></td>

														<td class="am-text-middle">
															<div porname=${list.projectname } porid=${list.id }
																class="tpl-table-black-operation auction">
																<a href="javascript:;"> <i class="am-icon-pencil"></i>
																	参与竞价
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
			</div>
		</div>
	</div>
	</div>
	<input type="hidden" id="num" value="<%=request.getAttribute("num")%>">
	<script type="text/template" id="addTpl"> 
	<div>
		<form id="auction" action="${pageContext.request.contextPath }/sys/addauction.html">
</br>
			输入你的竞价额度：<input type="text" id="contributive" name="contributive" />
           
            <input id="id" type="hidden" name="projectid" />
		</form>
	</div>
</script>

	<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
	<script src="<%=basePath%>assets/style/js/app.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/layer/layer.js"></script>
</body>
<script type="text/javascript">
	function picture() {
		document.getElementById("btn_file").click();
		var path = $("#btn_file").val();
		$("#frm2").submit();

	}
	$(".auction").on("click", function() {
		var porname = $(this);
		var name = porname.attr("porname");
		var id = porname.attr("porid");
		layer.open({
			title : '您正在参与《' + name + '》的竞价',
			area : [ '400px', '180px' ],
			content : $('#addTpl').html(),
			btn : [ '保存', '取消' ],
			btn1 : function() {
				var num = $("#num").val();
				var money = $("#contributive").val();
				
				if (num > money) {
					$("#id").val(id);
					$("#auction").submit();
					alert("竞价成功");
				} else {
				   alert("余额不足！");
				}
			}
		});

	});
</script>
</html>