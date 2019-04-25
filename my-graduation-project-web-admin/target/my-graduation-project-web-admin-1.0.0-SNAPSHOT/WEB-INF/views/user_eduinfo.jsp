

<%--
  Created by IntelliJ IDEA.
  User: UUpc
  Date: 2019/3/26
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>我的信息 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                控制面板
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">个人教育信息</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form role="form" action="/user/updateInfo" method="post">
                    <div class="box-body">
                        <div class="form-group">
                            <label>毕业院校</label>
                            <input class="form-control" name="username" value="${ userInfo.graduatedSchool}">
                        </div>

                        <div class="form-group">
                            <label>学历</label>
                            <input class="form-control" name="namePinyin" value="${userInfo.education}">
                        </div>

                        <div class="form-group">
                            <label>学位</label>
                            <input class="form-control" name="englishName" value="${userInfo.academicDegree}">
                        </div>

                        <div class="form-group">
                            <label>在职信息</label>
                            <input type="text" class="form-control" name="exampleInputEmail1" value="${userInfo.incumbencyInformation}">
                        </div>

                        <div class="form-group">
                            <label>所在单位</label>
                            <input  class="form-control"  value="${userInfo.company}">
                        </div>

                        <div class="form-group">
                            <label>主要职位</label>
                            <input class="form-control" name="mainPosts" value="${userInfo.mainPosts}">
                        </div>

                        <div class="form-group">
                            <label>其他任职</label>
                            <input class="form-control" name ="otherPosts" value="${userInfo.otherPosts}">
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>

                </form>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>

</body>

</html>
