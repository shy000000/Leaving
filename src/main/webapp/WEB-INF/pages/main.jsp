
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
    <div id="main" style="width: 400px;height:400px;margin-left: -18px;"></div>
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
          <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="false">


            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
              <div class="item active">
                <div>
                  <label for="startDate"><h5 style="color: #666666">开始日期：</h5></label><input id="startDate" type="date" style="width: 150px" value="2014-01-13"/>
                  </br>
                  <label for="offDay"><h5 style="color: #666666">持续时间：</h5></label><input id="offDay" type="text" style="width: 150px" placeholder=" 3 / 天"/>
                  </br>
                  <label for="type"><h5 style="color: #666666">请假类型：</h5></label>
                  <select id="type" style="font-family: '微软雅黑';" class="selectpicker" data-style="btn-info">
                    <option>&nbsp;病 假&nbsp;</option>
                    <option>&nbsp;产 假&nbsp;</option>
                    <option>&nbsp;事 假&nbsp;</option>
                  </select>
                  </br>
                  <label for="reason"><h5 style="color: #666666">请假原因：</h5></label><textarea id="reason" style="vertical-align: top;" rows="3" cols="21" placeholder="请填写具体的请假缘由"></textarea>
                  </br>
                  <button type="button" class="btn btn-success" style="margin-top: 15px;margin-left: 10px;">确认请假</button>
                  <button type="button" class="btn btn-warning" style="margin-left: 30px;margin-top: 15px;" >重新填写</button>
                  <img src="../images/rightToHistory.png" style="margin-left: 260px;margin-top: -150px;" width="70" height="70"/>
                </div>
              </div>
              <div class="item">


              </div>

            </div>

            <!-- Controls -->

            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">

            </a>
          </div>
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

        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="headingThree">
        <h4 class="panel-title"><span><img src="../images/setting.png" width="25" height="25" /></span>
          <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThrees">
            <h4 style="margin-top: -20px;margin-left: 45px;font-family: '黑体';color: #555555;">设置</h4>
          </a>
        </h4>
      </div>
      <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
        <div class="panel-body">
          <img style="margin-left: 30px;" src="../images/update.png" width="20" height="20"/><a><h5 style="margin-left: 65px;margin-top:-18px; font-family: 黑体;font-size: 110%;color: #204D74;">更新个人信息</h5></a>
          <img style="margin-left: 30px;" src="../images/look.png" width="20" height="20"/><a><h5 style="margin-left: 65px;margin-top:-18px; font-family: 黑体;font-size: 110%;color: #204D74;">查看公司请假条例</h5></a>
          <img style="margin-left: 24px;" src="../images/shutDown.png" width="30" height="20"/><a><h5 style="margin-left: 65px;margin-top:-18px; font-family: 黑体;font-size: 110%;color: #204D74;">注销用户登录</h5></a>
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>
