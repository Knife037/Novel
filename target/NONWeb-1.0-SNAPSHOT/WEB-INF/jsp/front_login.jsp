<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/25
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form method="post">
                <div class="form-group">
                    <label for="txtUserName">用户名</label>
                    <input type="text" name="username" class="form-control"
                           id="txtUserName" placeholder="请输入用户名" />
                </div>
                <div class="form-group">
                    <label for="txtPassWord">密码</label>
                    <input type="password" name="password" class="form-control"
                           id="txtPassWord" placeholder="请输入密码" />
                </div>

                <div class="form-group">
                    <button class="btn btn-default form-control" type="submit">登录</button>

                </div>
                <div class="form-group">
                    <a class="btn btn-default form-control" href="register">注册</a>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
