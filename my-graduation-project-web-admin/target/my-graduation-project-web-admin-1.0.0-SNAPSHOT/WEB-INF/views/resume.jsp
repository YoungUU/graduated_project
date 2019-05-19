<%--
  Created by IntelliJ IDEA.
  User: UUpc
  Date: 2019/5/18
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>个人定制与共享平台</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="/static/assets/css/others/style.css">
    <style type="text/css">
        .resume{
            width: 50%;
            height: 50%;
        }
    </style>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
            <div class="container">
                <section class="info-container">
                    <h3>个人信息</h3>
                    <div class="info-content">
                        <div class="left-content">
                            <img style="white-space: nowrap" src="/static/assets/img/user2-160x160.jpg">
                        </div>
                        <div class="right-content">
                            <p class="name"><span>姓名:</span>${userInfo.username}</p>
                            <p class="english"><span>英文名:</span>${userInfo.englishName}</p>
                            <p class="sex"><span>性别:</span>${userInfo.gender == 1?"男":"女"}</p>
                            <p class="phone"><span>电话:</span>${userInfo.phone}</p>
                            <p class="email"><span>邮箱:</span>${userInfo.email}</p>
                            <p class="position"><span>职位:</span>${userInfo.mainPosts}</p>
                        </div>
                    </div>
                </section>


                <h3>教育经历</h3>
                <section class="education-container">
                        <ul>
                            <li class="edu-item">
                                <span class="time">2012年9月</span>
                                <span class="academy">墨尔本大学</span>
                                <span class="major">研究生</span>
                            </li>
                        </ul>
                </section>


                <h3>论文成果</h3>
                <c:forEach items="${papers}" var="paper">
                <section class="paper-container">
                    <ul>
                        <li class="paper-name">
                            <span class="time">${paper.releaseTime}</span>
                            <span class="name">${paper.paperName}</span>
                        </li>
                    </ul>
                </section>
                </c:forEach>

                <h3>专利成果</h3>
              <c:forEach items="${patents}" var="patent">
                <section class="patent-container">
                    <ul>
                        <li class="patent-item">
                            <span class="time">${patent.patentName}</span>
                            ---<span class="name">${patent.author}</span>
                        </li>
                    </ul>
                </section>
              </c:forEach>

                <h3>研究项目</h3>
              <c:forEach items="${projects}" var="project">
                <section class="searchpr-container">
                    <ul>
                        <li class="patent-item">
                            <span class="name">${project.projectName}</span>
                            项目内容：<span class="content">${project.context}</span>
                        </li>
                    </ul>
                </section>
              </c:forEach>

                <h3>相关获奖</h3>
              <c:forEach items="${rewards}" var="reward">
                <section class="prize-container">
                    <ul>
                        <li class="prize-item">
                            <span class="time">${reward.getime}</span>
                            ---<span class="name">${reward.rewardName}</span>
                            ---<span class="level">${reward.level}</span>
                        </li>
                    </ul>
                </section>
              </c:forEach>
            </div>
        </section>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"/>

</body>

</html>

</body>
</html>
