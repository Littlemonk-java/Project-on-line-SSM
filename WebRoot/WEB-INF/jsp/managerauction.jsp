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

				</a>
			</ul>
			</li>

			</ul>
		</div>


		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">
			<div class="row-content am-cf">
				<div id="two" class="row">
					<div id="one" class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">项目列表</div>

								<div class="widget-body  am-fr">
									<div class="am-u-sm-12 am-u-md-6 am-u-lg-8">
										<div class="am-form-group">
											<div class="am-btn-toolbar"></div>
											<div class="am-btn-group am-btn-group-xs">
												<button type="button"
													class="am-btn am-btn-default am-btn-danger">
													<span class="am-icon-trash-i"></span> 输入条件
												</button>
											</div>
										</div>
									</div>
									<form id="frme"
										action="${pageContext.request.contextPath }/sys/managerAuction.html"
										" method="post">
										<div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
											<div
												class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
												<input type="text" name="projectname" class="am-form-field ">
												<span class="am-input-group-btn">
													<button onclick="frme()"
														class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
														type="button"></button>
												</span> <input type="hidden" name="pageIndex" id="pageIndex" />
											</div>
										</div>
									</form>

									<div class="am-u-sm-12">
										<table width="100%"
											class="am-table am-table-compact am-table-striped tpl-table-black "
											id="example-r">
											<thead>
												<tr>
													<th>项目编号</th>
													<th>项目名称</th>
													<th>上传者</th>
													<th>竞拍人数</th>
													<th>结束时间</th>
													<th>起拍价格</th>
													<th>是否完成</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list }" var="list">
													<tr class="gradeX">
														<td>${list.id }</td>
														<td>${list.projectname }</td>
														<td>${list.name }</td>
														<td>${list.auctionnum }</td>
														<td>${list.auctionend }</td>
														<td>${list.bzmoney }</td>
														<td>${list.state }</td>
														<td>
															<div class="tpl-table-black-operation asd"
																aid="${list.id }" time="${list.auctionend}" stste="${list.state }" porname="${list.name }">
																<a class="tpl-table-black-operation-del"> <i
																	class="am-icon-trash"></i> 详情
																</a>
															</div>
														</td>
													</tr>
												</c:forEach>


												<!-- more data -->
											</tbody>
										</table>
									</div>
									<div class="am-u-lg-12 am-cf">

										<div class="am-fr">
											<ul class="am-pagination tpl-pagination">
												<c:if test="${currentPageNo >0}">
													<li><a
														href="javascript:page_nav(document.forms[1],0);">首页</a></li>
													<li><a
														href="javascript:page_nav(document.forms[1],${currentPageNo-1});">上一页</a></li>
												</c:if>
												<c:if test="${currentPageNo+1 < totalPageCount }">
													<li><a
														href="javascript:page_nav(document.forms[1],${currentPageNo+1 });">下一页</a></li>

													<li><a
														href="javascript:page_nav(document.forms[1],${totalPageCount-1 });">最后一页</a>
													</li>
												</c:if>
												
											</ul>
											<input type="hidden" id="idhidden" value=""/>
											<input type="hidden" id="porname" value=""/>
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
	</div>
	<script src="http://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
	<script src="<%=basePath%>assets/js/amazeui.datatables.min.js"></script>
	<script src="<%=basePath%>assets/js/dataTables.responsive.min.js"></script>
	<script src="<%=basePath%>assets/js/app.js"></script>
	<script src="<%=basePath%>assets/js/rollpage1.js"></script>

</body>
<script type="text/javascript">
	function picture() {
		document.getElementById("btn_file").click();
		var path = $("#btn_file").val();
		$("#frm2").submit();

	}
	function frme(id) {
		$("#frme").submit();
	}
	$(".asd").on("click",function(){
		$("#three").remove();
		var div = "<div id='three'  class='am-u-sm-12 am-u-md-12 am-u-lg-4'><div  class='widget am-cf'><div id='six' class='widget-head am-cf'><div  class='widget-title  am-cf'>竞拍详情</div><div class='am-u-sm-12'><table id='tableine' width='100%' class='am-table am-table-compact am-table-striped tpl-table-black 'id='example-r'><thead ><tr><th>出资金额</th><th>出资时间</th><th>出资者</th></tr></thead><tbody id='thread'></tbody></div></div></div>";
		document.getElementById("one").className = "am-u-sm-12 am-u-md-12 am-u-lg-8";
		$("#two").append(div);
		var timeend =$(this);
		var b = timeend.attr("time");
		var porname = timeend.attr("porname");
		$("#porname").val(porname);
	    var c=b.substring(10,b.Length-2);
	    var state = timeend.attr("stste");
		var time =Date.parse(c);
	    var date = new Date(); 
		var str = date.getFullYear() + "-";
		str += (date.getMonth() + 1) + "-";
		str += date.getDate();
		var oDate1 =  Date.parse(str);
		var oDate2 = time;
		
	   if (oDate1 > oDate2) {
		   if(state==""){
			   $("#foth").html("系统目前已检测到该项目竞拍已经结束！");
				var t = "<div class='am-btn-group am-btn-group-xs'><button onclick='tongji()' type='button'class='am-btn am-btn-default am-btn-danger'><span class='am-icon-trash-i'></span>开始统计</button></div>";
				$("#six").append(t);
		   }
			
		} else {
			$("#foth").html("系统目前已检测到该项目竞拍正在进行中！");
			
		} 
		
		var  wAccesso =$(this);
		var a = wAccesso.attr("aid");
		  var id= a;
			  $.ajax({
	              type : "GET" ,
		            url  :  "<%=basePath%>sys/autio",
							dataType : "JSON",
							data : {
								id : id
							},
							success : callBack,
							error : function() {
								alert("请求失败！");
							}
						});
						function callBack(JSONAuction) {
					
							for (var i = 0; i < JSONAuction.length; i++) {
								var table = "<tr class='gradeX'><td>"
										+ JSONAuction[i].contributive
										+ "</td><td>"
										+ JSONAuction[i].contributivetime
										+ "</td><td>" + JSONAuction[i].name
										+ "</td></tr></tbody>";
								$("#thread").append(table);
								if(JSONAuction[i].projectid==""){
									$("#idhidden").val("");
				
								}else{
									$("#idhidden").val(JSONAuction[i].projectid);
								}
								
							}
							

						}
					});
	function tongji() {
		if($("#idhidden").val()==""){
			alert("该项目没有竞拍信息");
		}else{
			var tableId = document.getElementById("tableine");
			for (var i = 1; i < tableId.rows.length; i++) {
				var num1 = tableId.rows[1].cells[0].innerHTML;
				var num = tableId.rows[1].cells[2].innerHTML;
				
			}
			
			window.location="${pageContext.request.contextPath }/sys/porject?id="+num1+"&name="+num+"&porid="+$("#idhidden").val()+"&pon="+$("#porname").val();
		}
		
	}
</script>
</html>