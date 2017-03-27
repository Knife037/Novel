<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27
  Time: 19:29
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

<div class="container">
    <div class="row">
        <form class="col-md-offset-4 col-md-4">
            <div class="form-group">
                <label for="txtUserName">用户名</label>
                <input type="text" name="username" class="form-control" id="txtUserName" placeholder="请输入用户名" />
            </div>
            <div class="form-group">
                <label for="txtUserName">昵称</label>
                <input type="text" name="nickname" class="form-control" id="txtUserName" placeholder="请输入昵称" />
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
                <button class="btn btn-default form-control" type="submit">注册</button>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</html>