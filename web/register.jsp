<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>同学帮管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script>
        var xhr = new XMLHttpRequest();
        xhr.open("get","findAll.do");
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
            }
        };
        xhr.send();
    </script>

</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">同学帮管理系统</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    <td><%=request.getSession().getAttribute("name")%></td>
                </a>

            </li>
            <li class="layui-nav-item"><a href="">Sign out</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" >需求管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/needcot.jsp">申请发布需求</a></dd>
                        <dd><a href="/zhongcai.jsp">用户仲裁申请</a></dd>
                        <dd><a href="/needbyuserid.jsp">已发布的需求</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" >用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/user.jsp">用户管理</a></dd>
                        <dd><a href="/register.jsp">注册管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" >消息通知</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/notice.jsp">消息</a></dd>

                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">

        <table class="layui-table" lay-data="{width:'full',height:'680',url:'/findAllRegister.do',page:true,id:'demo'}" lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{field:'applyid', width:60, sort: true}">ID</th>
                <th lay-data="{field:'account', width:100}">账号</th>
                <th lay-data="{field:'password', width:100}">密码</th>
                <th lay-data="{field:'name', width:100}">姓名</th>
                <th lay-data="{field:'stuid', width: 150}">学号</th>
                <th lay-data="{field:'state',width: 100,templet:'#judgebar'}">处理</th>
                <th lay-data="{field:'solverid', width: 80}">处理人ID</th>
                <th lay-data="{field:'solvetime',width: 100}">处理时间</th>
                <th lay-data="{field:'solveview',width: 100,}">处理结果</th>
                <th lay-data="{field:'solvetext', width: 50}">处理意见</th>

                <%--                <th lay-data="{ width:80,  fixed: 'right', toolbar: '#judgebar'}">处理</th>--%>
            </tr>
            </thead>
        </table>
    </div>
    <script type="text/html" id="judgebar">

        {{# if(d.state=="申请中"){}}
        <a class="layui-btn layui-btn-xs" lay-event="judge">审核</a>
        {{# } else {}}
        <a class="layui-btn layui-btn-xs" >已审核</a>
        {{#  }}}

    </script>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        同学帮管理系统
    </div>
</div>


<div class="layui-row" id="test" style="display: none;">
    <div class="layui-col-md10">
        <form class="layui-form" id="judgeForm" name="judgeForm" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">审核意见：</label>
                <div class="layui-input-block">
                    <input type="radio" name="view" lay-filter="view" value="通过" title="通过" checked >
                    <input type="radio" name="view" lay-filter="view" value="不通过" title="不通过">
                </div>
            </div>
            <div class="layui-form-item" id="hidediv" lay-filter="hidediv">
                <label class="layui-form-label">意见：</label>
                <div class="layui-input-block" id="viewtextdiv">
                    <input type="text" id="viewText" name="viewTextName">
                </div>
            </div>
        </form>
    </div>
</div>

<script src="./layui/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</body>
</html>
<script>
    var getinputvalue=function() {
        var viewtext=$('input[name="viewTextName"]').val();
        return viewtext;

    }
    var userid=<%=request.getSession().getAttribute("userid")%>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    layui.use(["table","form","laypage","layer"], function(){
        var table = layui.table;
        var form=layui.form;
        var laypage=layui.laypage;
        var layer=layui.layer;
        var view="通过";
        table.on('tool(demo)',function (obj) {
            console.log('进入按钮的点击函数')
            var data=obj.data;
            var applyid=data.applyid;
            var name=data.name;
            var stuid=data.stuid;
            var layevent=obj.event;
            if(layevent==='judge')
            {
                console.log('进入审核点击函数'+"applyid为"+applyid);
                $.ajax({
                    url: '/checkregister.do'
                    , type: 'post'
                    , dataType: 'text'
                    , data: {"solveuserid":userid,"applyid":applyid,"name":name,"stuid":stuid},
                    async:false,
                    success: function (message) {
                        console.log("审核成功");
                        if(message==="200")
                        {
                            alert("用户信息存在");

                        }
                        else
                        {
                            alert("用户信息不正确或不存在");
                        }
                        layer.open({
                            type:1,
                            title:"请选择审核意见",
                            area:['400px','270px'],
                            shade:0,
                            maxmin:0,
                            // offset:[Math.random()*($(window).height()-300),Math.random()*($(window).width()-390)],
                            content:$("#test") ,
                            btn: ['确定', '取消'],
                            yes:function (index,layero) {
                                var input=document.getElementById("viewText");
                                console.log("输入框id为"+input);
                                var viewtext=input.value;
                                console.log("输入框里的值为"+viewtext);
                                console.log('意见为'+view+"文字意见为："+viewtext);
                                console.log("用户id为"+userid);
                                $.ajax({
                                    url: '/judgeregister.do'
                                    , type: 'post'
                                    , dataType: 'text'
                                    , data: {"solveuserid":userid,"applyid":applyid,"view":view,"viewtext":viewtext},
                                    async:false,
                                    success: function (message) {
                                        console.log("审核成功");
                                        location.href = '/register.jsp';
                                    },
                                    error: function () {
                                        console.log("审核失败");
                                        // location.href = '/index.jsp';
                                    },
                                    complete: function () {
                                        console.log("审核完成");
                                    }
                                });
                            },
                            btn2:function() {
                                layer.closeAll();
                            },
                            zIndex:layer.zIndex,
                            success:function (layero) {
                                layer.setTop(layero);
                            }
                        })
                        // location.href = '/register.jsp';
                    },
                    error: function () {
                        console.log("审核失败");

                    },
                    complete: function () {
                        console.log("审核完成");
                    }
                });

                form.render();
            }
            else
            {
                console.log('进入审核点击函数失败进入了'+layevent);
            }
        });
        form.on('radio(view)',function (data) {
            var value = data.value;
            console.log("当前选中的是" + value);
            if (this.value === "通过") {
                console.log("已通过");
                view="通过";

            } else {
                console.log("未通过");
                view="未通过";
            }

        })
        form.render();

    });




</script>
<style>
    .input{
        /*outline: 0;*/
        /*-webkit-appearance: none;*/
        /*transition: all .3s;*/
        /*-webkit-transition: all .3s;*/
        /*box-sizing: border-box;*/
        weight:100%;
        cols:3;
        height: 20px;
    }
</style>