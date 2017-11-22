<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">

                <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="../../pages/img/profile_small.jpg" />
                             </span>
                    <a data-toggle="dropdown" class="dropdown-toggle">
                        <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">当前用户</strong>
                        </span> <span class="text-muted text-xs block">${userName}<b class="caret"></b></span> </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="/User/userInfo">个人资料</a></li>
                        <li class="divider"></li>
                        <li><a href="/Login/logout">安全退出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    H+
                </div>
            </li>
            <li>
                <a href="#"><i class="fa fa-columns"></i> <span class="nav-label">项目管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="#">我的任务</a>
                    </li>
                    <li><a href="#">新建任务</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:void(0)"><i class="fa fa-envelope"></i> <span class="nav-label">信箱 </span><span class="label label-warning pull-right">16</span></a>
                <ul class="nav nav-second-level">
                    <li><a href="mailbox.html">收件箱</a>
                    </li>
                    <li><a href="mail_detail.html">查看邮件</a>
                    </li>
                    <li><a href="mail_compose.html">写信</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="index.html#"><i class="fa fa-files-o"></i> <span class="nav-label">其他页面</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="search_results.html">搜索结果</a>
                    </li>
                    <li><a href="lockscreen.html">登录超时</a>
                    </li>
                    <li><a href="404.html">404页面</a>
                    </li>
                    <li><a href="500.html">500页面</a>
                    </li>
                    <li><a href="empty_page.html">空白页</a>
                    </li>
                </ul>
            </li>
        </ul>

    </div>
</nav>
</body>
</html>