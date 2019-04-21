

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
                科学研究
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 个人信息</a></li>
                <li class="active">科学研究</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">论文管理</h3>

                            <div class="row" style="padding-left: 12px; padding-top: 10px">
                                <a href="/research/form" type="button" class="btn  btn-sm btn-default"><i class="fa fa-plus-square"></i>新增</a>&nbsp;
                                <a href="#" type="button" class="btn  btn-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp;
                                <a href="#" type="button" class="btn  btn-sm btn-default"><i class="fa fa-download"></i>导入</a>&nbsp;
                                <a href="#" type="button" class="btn  btn-sm btn-default"><i class="fa fa-upload"></i>导出</a>&nbsp;
                            </div>

                            <div class="box-tools">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control pull-right" placeholder="搜索">

                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>论文名称</th>
                                    <th>论文编号</th>
                                    <th>发布时间</th>
                                    <th>发布人</th>
                                    <th>论文状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${papers}" var="paper">
                                    <tr>
                                        <td><a href="${paper.url}" target="view_window">${paper.paperName}</a></td>
                                        <td>${paper.number1}</td>
                                        <td>${paper.releaseTime}</td>
                                        <td>${paper.author}</td>
                                        <td>${paper.status}</td>
                                        <td>
                                            <a href="#" type="button" class="btn  btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;
                                            <a href="#" type="button" class="btn  btn-sm btn-info"><i class="fa fa-arrow-up"></i>置顶</a>&nbsp;
                                            <a href="/research/delete?id=${paper.id}" type="button" class="btn  btn-sm btn-danger"><i class="fa  fa-trash-o"></i>删除</a>&nbsp;
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>

</body>

</html>
