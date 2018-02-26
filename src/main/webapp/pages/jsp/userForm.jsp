<%--<%@ page import="com.bgi.marine.bean.vo.UserVo" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
    <%--UserVo userVo = (UserVo)request.getAttribute("operaUserInfo");--%>
<%--%>--%>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../../pages/css/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <form class="form-horizontal" role="form" name="registerDto">
        <fieldset>
            <legend>用户基本信息</legend>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="edit_userName">用户名</label>
                <div class="col-sm-4">
                    <input class="form-control" id="edit_userName" type="text" placeholder="11"/>
                </div>
                <label class="col-sm-2 control-label" for="edit_nickName">昵称</label>
                <div class="col-sm-4">
                    <input class="form-control" id="edit_nickName" type="text" placeholder="msh"/>
                </div>
            </div>
        </fieldset>
        <fieldset>
            <legend>用户菜单权限</legend>
        </fieldset>
        <fieldset>
            <legend>用户功能权限</legend>
        </fieldset>
    </form>
</body>
</html>
