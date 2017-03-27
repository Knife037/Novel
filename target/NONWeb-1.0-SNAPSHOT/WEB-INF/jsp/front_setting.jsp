<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <title>Index</title>
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
                <li>
                    <a href="addsub">添加订阅</a>
                </li>
                <li>
                    <a href="about">关于作者</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.username} <span class="caret"></span></a>
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
    <div class="panel-default">
        <div class="panel-heading">
            <div class="panel-title"><h3>基本信息</h3></div>
        </div>
        <div class="panel-body">
            <div class="col-md-6 col-md-offset-3">
                <table class="table table-striped">
                    <tr>
                        <td>用户名</td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>昵称</td>
                        <td>${user.nickname}</td>
                    </tr>
                    <tr>
                        <td>邮箱</td>
                        <td>${user.email}</td>
                    </tr>
                </table>
                <form method="post">
                    <div class="form-group">
                        <label for="txtPassWord">昵称</label>
                        <input type="text" name="nickname" class="form-control" id="txtPassWord" placeholder="请输入昵称" />
                    </div>
                    <div class="form-group">
                        <label for="txtPassWord">密码</label>
                        <input type="password" name="password1" class="form-control" id="txtPassWord" placeholder="请输入密码" />
                    </div>
                    <div class="form-group">
                        <label for="txtPassWord">重复密码</label>
                        <input type="password" name="password2" class="form-control" id="txtPassWord" placeholder="请重复密码" />
                    </div>

                    <div class="form-group">
                        <label for="txtUserName">邮箱</label>
                        <input type="text" name="email" class="form-control" id="txtUserName" placeholder="请输入邮箱" />
                    </div>
                    <div class="form-group">
                        <button class="btn btn-default form-control" type="submit">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</html>