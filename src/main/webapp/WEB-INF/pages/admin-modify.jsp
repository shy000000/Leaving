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
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">级别<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Id或姓名检索">
        </div>
        <button type="submit" class="btn btn-default" style="color: #0081C2;">Search</button>
      </form>
      <button type="button" class="btn btn-default" style="margin-top: 8px;color: #EC971F;">AddNew</button>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</body>
</html>
