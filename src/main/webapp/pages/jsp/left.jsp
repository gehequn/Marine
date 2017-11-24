<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();%>
<html>
<head>
    <base href="<%=basePath%>">
</head>
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
            <c:forEach items="${menuList}" var="menu" varStatus="vs">
            <li>
                <a href="${menu.menuUrl}"><i class="fa fa-columns"></i> <span class="nav-label">${menu.menuName}</span><span class="fa arrow"></span></a>
                <c:if test="${not empty menu.childMenu}">
                    <c:forEach items="${menu.childMenu}" var="childMenu">
                        <ul class="nav nav-second-level">
                            <li><a href="${childMenu.menuUrl}">${childMenu.menuName}</a>
                            </li>
                        </ul>
                    </c:forEach>
                </c:if>
            </li>
            </c:forEach>
        </ul>
    </div>
</nav>
</body>
</html>