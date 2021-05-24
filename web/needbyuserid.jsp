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
        <%--        <table width="50%",border="0" align="center" cellpadding="5" cellspacing="1" >--%>
        <%--            <tr>--%>
        <%--                <th>ID</th>--%>
        <%--                <th>申请人ID</th>--%>
        <%--                <th>题目</th>--%>
        <%--                <th>正文</th>--%>
        <%--                <th>申请时间</th>--%>
        <%--                <th>申请状态</th>--%>
        <%--                <th>处理人ID</th>--%>
        <%--                <th>申请时间</th>--%>
        <%--                <th>申请意见</th>--%>
        <%--            </tr>--%>

        <%--                <c:forEach items='<%=request.getSession().getAttribute("NeedApplyList")%>' var="item" >--%>

        <%--                        <tr>--%>
        <%--                            <td align="center">${item}</td>--%>
        <%--                            <td align="center">${item.applyuserid}</td>--%>
        <%--                            <td align="center">${item.needtitle}</td>--%>
        <%--                            <td align="center">${item.needtext}</td>--%>
        <%--                            <td align="center">${item.needtime}</td>--%>
        <%--                            <td align="center">${item.applystate}</td>--%>
        <%--                            <td align="center">${item.solveuserid}</td>--%>
        <%--                            <td align="center">${item.solvetime}</td>--%>
        <%--                            <td align="center">${item.solveview}</td>--%>
        <%--                        </tr>--%>


        <%--                </c:forEach>--%>

        <%--        </table>--%>

        <%--        <table id="demo" lay-filter="test" class="layui-table"></table>--%>
        <table class="layui-table" lay-data="{width:'full',height:'680',url:'/findAllNeed.do',page:true,id:'needdemo'}" lay-filter="needdemo">
            <thead>
            <tr>

                <th lay-data="{field:'needId', width:60, sort: true}">ID</th>
                <th lay-data="{field:'username', width:100}">用户名</th>
                <th lay-data="{field:'title', width:100}">题目</th>
                <th lay-data="{field:'text', width:200}">正文</th>
                <th lay-data="{field:'time', width: 150}">时间</th>
                <th lay-data="{field:'reward', width: 80}">积分</th>
                <th lay-data="{field:'state',width: 100,}">状态</th>
                <th lay-data="{field:'ismultiple',width: 100,templet:'#needbar'}">管理</th>
                <%--                <th lay-data="{ width:80,  fixed: 'right', toolbar: '#judgebar'}">处理</th>--%>
            </tr>
            </thead>
        </table>
    </div>
    <script type="text/html" id="needbar">

        {{# if(d.ismultiple==0){}}
        <a class="layui-btn layui-btn-xs" lay-event="hide">隐藏</a>
        {{# } else {}}
        <a class="layui-btn layui-btn-xs" lay-event="rehide">已隐藏</a>
        {{#  }}}

    </script>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        同学帮管理系统
    </div>
</div>

<%--<form class="layui-form" lay-filter="form-switch" id="switch-form">--%>
<%--    <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">审核意见</label>--%>
<%--            <div class="layui-input-block" id="project-switch">--%>
<%--                  <input type="radio" name="view" lay-filter="view" value="通过" title="通过" checked >--%>
<%--                  <input type="radio" name="view" lay-filter="view" value="不通过" title="不通过">--%>
<%--            </div>--%>
<%--    </div>--%>
<%--
<%--</form>--%>

<script src="./layui/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</body>
</html>
<script>

    var userid=<%=request.getSession().getAttribute("userid")%>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    layui.use(["table","layer"], function(){
        var table = layui.table;
        var layer=layui.layer;
        var view="通过";
        table.on('tool(needdemo)',function (obj) {
            console.log('进入按钮的点击函数')
            var data=obj.data;
            var needid=data.needId;
            var layevent=obj.event;
            if(layevent==='hide')
            {
                console.log('进入隐藏函数'+"needid为"+needid);
                layer.open({
                    type:1,
                    title:"是否隐藏该需求",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    btn: ['确定', '取消'],
                    yes:function (index,layero) {
                        $.ajax({
                            url: '/hide.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"needid":needid,"type":"hide"},
                            async:false,
                            success: function (message) {
                                console.log("隐藏成功");
                                location.href = '/needbyuserid.jsp';
                            },
                            error: function () {
                                console.log("隐藏失败");
                                // location.href = '/index.jsp';
                            },
                            complete: function () {
                                console.log("隐藏完成");
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
                form.render();
            }
            else if(layevent==='rehide')
            {
                console.log('进入隐藏函数'+"needid为"+needid);
                layer.open({
                    type:1,
                    title:"是否显示该需求",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    btn: ['确定', '取消'],
                    yes:function (index,layero) {
                        $.ajax({
                            url: '/hide.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"needid":needid,"type":"rehide"},
                            async:false,
                            success: function (message) {
                                console.log("显示成功");
                                location.href = '/needbyuserid.jsp';
                            },
                            error: function () {
                                console.log("显示失败");
                                // location.href = '/index.jsp';
                            },
                            complete: function () {
                                console.log("显示完成");
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