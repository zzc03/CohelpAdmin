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
        <!-- 内容主体区域 -->
        <div style="padding: 15px;" class="text">管理员
        <td><%=request.getSession().getAttribute("name")%></td>,你好</div>
    </div>

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
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>