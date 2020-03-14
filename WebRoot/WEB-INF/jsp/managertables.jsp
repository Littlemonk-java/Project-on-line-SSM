<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
<link rel="shortcut icon" href="<%=basePath%>assets/img/favicon.png"
	type="image/x-icon">

<!--Basic Styles-->
<link href="<%=basePath%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link id="bootstrap-rtl-link" href="" rel="stylesheet" />
<link href="<%=basePath%>assets/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>assets/css/weather-icons.min.css"
	rel="stylesheet" />

<!--Fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300"
	rel="stylesheet" type="text/css">

<!--Beyond styles-->
<link id="beyond-link" href="<%=basePath%>assets/css/beyond.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>assets/css/demo.min.css" rel="stylesheet" />
<link href="<%=basePath%>assets/css/typicons.min.css" rel="stylesheet" />
<link href="<%=basePath%>assets/css/animate.min.css" rel="stylesheet" />
<link id="skin-link" href="" rel="stylesheet" type="text/css" />
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
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
								style="display:none">
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

				<li class="sidebar-nav-link"><a class="active"
					href="${pageContext.request.contextPath }/sys/mamagerindex.html">
						<i class="am-icon-home sidebar-nav-link-logo"></i> 首页
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


			<div class="row-content am-cf">

				<div class="row">
					<div class="col-lg-12 col-sm-12 col-xs-12">
						<div class="row">
							<div class="col-lg- col-sm-6 col-xs-12">
								<div class="widget radius-bordered">
									<img
										src="<%=basePath %>assets/uploadfiles/${priject.projectintr}"
										width="100%px" height="400px">
								</div>
							</div>
							<div class="col-lg-6 col-sm-6 col-xs-6">
								<div class="widget  radius-bordered">
									<div class="widget-header">
										<span class="widget-caption">项目上传者信息</span>
									</div>
									<div class="widget-body">
										<form id="togglingForm" method="post" class="form-horizontal">

											<div class="form-group">
												<label class="col-lg-2 control-label">用户姓名 <sup>*</sup></label>
												<div class="col-lg-8">
													<input type="text" class="form-control" name="firstName"
														value="${userinfoproject.name }" readonly="readonly" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">邮箱 <sup>*</sup></label>
												<div class="col-lg-8">
													<input type="text" class="form-control"
														value="${userinfoproject.email }" name="company"
														readonly="readonly" required
														data-bv-notempty-message="The company name is required" />
												</div>

											</div>

											<!-- These fields will not be validated as long as they are not visible -->

											<div class="form-group">
												<label class="col-lg-2 control-label">电话 <sup>*</sup></label>
												<div class="col-lg-8">
													<input readonly="readonly"
														value="${userinfoproject.phone }" type="text"
														class="form-control" name="mobilePhone" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-2 control-label">账户余额 <sup>*</sup></label>
												<div class="col-lg-8">
													<input readonly="readonly"
														value="${userinfoproject.balance }￥" type="text"
														class="form-control" name="mobilePhone" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-2 control-label">注册时间 <sup>*</sup></label>
												<div class="col-lg-8">
													<input readonly="readonly"
														value="<fmt:formatDate
									value="${userinfoproject.registration }" pattern="yyyy-MM-dd" />"
														type="text" class="form-control" name="mobilePhone" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-2 control-label">上传数量 <sup>*</sup></label>
												<div class="col-lg-8">
													<input readonly="readonly"
														value="至今已上传(${userinfoproject.grade })个项目" type="text"
														class="form-control" name="mobilePhone" />
												</div>
											</div>
											<div class="form-group"></div>


											<hr class="wide" />
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-lg-12 col-sm-12 col-xs-12">
								<div class="widget  radius-bordered">
									<div class="widget-header">
										<span class="widget-caption">项目信息</span>
									</div>
									<div class="widget-body">
										<form id="html5Form" method="post" class="form-horizontal">
											<div class="form-group">
												<label class="col-lg-1 control-label">项目编号</label>
												<div class="col-lg-4">
													<input type="text" class="form-control" name="id"
														value="${priject.id }" readonly="readonly" />
												</div>
												<label class="col-lg-2 control-label">项目名称</label>
												<div class="col-lg-4">
													<input type="text" class="form-control" name="projectname"
														value="${priject.projectname }" readonly="readonly" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-1 control-label">项目起拍金额</label>
												<div class="col-lg-4">
													<input class="form-control" name="bzmoney"
														value="${priject.bzmoney}" readonly="readonly" />
												</div>
												<label class="col-lg-2 control-label">项目类型</label>
												<div class="col-lg-4">
													<input id="projecttype" type="text" class="form-control"
														name="projecttype" value="${priject.projecttype }"
														readonly="readonly" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-1 control-label">竞拍开始时间</label>
												<div class="col-lg-4">
													<input id="auctionstart" class="form-control"
														name="auctionstart" readonly="readonly" />
												</div>
												<label class="col-lg-2 control-label">预计竞拍结束时间</label>
												<div class="col-lg-4">
													<input id="auctionend" type="text" class="form-control"
														name="auctionend" readonly="readonly" />
												</div>
												<input type="hidden" name="examine" value="通过" /> <input
													type="hidden" name="notice" value="错误" />

											</div>
											<div class="form-group">
												<label class="col-lg-1 control-label">项目上传时间</label>
												<div class="col-lg-4">
													<input type="text" class="form-control" name="starttime"
														value="<fmt:formatDate 
								  						value="${priject.starttime }" pattern="yyyy-MM-dd" />"
														readonly="readonly" />
												</div>
											</div>
											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-5"></div>
												<div class="col-lg-9 col-lg-offset-9">
													<button onclick="btn1()" type="button"
														class="btn btn-warning">发布到项目市场</button>
													<button onclick="btn2()" type="button"
														class="btn btn-danger">撤销本次审核</button>
												</div>
											</div>
										</form>
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

</body>
<script type="text/javascript">
	$(function() {

		var mydate = new Date();
		var str = "" + mydate.getFullYear() + "-";
		str += (mydate.getMonth() + 1) + "-";
		str += mydate.getDate();
		var type = $("#projecttype").val();
		$("#auctionstart").val(str);
		if (type == "工具") {
			var now = new Date();
			now.setDate(now.getDate() + 7);
			var t = now.getFullYear() + "-" + (now.getMonth() + 1) + "-"
					+ now.getDate();
			$("#auctionend").val(t);
		}
		if (type == "网站") {
			var now = new Date();
			now.setDate(now.getDate() + 3);
			var t = now.getFullYear() + "-" + (now.getMonth() + 1) + "-"
					+ now.getDate();
			$("#auctionend").val(t);
		}
		if (type == "博客") {
			var now = new Date();
			now.setDate(now.getDate() + 2);
			var t = now.getFullYear() + "-" + (now.getMonth() + 1) + "-"
					+ now.getDate();
			$("#auctionend").val(t);
		}

	});

	function btn1() {
		$("#html5Form").attr("action",
				'${pageContext.request.contextPath }/sys/adopt.html');
		$("#html5Form").submit();
	}

	function btn2() {
		$("#html5Form").attr("action",
				'${pageContext.request.contextPath }/sys/Revoke.html');
		$("#html5Form").submit();
	}
	function picture() {
		document.getElementById("btn_file").click();
		var path = $("#btn_file").val();
		$("#frm2").submit();

	}
</script>
</html>