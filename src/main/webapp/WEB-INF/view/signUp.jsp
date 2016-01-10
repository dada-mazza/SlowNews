<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <link href="/css/forms.css" rel="stylesheet" type="text/css"/>
    <script src="/js/signUp.js" type="text/javascript"></script>
</head>
<body>
<div class="content">

    <c:choose>
        <c:when test="${message == null}">
        </c:when>
        <c:otherwise>
            <div class="error">
                    ${message}
            </div>
        </c:otherwise>
    </c:choose>

    <form id="form" action="signUp" method="post" onsubmit="return check()">
        <div id="inputsUp" class="bgIn">
            <input id="login" name="login" type="text" placeholder="login" value="${login}" autofocus>
            <input id="password" name="password" type="password" placeholder="password">
            <input id="passwordConfirm" name="passwordConfirm" type="password" placeholder="confirm password">
            <input id="email" name="email" type="email" placeholder="name@company.com" value="${email}">
        </div>
        <div id="actions">
            <input type="submit" id="submit" value="Sigh Up">
            <a href="signIn">Sigh In</a>
        </div>
    </form>

</div>
</body>
</html>
