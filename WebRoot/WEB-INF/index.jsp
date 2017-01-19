<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		margin-left:15%;
		margin-right:15%;
	}
</style>
</head>
<body>
<%@ include file="navigation.html"%>
<div class="body">
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">简介&通知</div>
			<div class="panel-body">
				<ul>
<li><h4>欢迎来到BUG云集的xxx网站！！！！！！！！！！！！！</h4>
</li>
<li><h4>本网站会自动吧小说的最新章节发送到您设置的邮箱的里！这样就不必饱受追更之苦了。。</h4>
</li>
<li><h4>个人设置还没做好。。。。当然点一下也不会出问题。点“退订”时没有提示啊，小心不要手抖。。</h4>
</li>
<li><h4>界面和功能都比较简陋。。毕竟没花多少时间。。</h4>
</li>
<li><h4>可能会不定期关闭服务器。。。所以服务器会处于时开时关的状态。。。</h4>
</li>
<li><h4>人多的时候可能邮件通知会迟到。估计1000人以内的话，撑死了迟到10分钟，不要担心这个问题。</h4>
</li>
<li><h4>本网站纯粹是为了练手&实用。。。前端使用Bootstrap，后端使用Servlet MVC（应该有这种东西吧，类似于Struts。。）。<br/>
网站的原理相当简单，就是从<a href="http://www.biquge.com.tw/"><code>http://www.biquge.com.tw/</code></a>网站上获取信息，然后以邮件的形式发送给大家。<br/>
也就是说会有一些小说找不到的。。这就比较尴尬了</h4>
</li>
<li><h4>欢迎访问个人笔记网站，<a href="http://www.knife037.cn/Diary/login"><code>http://www.knife037.cn/Diary/login</code></a>。完全封闭，笔记内容不会被外界访问到。部分支持Markdown格式。对Markdown格式的有些内容支持不是很好，例如表格了。。。。（什么，你不知道Markdown。。。百度一下，这是记笔记的神格式）</h4>
</li>
<li><h4>欢迎提意见，可在留言板处留言</h4>
</li>
<li><h4>另外，大神轻喷。。。。。</h4>
</li>
</ul>
				
								
			</div>
		<div class="panel-footer">knife037<br>2017-01-19</div>
	</div>
</div>
</div>
</body>
<script src="dist/js/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("#home").attr("class", "active");
	});
</script>
</html>
