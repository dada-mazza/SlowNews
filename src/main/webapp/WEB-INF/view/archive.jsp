<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <link href="/css/news.css" rel="stylesheet" type="text/css"/>
    <link href="/css/archive.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">

    <c:forEach var="article" items="${articles}">
        <div class="news_block">
            <div class="ribbon-wrapper-green">
                <div class="ribbon-green">${article.ribbon}</div>
            </div>
            <h1>${article.title}</h1>

            <c:choose>
                <c:when test="${article.image == null}">
                    <img src="/img/news/bbc_news_tech_144x81.jpg">
                </c:when>
                <c:otherwise>
                    <img src=${article.image}>
                </c:otherwise>
            </c:choose>

            <p class="news_description">${article.description}</p>

            <p><a href=${article.link}>read</a></p>
        </div>
    </c:forEach>

</div>
</body>
</html>
