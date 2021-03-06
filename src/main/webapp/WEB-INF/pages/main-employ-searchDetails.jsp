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
  <title>员工历史记录详情（员工）</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>

<body>
<div style="background-color:#999999; padding-top:2px; padding-bottom: 17px">
  <h1 style="padding-top:80px; padding-left:25px; font-weight:bold; color:#444444">Details</h1>
  <img src="../images/magnifier.png" width="70" style="margin-left: 270px;margin-top:-120px;"/>
</div>


<table bordercolor="#000000" class="table table-bordered table-striped table-hover" style=" border-width:1px; border-color: #999999;font-family: 黑体;font-size:medium;">
  <thead>
  <tr>
    <th>属 性</th>
    <th>值</th>
  </tr>
  </thead>
  <tbody>

  <tr>
    <td>
      起始日期
    </td>
    <td id="startDate">
      ${leaveEntity.startDate}
    </td>
  </tr>
  <tr>
    <td>
      请假天数
    </td>
    <td id="offDay">
      ${leaveEntity.offDay}
    </td>
  </tr>
  <tr>
    <td>
      请假类型
    </td>
    <td id="type">
      ${leaveEntity.type}
    </td>
  </tr>
  <tr>
    <td>
      请假原因
    </td>
    <td id="reason">
      ${leaveEntity.reason}
    </td>
  </tr>
  <tr>
    <td>
      审批人
    </td>
    <td id="approver">
      ${leaveEntity.approver}
    </td>
  </tr>
  <tr>
    <td>
      审批状态
    </td>
    <td id="state">
      ${leaveEntity.state}
    </td>
  </tr>
  </tbody>
</table>
</div>
</div>
<div class="row">

  <div class="col-xs-5"style="float:right"><button type="button" class="btn btn-danger" onclick="javascript:window.location.href='/employee/waitExaminedelete?id=${leaveEntity.id}'" style=" width: 100%;font-family: 黑体;">删除本次申请</button></div>
</div>

</body>
</html>



