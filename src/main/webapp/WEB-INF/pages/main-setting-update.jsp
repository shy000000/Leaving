<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/3
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>个人资料修改</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body  style="background-color: #eeeeee;">
<div class="container">
  <center><h2 style="font-weight:bold; color:#666666">个人信息修改</h2></center>
  </br>
  <form:form class="form-horizontal" role="form" action="/employee/updateSure" method="post">


    <div class="form-group">
      <label for="name" class="col-sm-2 control-label">员工姓名</label>
      <div class="col-sm-10">
        <input type="name" class="form-control" id="name" name="name"value="${employeeEntity.name}" placeholder="Name">
      </div>
    </div>
    </br>
    <div class="form-group">
      <label for="phone" class="col-sm-2 control-label">员工电话</label>
      <div class="col-sm-10">
        <input type="phonenumber" class="form-control" id="phone" name="phone" value="${employeeEntity.phone}" placeholder="Phonenumber">
      </div>
    </div>
    </br>
    <div class="form-group">
      <label for="password" class="col-sm-2 control-label">登陆密码</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="password" name="password" value="${employeeEntity.password}" placeholder="Password">
      </div>
    </div>
    </br>
    <div class="container">
      <div class="form-group">
        <div class="row">
          <div class="col-xs-6"><button type="submit" class="btn btn-info" style=" width: 100%;">更新</button></div>
          <div class="col-xs-6"><button type="button" class="btn btn-warning" onclick="javascript:window.location.href='/employee/reWrite'" style=" width: 100%;">取消</button></div>
        </div>
      </div>
    </div>
  </form:form>


</div>
</body>
</html>






