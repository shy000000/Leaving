<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/3
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>员工历史记录详情</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body  style="background-color: #eeeeee;">
<div class="container">
  <h2 style="font-weight:bold; color:#666666">Details</h2>
  </br>
  <table class="table">
    <thead>
    <tr>
      <th>属 性</th>
      <th>值</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>
        员工Id
      </td>
      <td id="employ_Id">

      </td>
    </tr>
    <tr>
      <td>
        员工姓名
      </td>
      <td id="name">

      </td>
    </tr>
    <tr>
      <td>
        起始日期
      </td>
      <td id="startDate">

      </td>
    </tr>
    <tr>
      <td>
        请假天数
      </td>
      <td id="offDay">

      </td>
    </tr>
    <tr>
      <td>
        请假类型
      </td>
      <td id="type">

      </td>
    </tr>
    <tr>
      <td>
        请假原因
      </td>
      <td id="reason">

      </td>
    </tr>
    <tr>
      <td>
        审批人
      </td>
      <td id="approver">

      </td>
    </tr>
    <tr>
      <td>
        审批状态
      </td>
      <td id="state">

      </td>
    </tr>
    </tbody>
  </table>
</div>
</div>
<div class="row">

  <div class="col-xs-5"style="float:right"><button type="button" class="btn btn-danger" style=" width: 100%">删除本次申请</button></div>
</div>


</div>
</body>
</html>

>

