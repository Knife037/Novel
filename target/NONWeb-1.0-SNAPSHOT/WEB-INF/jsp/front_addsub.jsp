<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/25
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <title></title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">KITRST</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="index">首页</a>
                </li>
                <li>
                    <a href="mysub">我的订阅</a>
                </li>
                <li class="active">
                    <a href="addsub">添加订阅</a>
                </li>
                <li>
                    <a href="about">关于作者</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${username} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="setting">设置</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="logout">注销</a></li>
                    </ul>
                </li>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 col-md-offset-4">
                    <form class="form-inline" method="post">
                        <div class="from-group">
                            <input name="novelName" type="text" class="form-control" placeholder="Search">
                            <button type="submit" class="btn btn-default">Search</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <table class="table table-bordered">
                <tr>
                    <th>小说名</th>
                    <th>URL</th>
                    <th>操作</th>
                </tr>

                <c:forEach var="novel" items="${novels}">
                    <tr>
                        <td>${novel.novelName}</td>
                        <td>${novel.url}</td>
                        <td>
                            <form action="addSubscribe" method="post">
                                <input type="hidden" name="novelName" value="${novel.novelName}"/>
                                <input type="hidden" name="url" value="${novel.url}"/>
                                <button type="submit" class="btn btn-success btn-sm">ADD</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</html>
