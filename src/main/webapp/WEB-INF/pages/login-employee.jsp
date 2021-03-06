<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/2
  Time: 16:39
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


</head>

<body background="../images/loginBackground.jpg">

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
              <h3>员工登陆通道</h3>
              <p>输入您的工号和密码即可进入请假系统</p>
            </div>
            <div class="form-top-right">
              <img src="../images/key.png" />
            </div>
          </div>
          <div class="form-bottom">


            <form:form role="form" action="/employeeLogin" method="post" class="login-form">
              <div class="form-group">

                <label for="form-username">WorkId</label>

                <input type="text" name="form-username" placeholder="员工号..." class="form-username form-control" id="form-username" required="required">

              </div>
              <div class="form-group">
                <label for="form-password">Password</label>
                <input type="password" name="form-password" placeholder="密码..." class="form-password form-control" id="form-password" required="required">
              </div>
              <button type="submit" class="btn">Sign in!</button>
            </form:form>
              <div>
                <c:if test="${result == 1}">
                  <p>
                    <br/>
                    登录失败请检查用户名或密码是否正确
                    <br/>
                    <br/>
                  </p>
                </c:if>
              </div>



          </div>
        </div>
        <p style="margin-top: 10px;margin-left: 120px; color: #28A4C9;"><a href="/login-admin"> 点此进入管理员登陆通道></a></p>
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
