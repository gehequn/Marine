<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../pages/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../pages/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../../pages/css/style.css">
    <link rel="stylesheet" href="../../pages/css/animate.css">
    <script src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script src="../../pages/js/bootstrap.min.js"></script>
    <script src="../../pages/js/marine/login.js"></script>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">BGI</h1>
        </div>
        <h3>欢迎使用 H+</h3>
        <form class="m-t loginForm" role="form">
            <div class="form-group">
                <input type="text" name="userName" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <button onclick="loginAjax();return false;" class="btn btn-primary block full-width m-b">登 录</button>

            <p class="text-muted text-center"> <a href="login.jsp#"><small>忘记密码了？</small></a> | <a href="/Register/init">注册一个新账号</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
