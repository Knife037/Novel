<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta charset="utf-8">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<style>
.body {
	margin-top: 1%;
	margin-left: 25%;
	margin-right: 25%;
}
</style>
</head>
<body>
	<%@ include file="navigation.html"%>
	<div class="body">
	<blockquote>
		<h3>
		请手动发邮件到<code>knife037@163.com</code>。。。留言板功能待我完善一下。。。<br/>
		当然，熟人直接发QQ就好了。^-^
		</h3>
	</blockquote>
	</div>
</body>
<script src="dist/js/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("#messageBoard").attr("class", "active");
	});
</script>
</html>

