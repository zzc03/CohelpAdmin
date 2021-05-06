package controller;


import com.alibaba.fastjson.JSON;
import entity.Constant;
import entity.Message;

import entity.SessionSave;
import entity.User;
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


//        Student student = new Student();
//
//        int studentID = Integer.parseInt(request.getParameter("student_id"));
//        System.out.println("studentID:"+studentID);
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String sex = request.getParameter("sex");
//        Date birthday = null;
//        // String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        student.setStudent_id(studentID);
//        student.setName(name);
//        student.setAge(age);
//        student.setSex(sex);
//        student.setBirthday(birthday);
//
//        studentService.addStudent(student);
//        return "redirect:listStudent";
    }
    public void setController(UserServiceImpl controller) {
    }
}
