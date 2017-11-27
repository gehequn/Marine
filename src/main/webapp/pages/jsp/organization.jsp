<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>项目管理系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap/style.css">
    <script src="../../pages/js/jquery-2.1.1.min.js"></script>
    <script src="../../pages/js/bootstrap.min.js"></script>
    <script src="../../pages/js/layer.min.js"></script>
</head>
<body>
<div id="wrapper">
    <!-- 左边侧边栏 -->
    <jsp:include page="left.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!-- 状态搜索栏 -->
        <jsp:include page="header.jsp"/>
        <div class="content_wrap">
            <div class="zTreeDemoBackground left">
                <ul id="treeDemo" class="ztree">
                    <li id="treeDemo_1" class="level0" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_1_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="文件夹"><span id="treeDemo_1_switch" title="" class="button level0 switch noline_open" treenode_switch=""></span><span id="treeDemo_1_ico" title="" treenode_ico="" class="button ico_open" style="width:0px;height:0px;"></span><span id="treeDemo_1_span" class="node_name">文件夹</span></a>
                        <ul id="treeDemo_1_ul" class="level0 " style="display: block;">
                            <li id="treeDemo_2" class="level1" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_2_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="收件箱"><span id="treeDemo_2_switch" title="" class="button level1 switch noline_close" treenode_switch=""></span><span id="treeDemo_2_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="treeDemo_2_span" class="node_name">收件箱</span></a>
                                <ul id="treeDemo_2_ul" class="level1 " style="display: none;">
                                    <li id="treeDemo_3" class="level2" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_3_a" class="level2" treenode_a="" onclick="" target="_blank" style="" title="收件箱1"><span style="display: inline-block;width:10px"></span><span id="treeDemo_3_switch" title="" class="button level2 switch noline_close" treenode_switch=""></span><span id="treeDemo_3_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="treeDemo_3_span" class="node_name">收件箱1</span></a>
                                        <ul id="treeDemo_3_ul" class="level2 " style="display: none;">
                                            <li id="treeDemo_4" class="level3" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_4_a" class="level3" treenode_a="" onclick="" target="_blank" style="" title="收件箱2"><span style="display: inline-block;width:15px"></span><span id="treeDemo_4_switch" title="" class="button level3 switch noline_close" treenode_switch=""></span><span id="treeDemo_4_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="treeDemo_4_span" class="node_name">收件箱2</span></a>
                                                <ul id="treeDemo_4_ul" class="level3 " style="display: none;">
                                                    <li id="treeDemo_5" class="level4" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_5_a" class="level4 curSelectedNode" treenode_a="" onclick="" target="_blank" style="" title="收件箱3"><span style="display: inline-block;width:20px"></span><span id="treeDemo_5_switch" title="" class="button level4 switch noline_close" treenode_switch=""></span><span id="treeDemo_5_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="treeDemo_5_span" class="node_name">收件箱3</span></a>
                                                        <ul id="treeDemo_5_ul" class="level4 " style="display: none;">
                                                            <li id="treeDemo_6" class="level5" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_6_a" class="level5" treenode_a="" onclick="" target="_blank" style="" title="收件箱4"><span style="display: inline-block;width:25px"></span><span id="treeDemo_6_switch" title="" class="button level5 switch noline_docu" treenode_switch=""></span><span id="treeDemo_6_ico" title="" treenode_ico="" class="button ico_docu" style="width:0px;height:0px;"></span><span id="treeDemo_6_span" class="node_name">收件箱4</span></a></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li id="treeDemo_7" class="level1" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_7_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="垃圾邮件"><span id="treeDemo_7_switch" title="" class="button level1 switch noline_docu" treenode_switch=""></span><span id="treeDemo_7_ico" title="" treenode_ico="" class="button ico_docu" style="width:0px;height:0px;"></span><span id="treeDemo_7_span" class="node_name">垃圾邮件</span></a></li>
                            <li id="treeDemo_8" class="level1" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_8_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="草稿"><span id="treeDemo_8_switch" title="" class="button level1 switch noline_docu" treenode_switch=""></span><span id="treeDemo_8_ico" title="" treenode_ico="" class="button ico_docu" style="width:0px;height:0px;"></span><span id="treeDemo_8_span" class="node_name">草稿</span></a></li>
                            <li id="treeDemo_9" class="level1" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_9_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="已发送邮件"><span id="treeDemo_9_switch" title="" class="button level1 switch noline_docu" treenode_switch=""></span><span id="treeDemo_9_ico" title="" treenode_ico="" class="button ico_docu" style="width:0px;height:0px;"></span><span id="treeDemo_9_span" class="node_name">已发送邮件</span></a></li>
                            <li id="treeDemo_10" class="level1" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_10_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="已删除邮件"><span id="treeDemo_10_switch" title="" class="button level1 switch noline_docu" treenode_switch=""></span><span id="treeDemo_10_ico" title="" treenode_ico="" class="button ico_docu" style="width:0px;height:0px;"></span><span id="treeDemo_10_span" class="node_name">已删除邮件</span></a></li>
                        </ul>
                    </li>
                    <li id="treeDemo_11" class="level0" tabindex="0" hidefocus="true" treenode=""><a id="treeDemo_11_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="快速视图"><span id="treeDemo_11_switch" title="" class="button level0 switch noline_close" treenode_switch=""></span><span id="treeDemo_11_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="treeDemo_11_span" class="node_name">快速视图</span></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
