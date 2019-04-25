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
    <title>我的信息 | 科学研究</title>
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
                论文管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 个人信息</a></li>
                <li class="active">科学研究</li>
                <li class="active">论文成果</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${paper.id == null?"新增":"编辑"}论文</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/research/${paper.id == null?"save":"edit"}Paper?id=${paper.id}" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">论文名称</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="paperName" value="${paper.paperName}" placeholder="${paper.id == null?"请输入论文名称":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">论文编号</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="number1" value="${paper.number1}" placeholder="${paper.id == null?"请输入论文编号":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">论文地址</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="url" value="${paper.url}" placeholder="${paper.id == null?"请输入论文地址":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">发布时间</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="releaseTime" value="${paper.releaseTime}" placeholder="${paper.id == null?"请输入发布时间:格式2088*-08-88(说明)":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">发布人</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="author" value="${paper.author}" placeholder="${paper.id == null?"请输入发布人" : ""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">论文状态</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="status" value="${paper.status}" placeholder="${paper.id == null?"请输入论文状态" : ""}">
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
