<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <link href="../css/news.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">

    <c:forEach var="article" items="${articles}">
    <div class="news_block">
        <h1>${article.title}</h1>
        <img src=${article.image}>

        <p class="p-first">${article.firstParagraph}</p>

        <p>${article.body}</p>
        <br/>

        <a href="">...</a>

        <form id="form" method="post" action="archive">
            <input id="submit" type="submit" value="Archive">
        </form>

    </div>
    </c:forEach>

</body>
</html>
