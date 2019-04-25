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
                项目管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 个人信息</a></li>
                <li class="active">科学研究</li>
                <li class="active">项目</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${project.id == null?"新增":"编辑"}项目</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/research/${project.id == null?"save":"edit"}Project?id=${project.id}" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">项目名称</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="projectName" value="${project.projectName}" placeholder="${project.id == null?"请输入项目名称":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">项目主要负责人</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="mainPerson" value="${project.mainPerson}" placeholder="${project.id == null?"请输入主要负责人":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">项目内容</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="context" value="${project.context}" placeholder="${project.id == null?"请输入项目研究内容":""}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">项目规模</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="scale" value="${project.scale}" placeholder="${project.id == null?"请输入项目规模（人数，财力物力等）":""}">
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
