<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>项目管理系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS样式 -->
    <link href="../../pages/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../../pages/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/animate.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/style.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/bootstrap-table.min.css" rel="stylesheet">

    <script type="text/javascript" src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="../../pages/js/bootstrap.min.js?v=3.4.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="../../pages/js/hPlus.js?v=2.2.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/pace/pace.min.js"></script>
    <script type="text/javascript" src="../../pages/js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="../../pages/js/marine/common/marine.js"></script>
    <script type="text/javascript" src="../../pages/js/marine/user.js"></script>
</head>
<body>
<div id="wrapper">
    <!-- 左边侧边栏 -->
    <jsp:include page="left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <%--<!-- 状态搜索栏 -->--%>
        <%--<jsp:include page="header.jsp"/>--%>
        <div class="panel-body" style="padding-bottom:0px;">
            <div class="panel panel-default">
                <div class="panel-heading">查询条件</div>
                <div class="panel-body">
                    <form id="formSearch" class="form-horizontal">
                        <div class="form-group" style="margin-top:15px">
                            <label class="control-label col-sm-1" for="txt_search_UserName">用户名</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_UserName">
                            </div>
                            <label class="control-label col-sm-1" for="txt_search_status">状态</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_status">
                            </div>
                            <div class="col-sm-2" style="text-align:left;">
                                <button type="button" style="margin-left:50px" id="user_query" class="btn btn-primary">查询</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <%--<div id="toolbar" class="btn-group">--%>
                <%--<button id="btn_add" type="button" class="btn btn-default">--%>
                    <%--<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增--%>
                <%--</button>--%>
                <%--<button id="btn_edit" type="button" class="btn btn-default">--%>
                    <%--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改--%>
                <%--</button>--%>
                <%--<button id="btn_delete" type="button" class="btn btn-default">--%>
                    <%--<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除--%>
                <%--</button>--%>
            <%--</div>--%>
            <table id="tb_userInfo"></table>
        </div>
    </div>
</div>
</body>
</html>
