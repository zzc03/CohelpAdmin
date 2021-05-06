package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import serviceimpl.NeedServiceImpl;
import serviceimpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class NeedController {
    @Autowired
    private NeedServiceImpl needServiceImpl;
    @RequestMapping("/listapply.do")
    @ResponseBody
    public String listapply(HttpServletRequest request) {
        System.out.println("进入listapply函数");

        Message message = new Message();
        // 判断是否是admin
        List<Need> needs=needServiceImpl.queryAll();

        if(needs.size()!=0)
        {
            HttpSession session = request.getSession(true);
            // 获取当前的Session ID
            String sessionId = request.getRequestedSessionId();

            // 获取已经登录的账号的Session ID集合
            Map<String, String> sessionMap = SessionSave.getSessionMap();
            // if (sessionMap.isEmpty()) {
            //    Log.log("没有已登录的账号");
            // } else {
            //    Log.log("已经登录过的账号和Session ID如下：");
            //     for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            //         System.out.println(entry.getKey() + ", " + entry.getValue());
            //     }
            // }
            // Log.log("将Session ID添加到map中", sessionId);
            sessionMap.put(Constant.ADMIN, sessionId);
            // Log.log("将对象保存到Session中", admin.toString());
//            Need[] results=list2array(needs);
            System.out.println("传的参数为"+needs);
            session.setAttribute("NeedApplyList", needs);
            JSONArray array=getJSONArrayByList(needs);
            session.setAttribute("NeedApplyListJson", array);
//            ActionContext.getContext().getValueStack().set("jsonData",array);
        }
        return "message";
    }
    public Need[] list2array(List<Need> list){
        if(list==null || list.size()==0){
            return null;
        }
        Need[] array = new Need[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]= list.get(i);
        }
        return array;
    }
    public static JSONArray getJSONArrayByList(List<?> list){
        JSONArray jsonArray = new JSONArray();
        if (list==null ||list.isEmpty()) {
            return jsonArray;//nerver return null
        }

        for (Object object : list) {
            jsonArray.add(object);
        }
        return jsonArray;
    }

    public void setNeedcontroller(UserServiceImpl needcontroller) {
    }
    @RequestMapping(value="findAll.do",produces="text/html;charset=utf-8")
    public @ResponseBody String findAll(){
        System.out.println("进入findall");
        List<Need> needs=needServiceImpl.queryAll();
        String jsonString = JSON.toJSONString(needs);
        //下面这里这个格式是在网上找的
        int length=needs.size();
        String count=String.valueOf(length);
        String books="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+jsonString+"}";
        System.out.println("-----"+books);
        return books;
    }
    @RequestMapping(value="findAllJudge.do",produces="text/html;charset=utf-8")
    public @ResponseBody String findAllJudge(){
        System.out.println("进入findalljudge");
        List<ItemJudge> list=needServiceImpl.queryAllJudge();
        String jsonString = JSON.toJSONString(list);
        //下面这里这个格式是在网上找的
        int length=list.size();
        String count=String.valueOf(length);
        String books="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+jsonString+"}";
        System.out.println("-----"+books);
        return books;
    }
    @RequestMapping(value = "/judge.do",method = RequestMethod.POST)
    @ResponseBody
    public String dojudge(String solveuserid,String applyid, String view,String viewtext, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入审核函数");

        try {
            needServiceImpl.JudgeNeed(solveuserid,applyid,view,viewtext);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }
    @RequestMapping(value = "/applyjudge.do",method = RequestMethod.POST)
    @ResponseBody
    public String doApplyjudge(String solveuserid,String id, String view,String viewtext, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入审核函数");

        try {
            needServiceImpl.JudgeNeed(solveuserid,id,view,viewtext);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }
}
