<%--
  Created by IntelliJ IDEA.
  User: Ev_Eraser
  Date: 2016/9/2
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <title>主界面</title>
  <script src="../js/echarts.min.js"></script>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="background-color:#444444">
  <center>
    <div id="main" style="width: 400px;height:400px;"></div>
    <script type="text/javascript">
      var myChart = echarts.init(document.getElementById('main'));
      var option = {
        tooltip : {

        },
        series: [
          {
            name: '已请假',
            tooltip:{
              
            },
            type: 'gauge',
            detail: {formatter:"{value}%"},
            data: [{value: 40
            }
            ]
          }
        ]
      };


      myChart.setOption(option);
    </script>
    <p style=" margin-top:-120px; font-size:24px; color:#cccccc; font-family:'黑体'">已请假</p>
    </br>
    </br>
  </center>
</div>
</br>
</br>
<div class="container">
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingOne">
        <h4 class="panel-title" ><span><img src="../images/leaving.png" width="25" height="25" /></span>
          <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
            <h4 style="margin-top: -20px;margin-left: 45px;font-family: '黑体';color: #555555;">请假</h4>
          </a>
        </h4>

      </div>
      <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
        <div class="panel-body">
          1
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingTwo">
        <h4 class="panel-title"><span><img src="../images/agreeLeaving.png" width="25" height="25" /></span>
          <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
            <h4 style="margin-top: -20px;margin-left: 45px;font-family: '黑体';color: #555555;">批假</h4>
          </a>
        </h4>
      </div>
      <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
        <div class="panel-body">
          2
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>
