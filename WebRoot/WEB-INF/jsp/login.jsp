<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="assets/css/lohin.css" rel="stylesheet" />
	<style>
	  #one{
		color: #FFF;
		font-size: 80px
	   }
	   #two{
	   position: relative;
	 
	   
	   }
	</style>
  </head>
  
  <body >
  <div id="two" align="center">
    <p id="one">AAP is on line</p>
    </div>
		<div class="cont">
			<div class="form sign-in">
				<h2>欢迎回来</h2>
				<form id="frm1"  action="${pageContext.request.contextPath }/dologin.html" method="post">
				<label>
					<span>账号</span>
					<input type="text" name="admin"/>
				</label>
				<label>
					<span>密码</span>
					<input type="password" name="pwds"/>
				</label>
				
				<button type="submit" class="submit" >登录 </button>
				</form>
			</div>
			<div class="sub-cont">
				<div class="img">
					<div class="img__text m--up">
						<h2>我们中的一个？ </h2>
						<p>如果您有账号，请登录！</p>
					</div>
					<div class="img__text m--in">
						<h2>我们中的一个？ </h2>
						<p>如果您是管理员，请登录。我们需要你！ </p>
					</div>
					<div class="img__btn">
						<span class="m--up">后台</span>
						<span class="m--in">前台 </span>
					</div>
				</div>
				<form action="${pageContext.request.contextPath }/dobaklogin.html">
				<div class="form sign-up">
					<h2>感觉像家一样的时间</h2>
					<label>
						<span>账号</span>
						<input name="name" type="text" />
					</label>
					<label>
						<span>密码</span>
						<input name="pwd" type="password" />
					</label>
				
					<button type="submit" class="submit">登录	</button>
					
				</div>
				</form>
			</div>
		</div>
		<script>
			document.querySelector('.img__btn').addEventListener('click', function() {
			  document.querySelector('.cont').classList.toggle('s--signup');
			});
		</script>
  </body>
</html>
