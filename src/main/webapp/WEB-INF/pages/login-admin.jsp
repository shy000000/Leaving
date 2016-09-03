<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/2
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>Bootstrap Login Form Template</title>

  <!-- CSS -->

  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/form-elements.css">
  <link rel="stylesheet" href="../css/style.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>

  <![endif]-->

  <!-- Favicon and touch icons -->
</head>

<body>

<!-- Top content -->
<div class="top-content">

  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1><strong>某公司请假系统</strong> </h1>
          <div class="description">

          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 form-box">
          <div class="form-top">
            <div class="form-top-left">
              <h3>管理员登陆通道</h3>
              <p>管理员登陆后可以修改员工信息，查询请假日志</p>
            </div>
            <div class="form-top-right">
              <img src="../images/key.png" />
            </div>
          </div>
          <div class="form-bottom">
            <form role="form" action="" method="post" class="login-form">
              <div class="form-group">

                <label for="form-username">AdminId</label>

                <input type="text" name="form-username" placeholder="管理员账号..." class="form-username form-control" id="form-username">

              </div>
              <div class="form-group">
                <label for="form-password">Password</label>
                <input type="password" name="form-password" placeholder="密码..." class="form-password form-control" id="form-password">
              </div>
              <button type="submit" class="btn">Sign in!</button>
            </form>

          </div>
        </div>
        <p style="margin-top: 10px;margin-left: 120px; color: #28A4C9;">点此进入员工登陆通道>></p>
      </div>

    </div>
  </div>

</div>


<!-- Javascript -->
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.backstretch.min.js"></script>
<script src="../js/scripts.js"></script>

<!--[if lt IE 10]>

<![endif]-->

</body>

</html>
