<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>基础信息管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/basicinfo" name="basicInfo" ><i class="fa fa-circle-o"></i>用户个人数据</a></li>
                    <li><a href="/user/eduinfo" name="eduInfo" ><i class="fa fa-circle-o"></i>教育经历</a></li>
                </ul>
            </li>

            <!-- 科学研究 -->
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>科学研究</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/research/paper"><i class="fa fa-circle-o"></i>论文成果</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>专利</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>研究项目</a></li>
                </ul>
            </li>

            <!-- 教育研究 -->
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>教育研究</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i>获奖信息</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>学生信息</a></li>
                </ul>
            </li>

            <!-- 模板选择 -->
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>模板管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i>模板预览</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>我的模板</a></li>
                    <li><a href="/research/form"><i class="fa fa-circle-o"></i>我的模板</a></li>
                </ul>
            </li>

        </ul>
    </section>
</aside>