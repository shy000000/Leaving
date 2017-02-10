<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/3
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>管理员筛选用户</title>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/jquery-1.12.3.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<div class="jumbotron">
  <h1 style="margin-left: 70px">Administer Modify</h1>
</div>
<nav class="navbar navbar-default" role="navigation" style="margin-top: -30px;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Category</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">部门 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/admin/admin-modify-sectionId?sectionId=1">1</a></li>
            <li class="divider"></li>
            <li><a href="/admin/admin-modify-sectionId?sectionId=2">2</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">级别<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/admin/admin-modify-level?level=0">0</a></li>
            <li class="divider"></li>
            <li><a href="/admin/admin-modify-level?level=1">1</a></li>
            <li class="divider"></li>
            <li><a href="/admin/admin-modify-level?level=2">2</a></li>
          </ul>
        </li>
      </ul>
      <form:form action="/admin/admin-modify-name" class="navbar-form navbar-left" role="search" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="name" placeholder="姓名检索">
        </div>
        <button type="submit" class="btn btn-default" style="color: #0081C2;">Search</button>
      </form:form>
      <button type="button" class="btn btn-default" onclick="javascript:window.location.href='/admin/admin-modify-addNew'" style="margin-top: 8px;color: #EC971F;">AddNew</button>
    </div><!-- /.navbar-collapse -->

  </div><!-- /.container-fluid -->
  <table class="table tavble-bordered table-striped">
    <tr>
      <th>员工工号</th>
      <th>员工姓名</th>
      <th>员工电话</th>
      <th>员工部门</th>
      <th>员工等级</th>
      <th>员工限额</th>
      <th>已用天数</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${employeeEntities}" var="wanted">
      <tr>
        <td>${wanted.employId}</td>
        <td>${wanted.name}</td>
        <td>${wanted.phone}</td>
        <td>${wanted.sectionId}</td>
        <td>${wanted.level}</td>
        <td>${wanted.quota}</td>
        <td>${wanted.used}</td>
        <td>
          <a href="/admin/admin-modify-update?id=${wanted.id}" type="button" class="btn btn-sm btn-default">修改</a>
          <a href="/admin/deleteEmployeeId?id=${wanted.id}" type="button" class="btn btn-sm btn-default">删除</a>
          <%--<a href="javascript:if(confirm('确认注销吗，将会停止对该用户的服务?'))window.location='/back/outUserGet?userid=${wanted.id}&pageNow=${page.pageNow}'" type="button" class="btn btn-sm btn-default">注销</a>--%>
        </td>
      </tr>
    </c:forEach>
  </table>
</nav>

</body>
</html>
