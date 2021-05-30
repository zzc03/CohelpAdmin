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
        <table class="layui-table" lay-data="{width:'full',height:'680',url:'/findAllNotice.do',page:true,id:'demo'}" lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{field:'id', width:60, sort: true}">ID</th>
                <th lay-data="{field:'sendname', width:100}">发送人</th>
                <th lay-data="{field:'text', width:200}">正文</th>
                <th lay-data="{field:'time', width: 250}">时间</th>
                <th lay-data="{field:'isread', width:100,templet:'#noticebar'}">状态</th>
                <th lay-data="{width:200,templet:'#checkbar'}"></th>
<%--                <th lay-data="{field:'needreward', width: 80}">积分</th>--%>
<%--                <th lay-data="{field:'applystate',width: 100,templet:'#judgebar'}">状态</th>--%>
<%--                <th lay-data="{field:'applystate',width: 100,}">审核结果</th>--%>
<%--                <th lay-data="{field:'solveuserid', width: 50}">处理人ID</th>--%>
<%--                <th lay-data="{field:'solovetime', width: 150}">处理时间</th>--%>
<%--                <th lay-data="{field:'solveview', width: 100}" >处理意见</th>--%>
                <%--                <th lay-data="{ width:80,  fixed: 'right', toolbar: '#judgebar'}">处理</th>--%>
            </tr>
            </thead>
        </table>
    </div>
    <script type="text/html" id="noticebar">

        {{# if(d.isread==0){}}
        <a >未读</a>
        {{# } else {}}
        <a >已读</a>
        {{#  }}}

    </script>
    <script type="text/html" id="checkbar">


        <a class="layui-btn layui-btn-xs" lay-event="check">查看</a>

        <a class="layui-btn layui-btn-xs" lay-event="reply">回复</a>


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
<div class="layui-row" id="test" style="display: none;">
    <div class="layui-col-md10">
        <form class="layui-form" id="judgeForm" name="judgeForm" action="">

            <div class="layui-form-item" id="hidediv" lay-filter="hidediv">
                <label class="layui-form-label">回复：</label>
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

        table.on('tool(demo)',function (obj) {
            console.log('进入按钮的点击函数')
            var data=obj.data;
            var needid=data.id;
            var name=data.sendname;
            var text=data.text;
            var layevent=obj.event;
            var html="<div style='padding: 15px;'>"+"发送人："+ name + "<br><br>"+text +"</div>";
            if(layevent==='check')
            {
                console.log('进入查看函数'+"applyid为"+needid);
                layer.open({
                    type:1,
                    title:"查看消息",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    content:html ,
                    btn: ['确定'],
                    yes:function (index,layero) {
                        $.ajax({
                            url: '/checknotice.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"id":needid},
                            async:false,
                            success: function (message) {
                                console.log("审核成功");
                                location.href = '/notice.jsp';
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

                    zIndex:layer.zIndex,
                    success:function (layero) {
                        layer.setTop(layero);
                    }
                })
                form.render();
            }
            else if(layevent==='reply')
            {
                console.log('进入回复点击函数'+"applyid为"+needid);
                layer.open({
                    type:1,
                    title:"请填写回复信息",
                    area:['400px','270px'],
                    shade:0,
                    maxmin:0,
                    // offset:[Math.random()*($(window).height()-300),Math.random()*($(window).width()-390)],
                    content:$("#test") ,
                    btn: ['确定', '取消'],
                    yes:function (index,layero) {
                        // var viewtext=judgeForm.viewText.value;
                        // var viewtext=$('viewtextdiv input[name="viewText"]').val();
                        var input=document.getElementById("viewText");
                        // var viewtext=document.forms["judgeForm"]["viewTextName"].value
                        console.log("输入框id为"+input);
                        var viewtext=input.value;
                        // var body=layer.getChildFrame('body',index);
                        // var viewtext=body.find('#viewText').val();
                        console.log("输入框里的值为"+viewtext);

                        $.ajax({
                            url: '/replynotice.do'
                            , type: 'post'
                            , dataType: 'text'
                            , data: {"adminid":userid,"messageid":needid,"text":viewtext},
                            async:false,
                            success: function (message) {
                                console.log("审核成功");
                                location.href = '/notice.jsp';
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
                form.render();
            }
            else
            {
                console.log('进入点击函数失败进入了'+layevent);
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

    // layui.use(["form","laypage","layer"],function () {
    //     var form=layui.form;
    //     var laypage=layui.page;
    //     var layer=layui.layer;
    //     form.on('radio(view)',function (data) {
    //         // var value=data.value;
    //         // console.log("当前选中的是"+value);
    //         // if(this.value==="通过")
    //         // {
    //         //     console.log("已通过");
    //         //     layer.msg("已通过",{icon:5,offset:'40px'});
    //         // }
    //         // else
    //         // {
    //         //     console.log("未通过");
    //         //     layer.msg("未通过",{icon:5,offset:'40px'});
    //         // }
    //         // console.log();
    //         if($('#project-switch input[name="view"]:checked').val()==="通过")
    //         {
    //             console.log("选择了通过");
    //             // $(".project-hide").slideDown();
    //
    //             $("#switchTest-project").show();
    //         }else
    //         {
    //             console.log("选择了不通过");
    //             $("#switchTest-project").hide();
    //             // $(".project-hide").slideUp();
    //         }
    //         // form.render('checkbox','form-switch');
    //         // form.render('radio');
    //
    //
    //     });
    //     form.render();
    // });


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