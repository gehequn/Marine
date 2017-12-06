<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>主页</title>

    <!-- CSS样式 -->
    <link href="../../pages/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../../pages/css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/animate.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/style.css" rel="stylesheet">
    <link href="../../pages/css/plugins/treeview/bootstrap-treeview.min.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/bootstrap-dialog.min.css" rel="stylesheet">
    <link href="../../pages/css/bootstrap/bootstrap-select.min.css" rel="stylesheet">


    <!-- Mainly scripts -->
    <script type="text/javascript" src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="../../pages/js/bootstrap.min.js?v=3.4.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="../../pages/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script type="text/javascript" src="../../pages/js/hPlus.js?v=2.2.0"></script>
    <script type="text/javascript" src="../../pages/js/plugins/pace/pace.min.js"></script>

    <!-- Bootstrap-TreeView plugin javascript -->
    <script type="text/javascript" src="../../pages/js/plugins/treeview/bootstrap-treeview.js"></script>
    <script type="text/javascript" src="../../pages/js/bootstrap-dialog.min.js"></script>
    <%--<script type="text/javascript" src="../../pages/js/demo/treeview-demo.js"></script>--%>
    <script type="text/javascript" src="../../pages/js/marine/organization.js"></script>
    <%--<script type="text/javascript" src="../../pages/js/bootstrap-select.min.js"></script>--%>

</head>
<body>
<div id="wrapper">
    <!-- 左边菜单栏 -->
    <jsp:include page="left.jsp"></jsp:include>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!-- 顶部菜单栏 -->
        <jsp:include page="header.jsp"></jsp:include>
        <header class="container" style="margin-bottom: 35px;">
            <div class="row">
                <div class="col-md-12">
                    <input id="btnAdd" class="btn btn-primary" type="button" value="添加节点">
                    <input id="btnEdit" class="btn btn-success" type="button" value="编辑节点">
                    <input id="btnDel" class="btn btn-danger" type="button" value="删除节点">
                </div>
            </div>
        </header>
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
                <div class="col-md-8">
                    <div class="panel panel-primary ">
                        <div class="panel-heading">
                            <h3 class="panel-title">编辑区</h3>
                        </div>
                        <div class="panel-body right_content">
                            <div>
                                <table class="table table-bordered table-del" id="delTable">
                                    <tbody>
                                    <tr>
                                        <td><span>名称:</span></td>
                                        <td><input id="delNodeName" type="text" class="form-control" disabled="disabled"/><input type="hidden" value="" id="delNodeId"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div>
                                <%--<div class="input-group margin-t-5">--%>
                                <%--<span class="input-group-addon" >父节点:</span>--%>
                                <%--<input id="addParentName" type="text"  class="form-control" />--%>
                                <%--</div>--%>
                                <table class="table table-bordered table-add" style="display:none;"  id="addTable">
                                    <tbody>
                                    <tr>
                                        <td><span>上级节点:</span></td>
                                        <td><input id="addParentName" type="text" class="form-control" disabled="disabled"/><input type="hidden" id="addParentId" value=""/></td>
                                    </tr>
                                    <tr>
                                        <td><span>节点名称:</span></td>
                                        <td><input id="addNodeName" type="text" class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div>
                                <table class="table table-bordered table-edit" style="display:none;"  id="editTable">
                                    <tbody>
                                    <tr>
                                        <td><span>上级节点:</span></td>
                                        <td>
                                            <select class="bootstrap-select form-control parentNode-select">
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>节点名称:</span></td>
                                        <td><input id="editNodeName" type="text" class="form-control"/><input type="hidden" id="editNodeId" value=""/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="margin-top: 10px;">
                                <input id="editButton" class="btn btn-primary" type="button" value="确定"/>
                                <%--<input id="Edit_cancel" class="btn btn-default" type="button" style="margin-left:80px;display:none;" value="取消" />--%>
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
