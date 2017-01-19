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
</style>
</head>
<body>
<%@ include file="navigation.html"%>
<div class="body">
	<table class="table table-striped table-hover table-bordered">
		<colgroup>
			<col width="5%">
			<col width="20%">
			<col />
			<col width="5%">
		</colgroup>
		<thead>
			<th>小说ID</th>
			<th>小说名</th>
			<th>最新章节</th>
			<th>操作</th>
		</thead>
		<tbody>
			<c:forEach var="novel" items="${novels}">
			<tr>
				<td>${novel.id}</td>
				<td>${novel.name}</td>
				<td>${novel.rectChap}</td>
				<td>
					<button type="button" data-id="${novel.id}" class="btn btn-danger btn-sm">退订</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<form action="deleteNovel" method="post">
	<input id="novlID" type="hidden" name="id" value="" />
</form>
</body>


<script src="dist/js/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			var button = $(this);
			var id = button.attr("data-id");
			$("#novlID").attr("value", id);
			$("form").eq(0).submit();
		});
	})
</script>
<script>
	$(document).ready(function() {
		$("#subscription").attr("class", "active");
	});	
</script>
</html>