<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/4
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>已批准页面（员工）</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>

<body>
<div style="background-color: #66CC33; padding-top:2px; padding-bottom: 17px">
  <h2 style="padding-top:80px; padding-left:25px; font-weight:bold; color: #FFFFFF">Approved</h2>
  <img src="../images/approved.png" width="80" style="margin-left: 280px;margin-top:-110px;"/>
</div>

<table bordercolor="#000000" class="table table-bordered table-striped table-hover" style=" border-width:2px; border-color: #00FF33">
  <tr align="center">
    <td style="font-family:黑体; font-size:16px">开始日期</td>
    <td style="font-family:黑体; font-size:16px">请假类型</td>
    <td style="font-family:黑体; font-size:16px">天数</td>
    <td style="font-family:黑体; font-size:16px">操作</td>
  </tr>

  <c:forEach items="${leaveEntities}" var="wanted">
    <tr>
      <td>${wanted.startDate}</td>
      <td>${wanted.type}</td>
      <td>${wanted.offDay}</td>

      <td>
        <a href="/employee/waitExaminelookDetails?id=${wanted.id}" type="button" class="btn btn-sm btn-default">详情</a>
        <%--<a href="javascript:if(confirm('确认注销吗，将会停止对该用户的服务?'))window.location='/back/outUserGet?userid=${wanted.id}&pageNow=${page.pageNow}'" type="button" class="btn btn-sm btn-default">注销</a>--%>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>

