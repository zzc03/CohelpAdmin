package controller;


import com.alibaba.fastjson.JSON;
import entity.*;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import serviceimpl.UserServiceImpl;


import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.spi.SyncResolver;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping(value = "/queryByAccount",method = RequestMethod.POST)
    @ResponseBody
    public String queryByName(String account, Model model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc容器中获取dao
//        StudentDao dao = (StudentDao) context.getBean("dao");
//        model.addAttribute("students", dao.queryByName(name));
//        model.addAttribute("tops", dao.topNum(3));
        UserServiceImpl userService=(UserServiceImpl) context.getBean("dao");
        model.addAttribute("user",userServiceImpl.select(account));
        return "index.jsp";
    }
    @RequestMapping(value = "/check.do",method = RequestMethod.POST)
    @ResponseBody
    public String loginCheck(String account, String password, HttpServletRequest request,HttpServletResponse response) {
        System.out.println("进入checklogin函数");
        User users=userServiceImpl.select(account);
        if(users!=null && users.getPassword().equals(password))
        {
            HttpSession session=request.getSession(true);
            String sessionid=request.getRequestedSessionId();
            Map<String,String> sessionMap=SessionSave.getSessionMap();
            sessionMap.put(Constant.ADMIN,sessionid);
            session.setAttribute("name",users.getName());
            session.setAttribute("userid",users.getId());
            return "200";
        }
        else
        {
            return "400";
        }
    }
    @RequestMapping(value="findAllUser.do",produces="text/html;charset=utf-8")
    public @ResponseBody String findAllUser(){
        System.out.println("进入findalluser");
        List<UserCustom> needs=userServiceImpl.queryAllUser();
        String jsonString = JSON.toJSONString(needs);
        //下面这里这个格式是在网上找的
        int length=needs.size();
        String count=String.valueOf(length);
        String books="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+jsonString+"}";
        System.out.println("-----"+books);
        return books;
    }
    public void writeResponse(Object obj, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");//设置编码
            String str = JSON.toJSONString(obj);
            PrintWriter writer = response.getWriter();
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/logincheck")
    public String addStudent(HttpServletRequest request, HttpServletResponse response) {

            String account=request.getParameter("account");
            String password=request.getParameter("password");
            User users=userServiceImpl.select(account);

        if(users!=null)
        {
            if(users.getPassword().equals(password))
            {
                return "index.jsp";
            }
            else
            {
               return "";
            }
        }
        else
        {
           return "";
        }
    }
    public void setController(UserServiceImpl controller) {
    }
    @RequestMapping(value="userban.do",produces="text/html;charset=utf-8")
    public @ResponseBody String Userban(Integer userid,String type){
        System.out.println("进入Userban");
        userServiceImpl.UserBan(userid,type);
//        List<UserCustom> needs=userServiceImpl.queryAllUser();
//        String jsonString = JSON.toJSONString(needs);
//        //下面这里这个格式是在网上找的
//        int length=needs.size();
//        String count=String.valueOf(length);
//        String books="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+jsonString+"}";
//        System.out.println("-----"+books);
        return "200";
    }
}
