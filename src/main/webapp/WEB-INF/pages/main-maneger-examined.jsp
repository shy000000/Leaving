<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/4
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>已审核页面(经理)</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>

<body>
<div style="background-color:#999999; padding-top:2px; padding-bottom: 17px">
  <h2 style="padding-top:60px; padding-left:25px; font-weight:bold; color: #444444">Examing</h2>
  <img src="../images/waitExamine.png" width="65" style="margin-left: 290px;margin-top:-110px;"/>
  <div style="background-color:#FFFFFF; width:125px; height:6px; margin-left:25px; background-color:#444444"></div>
  <div style="background-color:#FFFFFF; width:160px; height:6px; margin-left:25px; margin-top:10px;background-color:#444444"></div>
</div>

<table bordercolor="#000000" class="table table-bordered table-striped table-hover" style=" border-width:2px; border-color: #999999">
  <tr align="center">
    <td style="font-family:黑体; font-size:16px">姓名</td>
    <td style="font-family:黑体; font-size:16px">请假日期</td>
    <td style="font-family:黑体; font-size:16px">详情</td>
    <td style="font-family:黑体; font-size:16px" colspan="1">操作</td>
  </tr>

  <c:forEach items="${leaveEntities}" var="wanted">
    <tr>
      <td>${wanted.name}</td>
      <td>${wanted.startDate}</td>
      <td>
        <a href="/maneger/examinedlookDetails?id=${wanted.id}" type="button" class="btn btn-sm btn-default">详情</a>
        <%--<a href="javascript:if(confirm('确认注销吗，将会停止对该用户的服务?'))window.location='/back/outUserGet?userid=${wanted.id}&pageNow=${page.pageNow}'" type="button" class="btn btn-sm btn-default">注销</a>--%>
      </td>
      <td>
        <a href="/maneger/examineddestory?id=${wanted.id}" type="button" class="btn btn-sm btn-default">销假</a>
        <%--<a href="javascript:if(confirm('确认注销吗，将会停止对该用户的服务?'))window.location='/back/outUserGet?userid=${wanted.id}&pageNow=${page.pageNow}'" type="button" class="btn btn-sm btn-default">注销</a>--%>
      </td>

    </tr>
  </c:forEach>
</table>

</body>
</html>

