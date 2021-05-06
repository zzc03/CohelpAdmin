<%--
  Created by IntelliJ IDEA.
  User: 22857
  Date: 2021/4/25
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录-同学帮管理系统</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<div class="layadmin-user-login layadmin-user-display-show">
    <!--登录主体-->
    <div class="layadmin-user-login-main">
        <!--标题-->
        <div class="header">
            <h1>同学帮</h1>
            <h2>登录管理同学帮</h2>
        </div>
        <div class="logintable">
            <form method="post" id="loginform"  name="loginformname" >
               <div class="label">
                   <div class="layui-form-item">
                       <label class="layui-form-label" >账号</label>
                       <div class="layui-input-inline">
                           <input type="text" id="account" name="account" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                       </div>
                   </div>
                   <div class="layui-form-item ">
                       <label class="layui-form-label">密码</label>
                       <div class="layui-input-inline">
                           <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                       </div>
                   </div>
               </div>


<%--                    <div class="layui-form-mid layui-word-aux">辅助文字</div>--%>

<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">选择框</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <select name="city" lay-verify="required">--%>
<%--                            <option value=""></option>--%>
<%--                            <option value="0">北京</option>--%>
<%--                            <option value="1">上海</option>--%>
<%--                            <option value="2">广州</option>--%>
<%--                            <option value="3">深圳</option>--%>
<%--                            <option value="4">杭州</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">复选框</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <input type="checkbox" name="like[write]" title="写作">--%>
<%--                        <input type="checkbox" name="like[read]" title="阅读" checked>--%>
<%--                        <input type="checkbox" name="like[dai]" title="发呆">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">开关</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <input type="checkbox" name="switch" lay-skin="switch">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">单选框</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <input type="radio" name="sex" value="男" title="男">--%>
<%--                        <input type="radio" name="sex" value="女" title="女" checked>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="layui-form-item layui-form-text">--%>
<%--                    <label class="layui-form-label">文本域</label>--%>
<%--                    <div class="layui-input-block">--%>
<%--                        <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="btns">
                    <div class="layui-input-block">
                        <button id="adminloginbutid" class="layui-btn" type="button" onclick="submitForm()">登录</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--页脚-->
    <div class="footer">
        <p>© 2021 <a target="_blank">同学帮</a></p>
<%--        <p>--%>
<%--            <span><a href="https://github.com/wowpH/Lease" target="_blank">GitHub</a></span>--%>
<%--            <span><a href="https://blog.csdn.net/pfdvnah" target="_blank">CSDN</a></span>--%>
<%--            <span><a href="https://www.layui.com" target="_blank">Layui</a></span>--%>
<%--            <span><a href="https://www.layui.com/admin/pro" target="_blank">LayuiAdmin</a></span>--%>
<%--        </p>--%>
    </div>
</div>

<!--layui框架的基础核心库-->
<script src="../layui/layui.js"></script>
<!--lease项目自定义的登录js文件-->
<%--<script src="${APP_PATH}/lease/js/login.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
<script>

function submitForm() {
    console.log("进入点击函数");
    var account=loginformname.account.value;

    console.log("account为"+account);
    var password=loginformname.password.value;
    console.log("password为"+password);
    var data=(account!=null)&(password!=null);
    console.log("数据为"+data);
    $.ajax({
        url: '/check.do'
        , type: 'post'
        , dataType: 'text'
        , data: {"account":account,"password":password},
        async:false,
        success: function (message) {
            console.log("调用完成");
            if(message==="200")
            {
                console.log("登陆成功");
                location.href = '/index.jsp'; // 跳转到管理员主页
            }
            else
            {
                console.log("账号或密码错误");
                $('account').val("");
                $('password').val("");
                layer.msg("账号或密码错误",{icon:5,offset:'40px'});
            }

        },
        error: function () {
            console.log("登陆失败");
           // location.href = '/index.jsp';
        },
        complete: function () {
            console.log("登陆完成");
        }
    });

}



</script>
<style>
    .header{
        margin-top:100px;
        text-align:center;
    }
    .footer{
        margin-top: 200px;
        text-align:center

    }
    .btns{
        text-align:center;
        margin:0 auto;
        width:300px;
        margin-top: 100px;
    }
    .logintable{
        /*margin:0 auto;*/
        /*text-align:center;*/
        margin-top: 100px;


    }
    .label{
        margin:0 auto;width:330px;
        /*margin-left:'50%';*/
        /*margin-right: auto;*/
        /*text-align: center;*/
        /*float:left;*/
        /*position:relative;*/
        /*left:50%;*/
    }

</style>