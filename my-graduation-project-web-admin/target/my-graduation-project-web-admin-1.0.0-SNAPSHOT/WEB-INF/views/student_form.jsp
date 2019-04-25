<%--
  Created by IntelliJ IDEA.
  User: UUpc
  Date: 2019/3/13
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>我的信息 | 教育研究</title>
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
                学生管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 个人信息</a></li>
                <li class="active">教育研究</li>
                <li class="active">学生</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${reward.id == null?"新增":"编辑"}学生</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/education/${student.id == null?"save":"edit"}Student?id=${student.id}" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">学生姓名</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="stuName" value="${student.stuName}" placeholder="${student.id == null?"请输入学生姓名":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">学生学号</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="stuNum" value="${student.stuNum}" placeholder="${student.id == null?"请输入学生学号":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">学生年级</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="stuGrade" value="${student.stuGrade}" placeholder="${student.id == null?"请输入学生年级":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">学生排名</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="stuNumber" value="${student.stuNumber}" placeholder="${student.id == null?"请输入学生排名":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">学生电话</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="stuPhone" value="${student.stuPhone}" placeholder="${student.id == null?"请输入学生电话":""}">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                </div>
            </div>
        </section>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>

</body>

</html>
