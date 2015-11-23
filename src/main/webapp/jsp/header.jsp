<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SlowNews</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/header.css" rel="stylesheet" type="text/css"/>
    <script src="../js/signOut.js" type="text/javascript"></script>
    <link rel="icon" href="../img/favicon-spider.ico" type="image/x-icon">
</head>
<body>

<div class="header-cont">
    <div class="header">

        <div class="logo">
            <a href="">SlowNews</a>
        </div>

        <%-- <% request.setAttribute("user", request.getSession().getAttribute("user")); %> --%>

        <c:if test="${user != null}">

            <div class="user">
                <form id="form" method="post" action="signOut" onsubmit="return signOut()">
                    <input id="submit" type="submit" value=${user}>
                </form>
            </div>

            <div class="menu">
                <a href="archive">Archive</a>
            </div>
            <div class="menu">
                <a href="news">News</a>
            </div>

        </c:if>

        <c:if test="${user == null}">

            <div class="menu">
                <a href="signUp">Sign Up</a>
            </div>
            <div class="menu">
                <a href="signIn">Sign In</a>
            </div>

        </c:if>

    </div>
</div>

</body>
</html>
