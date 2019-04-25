

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
                    <h3 class="box-title">个人基础信息</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form role="form" action="/user/updateInfo" method="post">
                    <div class="box-body">
                        <%--姓名 姓名拼音 英文名--%>
                        <div class="form-group">
                            <label>姓名</label>
                            <input class="form-control" name="username" value="${ userInfo.username}">
                        </div>

                        <div class="form-group">
                            <label>姓名拼音</label>:请输入您名字的拼音（以便模糊查找）
                            <input class="form-control" name="namePinyin" value="${userInfo.namePinyin}">
                        </div>

                        <div class="form-group">
                            <label>英文名</label>:请输入您的英文名
                            <input class="form-control" name="englishName" value="${userInfo.englishName}">
                        </div>

                        <!-- 男女选择 -->
                        <div class="form-group">
                            <label>
                                <input type="radio" name="gender" class="minimal" value="0">男
                            </label>
                            <label>
                                <input type="radio" name="gender" class="minimal" value="1">女
                            </label>
                        </div>

                            <%--邮箱--%>
                        <div class="form-group">
                            <label>Email address    :    ${userInfo.email}</label>
                        </div>

                            <%--密码--%>
                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" class="form-control"  name="password" placeholder="请输入您的密码">
                        </div>

                        <div class="form-group">
                            <label>确认密码</label>
                            <input type="password" class="form-control" name="rePassword">
                        </div>

                        <div class="form-group">
                            <label>选择您的头像</label>
                            <input type="file" id="exampleInputFile">
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
