<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../pages/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../../pages/css/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../../pages/css/bootstrap/style.css">
    <link rel="stylesheet" href="../../pages/css/bootstrap/animate.css">
    <script src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script src="../../pages/js/bootstrap.min.js"></script>
    <script src="../../pages/js/marine/register.js"></script>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">H+</h1>

        </div>
        <h3>欢迎注册 H+</h3>
        <p>创建一个H+新账户</p>
        <form class="m-t registerForm" role="form" name="registerDto">
            <div class="form-group">
                <input type="text" class="form-control" name="userName" placeholder="请输入用户名" required="">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="nickName" placeholder="请输入昵称" required="">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="emailAddress" placeholder="请输入注册邮箱" required="">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="mobile" placeholder="请输入手机" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="passwordRepeat" placeholder="请再次输入密码" required="">
            </div>
            <div class="form-group text-left">
                <div class="checkbox i-checks">
                    <label class="no-padding">
                        <input type="checkbox"><i></i> 我同意注册协议</label>
                </div>
            </div>
            <button onclick="registerAjax();return false;" class="btn btn-primary block full-width m-b">注 册</button>

            <p class="text-muted text-center"><small>已经有账户了？</small><a href="/Login/login">点此登录</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
