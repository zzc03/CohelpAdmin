<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>同学帮管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">同学帮管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <%--        <ul class="layui-nav layui-layout-left">--%>
        <%--            <li class="layui-nav-item"><a href="">nav 1</a></li>--%>
        <%--            <li class="layui-nav-item"><a href="">nav 2</a></li>--%>
        <%--            <li class="layui-nav-item"><a href="">nav 3</a></li>--%>
        <%--            <li class="layui-nav-item">--%>
        <%--                <a href="javascript:;">nav groups</a>--%>
        <%--                <dl class="layui-nav-child">--%>
        <%--                    <dd><a href="">menu 11</a></dd>--%>
        <%--                    <dd><a href="">menu 22</a></dd>--%>
        <%--                    <dd><a href="">menu 33</a></dd>--%>
        <%--                </dl>--%>
        <%--            </li>--%>
        <%--        </ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    <td><%=request.getSession().getAttribute("name")%></td>
                </a>
                <%--                <dl class="layui-nav-child">--%>
                <%--                    <dd><a href="">set 1</a></dd>--%>
                <%--                    <dd><a href="">set 2</a></dd>--%>
                <%--                </dl>--%>
            </li>
            <li class="layui-nav-item"><a href="/">Sign out</a></li>
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
                        <%--                        <dd><a href="javascript:;">menu item 1-2</a></dd>--%>
                        <%--                        <dd><a href="javascript:;">menu item 1-3</a></dd>--%>
                        <%--                        <dd><a href="">the links</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" >用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/user.jsp">用户管理</a></dd>
                        <dd><a href="/register.jsp">注册管理</a></dd>
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <table class="layui-table" lay-data="{width:'full',height:'680',url:'/findAllUser.do',page:true,id:'userdemo'}" lay-filter="userdemo">
            <thead>
            <tr>
                <th lay-data="{field:'userId', width:60, sort: true}">ID</th>
                <th lay-data="{field:'name', width:100}">用户昵称</th>
                <th lay-data="{field:'account', width:100}">账号</th>
                <th lay-data="{field:'password', width:200}">密码</th>
                <th lay-data="{field:'description', width: 150}">用户信息</th>
                <th lay-data="{field:'icon', width: 150}">用户头像</th>
                <th lay-data="{field:'money', width: 80}">用户积分</th>
                <th lay-data="{field:'isvalid',width: 100,templet:'#needbar'}">状态</th>
                <%--                <th lay-data="{ width:80,  fixed: 'right', toolbar: '#judgebar'}">处理</th>--%>
            </tr>
            </thead>
        </table>
    </div>
    <script type="text/html" id="needbar">

        {{# if(d.isvalid==0){}}
        <a class="layui-btn layui-btn-xs" lay-event="doban">正常</a>
        {{# } else {}}
        <a class="layui-btn layui-btn-xs" lay-event="doreban">已封禁</a>
        {{#  }}}

    </script>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        同学帮管理系统
    </div>
</div>

<style>
    .text{
        text-align: center;

    }
</style>
<script src="./layui/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use(["table","layer"], function(){
        var table = layui.table;

        table.on('tool(userdemo)',function (obj) {
            console.log('进入按钮的点击函数')
            var data=obj.data;
            var userid=data.userId;
            var layevent=obj.event;
            if(layevent==='doban')
            {
                console.log('进入封禁函数，用户id为'+userid)
                layer.open({
                    type:1,
                    title:"是否对该用户进行封禁",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    // offset:[Math.random()*($(window).height()-300),Math.random()*($(window).width()-390)],

                    btn: ['确定', '取消'],
                    yes:function (index,layero) {
                        $.ajax({
                            url: '/userban.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"userid":userid,"type":"doban"},
                            async:false,
                            success: function (message) {
                                console.log("封禁成功成功");
                                location.href = '/user.jsp';
                            },
                            error: function () {
                                console.log("封禁失败");
                                // location.href = '/index.jsp';
                            },
                            complete: function () {
                                console.log("封禁完成");
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
            }
            else if(layevent==='doreban')
            {
                console.log('进入解封函数，用户id为'+userid)
                layer.open({
                    type:1,
                    title:"是否对该用户进行解除封禁",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    // offset:[Math.random()*($(window).height()-300),Math.random()*($(window).width()-390)],

                    btn: ['确定', '取消'],
                    yes:function (index,layero) {
                        $.ajax({
                            url: '/userban.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"userid":userid,"type":"doreban"},
                            async:false,
                            success: function (message) {
                                console.log("解封成功成功");
                                location.href = '/user.jsp';
                            },
                            error: function () {
                                console.log("解封失败");
                                // location.href = '/index.jsp';
                            },
                            complete: function () {
                                console.log("解封完成");
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
            }
        });

        form.render();

    });
</script>
</body>
</html>