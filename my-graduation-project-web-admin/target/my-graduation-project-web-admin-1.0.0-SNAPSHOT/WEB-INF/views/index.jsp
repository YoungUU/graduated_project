
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>个人定制与共享平台</title>
    <jsp:include page="../includes/header.jsp"/>
    <style type="text/css">
        html,body{
            width: 100%;
            height: 100%;
        }
        .mui-content{
            background: url(static/assets/img/29178863.jpg) bottom center no-repeat #efeff4 ;
            background-size: 100% 100%;
            width: 100%;
            height: 48%;
        }
    </style>
    <style>
        .div1{
            position:absolute;
            right:20px;
            top:3%;
            height:20px;
            width:40px;
        }
    </style>
</head>
<body class="mui-content">
<!-- <strong><a target="view_window" style=" font-size:20px;" href="/login" class="div1">登录</a></strong> -->

<a target="view_window" style=" font-size:20px;" href="/login" class="div1">
    <button button type="button" class="btn btn-primary">登录</button>
</a>

<form action="/visitor/search" method="get">
    <div class="input-group input-group-sm" style="width: 350px; margin: auto ; margin-top: 24%">
        <input type="text" name="keyword" class="form-control pull-right" placeholder="搜索">

        <div class="input-group-btn">
            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
        </div>
    </div>
</form>


</body>
</html>
