<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <link href="/css/news.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">

    <c:forEach var="article" items="${articles}">
    <div class="news_block">
        <h1>${article.title}</h1>

     <c:choose>
            <c:when test="${article.media == null}">
                <img src="/img/news/BBC_news_tech_300x300.jpeg">
            </c:when>
            <c:otherwise>
                <img src=${article.media}>
            </c:otherwise>
        </c:choose>

        <p class="news_description">${article.description}</p>

        <p><a href=${article.link}>read</a></p>

        <form id="form" method="post" action="archive">
            <input id="submit" type="submit" value="Archive">
        </form>

    </div>
    </c:forEach>

</body>
</html>
