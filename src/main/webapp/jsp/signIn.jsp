<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <link href="../css/forms.css" rel="stylesheet" type="text/css"/>
    <script src="../js/signIn.js" type="text/javascript"></script>
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

    <form id="form" method="post" action="signIn" onsubmit="return check('login', 'passwordIn')">
        <div id="inputsIn">
            <input id="login" name="username" type="text" placeholder="login" autofocus <%--required--%>>
            <input id="passwordIn" name="password" type="password" placeholder="password" <%--required--%>>
        </div>
        <div id="actions">
            <input id="submit" type="submit" value="Sign In">
            <a href="signUp">Sigh Up</a>
            <a href="">Forgot Password?</a>
        </div>
    </form>
</div>
</body>
</html>
