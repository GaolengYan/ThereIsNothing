<%--
  Created by IntelliJ IDEA.
  User: GaolengYan
  Date: 2017/12/19
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <%-- 最上方的登陆祖册header --%>
    <link href="css/header.css" rel="stylesheet">
    <link href="css/navi.css" rel="stylesheet">
    <%-- 新闻展示页面的css --%>
    <link href="css/news.css" rel="stylesheet">
    <title>拿星网</title>
</head>
<body>
<%@include file="header.html" %>
<div id="container">
    <%-- 导航栏 --%>
    <%--<%@include file="navi.html" %>--%>
    <div id="news">
        <ul>
            <c:forEach var="news" items="${News}">
                <li>
                    <div class="imgbox">
                        <a href="/action/NewsContentAction.action?src=${news.newsContext}&newsTitle=${news.newsTitle}">
                            <img src="${news.newsCoverImg}"
                                 alt="${news.newsTitle}">
                        </a>
                    </div>
                    <p class="textbox">
                        <a href="/action/NewsContentAction.action?src=${news.newsContext}&newsTitle=${news.newsTitle}">${news.newsTitle}</a>
                    </p>
                    <p class="sourcebox">
                        <span class="tag">178</span>
                            ${news.newsAuthor}
                        <span class="time">${news.newsUpdateTime}</span>
                    </p>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
