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
  <title>个人信息</title>
  <script src="echarts.min.js"></script>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="background-color: #eeeeee;">
  <center><h2 style="font-weight:bold; color:#666666">——— 个人信息 ———</h2></center>
  </br>
  <form class="form-horizontal" role="form" action="">
    <div class="form-group">
      <label for="employ_Id" class="col-sm-2 control-label">用户名</label>
      <div class="col-sm-10">
        <input type="ID" class="form-control" id="employ_Id" placeholder="Employ_Id">
      </div>
    </div>

    <div class="form-group">
      <label for="name" class="col-sm-2 control-label">员工姓名</label>
      <div class="col-sm-10">
        <input type="name" class="form-control" id="name" placeholder="Name">
      </div>
    </div>

    <div class="form-group">
      <label for="phone" class="col-sm-2 control-label">员工电话</label>
      <div class="col-sm-10">
        <input type="phonenumber" class="form-control" id="phone" placeholder="Phonenumber">
      </div>
    </div>

    <div class="form-group">
      <label class="col-sm-2 control-label">所属部门</label>
      <div class="col-sm-10">
        <select class="form-control">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </select>
      </div>
    </div>

    <div class="form-group">
      <label class="col-sm-2 control-label">级别</label>
      <div class="col-sm-10">
        <select class="form-control">
          <option>1</option>
          <option>2</option>
          <option>3</option>
        </select>
      </div>
    </div>

    <div class="form-group">
      <label for="limit" class="col-sm-2 control-label">请假额度</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="limit" placeholder="Limit">
      </div>
    </div>

    <div class="form-group">
      <label for="password" class="col-sm-2 control-label">登陆密码</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="password" placeholder="Password">
      </div>
    </div>

    <div class="container">
      <div class="form-group">
        <div class="row">
          <div class="col-xs-6"><button type="submit" class="btn btn-info" style=" width: 100%">更新</button></div>
          <div class="col-xs-6"><button type="button" class="btn btn-warning" style=" width: 100%">取消</button></div>
        </div>
      </div>
    </div>
  </form>


</div>
</body>
</html>
