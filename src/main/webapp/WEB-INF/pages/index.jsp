<%--
  Created by IntelliJ IDEA.
  User: Jose
  Date: 3/7/2017
  Time: 7:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome </title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="${pageContext.request.contextPath}"><b>Udemy</b></a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <h1>Java Spring MVC(JavaConfig)</h1>
    <p>The sample application provided by Spring MVC JavaConfig udemy course</p>
    <p>Welcome to Java Spring MVC with Java Configuration</p>

    <a href="${pageContext.request.contextPath}/displayUsers">Display Users with Embedded Database</a>
    <br />
    <a href="${pageContext.request.contextPath}/displayPostgresqlUsers">Display Users with Postgresql Database</a>
    <br />
    <a href="${pageContext.request.contextPath}/newblogpost.html">New Blog Post</a>

</div> <!-- /container -->

<footer class="footer">
    <div class="container">
        <p class="text-muted"><b>Tuna Tore 2016 Please feel free to ask me questions by sending email to tunatore@gmail.com</b></p>
        <a href="<%=request.getContextPath()%>?language=en">EN</a>
        <a href="<%=request.getContextPath()%>?language=de">DE</a>
    </div>
</footer>

</body>
</html>
