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
    <link href="../../pages/css/plugins/treeview/bootstrap-treeview.min.css" rel="stylesheet">

    <script type="text/javascript" src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="../../pages/js/bootstrap.min.js?v=3.4.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="../../pages/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="../../pages/js/hPlus.js?v=2.2.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/pace/pace.min.js"></script>
    <script type="text/javascript" src="../../pages/js/plugins/treeview/bootstrap-treeview.js"></script>
    <script type="text/javascript" src="../../pages/js/marine/organization.js"></script>
</head>
<body>
<div id="wrapper">
    <!-- 左边侧边栏 -->
    <jsp:include page="left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!-- 状态搜索栏 -->
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="panel panel-primary ">
                        <div class="panel-heading">
                            <h3 class="panel-title">组织树</h3>
                        </div>
                        <div class="ibox float-e-margins right_content">
                            <div class="ibox-content">
                                <div id="treeView"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
