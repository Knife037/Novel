<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.body{
		margin-top:1%;
		margin-left:20%;
		margin-right:20%;
	}
	.search{
		margin-left:60%;
		margin-right:%;
		width:40%;
		
	}
	.table{
		margin-top:3%;
	}
</style>
</head>
<body>
<%@ include file="navigation.html"%>
<div class="body">
	<form class="search input-group" action="" method="post">
		<input name="keyword" type="text" class="form-control" placeholder="请输入小说名"/>
		<span class="input-group-btn">
			<button id="searchBtn" class="btn btn-default">搜索</button>
		</span>
	</form>
	<div class="table">
		<table class="table table-striped table-hover table-bordered">
			<colgroup>
				<col />
				<col width="20%"/>
				<col width="5%"/>
			</colgroup>
			<thead>
				<th>小说名</th>
				<th>网址</th>
				<th>操作</th>
			</thead>
			<tbody>
				<c:forEach var="novel" items="${novels}">
					<tr>
						<td>${novel.name}</td>
						<td>${novel.url}</td>
						<td>
							<button type="button" data-name="${novel.name}" data-url="${novel.url}" class="btn btn-primary btn-sm">订阅</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div>
</div>
<form id="form-add" action="addNovel" method="post">
<input id="form-name" type="hidden" name="name" value=""/>
<input id="form-url" type="hidden" name="url" value=""/>
</form>
</body>
<script src="dist/js/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("#addsubscription").attr("class", "active");
		$("table button").click(function () {
			var form = $("#form-add");
			var name = $(this).attr("data-name");
			var url = $(this).attr("data-url");
			$("#form-name").attr("value", name);
			$("#form-url").attr("value", url);
			form.submit();
		});
	});
</script>
</html>