<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/3
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>管理员操作界面</title>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/jquery-1.12.3.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<div class="jumbotron">
  <h1 style="margin-left: 70px">Administer</h1>
</div>
<div class="col-md-12">
  <div class="lt-gallery">
    <div class="col-md-4" style="margin-left: 165px;">
      <div class="thumbnail">
        <img src="../images/changePerson.png" width="150">
        <div class="caption">
          <h3>修改员工信息</h3>
          <p>系统管理员可以对公司员工的个人基本信息进行修改，修改记录会提示给员工本人</p>
          <button class="btn btn-warning">Go to modify > ><i class="fa fa-arrow-right"></i></button>
        </div>
      </div>
    </div>
    <div class="col-md-4" style="margin-left: 100px;">
      <div class="thumbnail">
        <img src="../images/searchLeaving.png" width="150">
        <div class="caption">
          <h3>查看请假日志</h3>
          <p>系统管理员可以随时查看员工请假的历史记录，以便核对员工薪资标准</p>
          <button class="btn btn-warning">Go to check > ><i class="fa fa-arrow-right"></i></button>
        </div>
      </div>
    </div>

  </div>
</div>
<!--end-->
</div>
</div>


</body>
</html>
