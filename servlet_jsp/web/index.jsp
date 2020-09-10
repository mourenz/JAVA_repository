<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/9 0009
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<html>
<head>
    <script src="${APP_PATH}/static/lib/jquery-1.10.2.min.js"></script>
    <meta charset="utf-8">
    <title>测试</title>
</head>
<body>
当前项目的根路径为-->
${pageContext.request.contextPath}<br>
APP_PATH---><span style="color:chartreuse">${APP_PATH}</span>;<br>


<div style="border: 1px solid red">
    <h2>验证码</h2>
    <img id="yzm" src="${APP_PATH}/yzm" width="auto">
</div>

<div style="font-size: 24px">
    <h2>多个参数提交</h2>
    <form action="${APP_PATH}/demo01" method="post">
        <input type="hidden" name="flag" value="manyParamter">
        <input type="checkbox" name="type" value="A"> A类
        <input type="checkbox" name="type" value="B"> B类
        <input type="checkbox" name="type" value="C"> C类
        <input type="checkbox" name="type" value="D"> D类
        <input type="submit" id="manyValue" value="多个参数">
    </form>
</div>
<input type="submit" id="sub" value="触发json">
<script type="text/javascript">
    // 静态资源文件 不能放到 WEB-INF里面，直接访问 tomcat 是不允许访问的 只有tomcat自己调用WEB-INF下的页面

    $(function () {
        // alert("入口函数")
        //验证码点击刷新
        $("#yzm").click(function () {
            this.src = "${APP_PATH}/yzm?date"+new Date();
        })

        //多个参数
        $("#manyValue").click(function () {
            $('input[type=checkbox]:checked')
            $.ajax({
                type:"POST",
                url:"${APP_PATH}/demo1",
                //data:{flag:"flag",type:}
            })
        })


        // json
        $("#sub").click(function () {
            // alert("我被触发了么");
            $.ajax({
                type: "GET",
                url: "${APP_PATH}/user",
                // contentType: 'application/x-www-form-urlencoded;charset=utf-8',
                data: {username:"zqg"},
                dataType: "json", // 处理服务器返回的数据 解析为json格式 这里不设置的话 ，在服务器端设置响应的数据格式
                //即为 response.setContentType("application/json charset=utf-8">
                success: function(data){ //data = {"键值":值}
                    alert(data.msg);
                    console.log(data.code);
                },
                error:function(e){
                    console.log(e);
                }
            });
        })
    })

  /*$(function () {
      $("#sub").click(function () {
          alert("触发了么");
          $.get("${APP_PATH}/user",{username:"zqg"},function (result) {
              alert(result.code);
          },"json")  // dataType="json"  即为处理服务器返回的数据 转换为 json数据
      })
  })*/
</script>


<script>
    function getMethod() {
        document.getElementById("sub").click = function () {
            alert("触发了么");
            $.get("${APP_PATH}/user",{username:"zqg"},function (result) {
                alert(result.code);
            },"json")  // d
        }
    }
</script>
</body>
</html>
