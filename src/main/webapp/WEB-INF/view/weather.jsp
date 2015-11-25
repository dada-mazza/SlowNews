<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="/css/weather.css" rel="stylesheet" type="text/css"/>
    <link href="/css/forms.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content">

    <form id="formWeather" method="post" action="weather">
        <div id="inputsWeather">
            <input id="enterCity" name="enterCity" type="text" placeholder="Enter City" autofocus>
        </div>
        <div id="actionsWeather">
            <input id="submit" type="submit" value="Search Weather">
        </div>
    </form>


    <c:choose>
        <c:when test="${message == null}">
        </c:when>
        <c:otherwise>
            <div class="error">
                    ${message}
            </div>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${weatherCode}">

            <div class="weather">
                <h1>Weather in your city</h1>

                <h2>${city}, ${country}</h2>

                <table align="center">
                    <tr>
                        <td valign="left"><img src=${image}></td>
                        <td valign="center">${temperature}</td>
                    </tr>
                </table>

                <h3>${weatherMain}</h3>

                <div> get ${getWeather}</div>
                <br>
                <table id="tableWeather" align="center">
                    <tr></tr>
                    <tr>
                        <td>Wind</td>
                        <td>${wind}</td>
                    </tr>

                    <tr>
                        <td>Cloudiness</td>
                        <td>${cloudiness}</td>
                    </tr>

                    <tr>
                        <td>Pressure<br></td>
                        <td>${pressure}</td>
                    </tr>

                    <tr>
                        <td>Humidity</td>
                        <td>${humidity}</td>
                    </tr>

                    <tr>
                        <td>Sunrise</td>
                        <td> ${sunrise}</td>
                    </tr>
                    <tr>
                        <td>Sunset</td>
                        <td>${sunset}</td>
                    </tr>
                    <tr>
                        <td>Geo coords</td>
                        <td>${coord}</td>
                    </tr>

                </table>

            </div>

        </c:when>

        <c:otherwise>
            <div class="error">
                    ${errorCity}
            </div>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
