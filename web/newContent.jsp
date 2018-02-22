<%--
  Created by IntelliJ IDEA.
  User: GaolengYan
  Date: 2018/1/13
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/header.css" rel="stylesheet">
    <link rel="stylesheet" href="css/navi.css">
    <link href="css/news.css" rel="stylesheet">
</head>
<body>
<%@include file="header.html" %>
<div id="container">
    <%@include file="navi.html" %>
    <div id="news">
        <h2>${newsContent.title}</h2>
        <div id="author">${newsContent.author} ▪ ${newsContent.date}</div>
        <div id="main">
            ${newsContent.content}
        </div>
    </div>
</div>
</body>
</html>
