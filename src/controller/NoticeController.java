package controller;

import com.alibaba.fastjson.JSON;
import entity.ItemNotice;
import entity.Need;
import entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import serviceimpl.NoticeServiceImpl;
import serviceimpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("")
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;
    @RequestMapping(value="findAllNotice.do",produces="text/html;charset=utf-8")
    public @ResponseBody
    String findAllNotice(){
        System.out.println("进入findallnotice");
        List<Notice> lists=noticeService.QueryAll();
        String jsonString = JSON.toJSONString(lists);
        //下面这里这个格式是在网上找的
        int length=lists.size();
        String count=String.valueOf(length);
        String books="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+jsonString+"}";
        System.out.println("-----"+books);
        return books;
    }
    @RequestMapping(value = "/checknotice.do",method = RequestMethod.POST)
    @ResponseBody
    public String doCheck(Integer id, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入查看通知函数");

        try {
            noticeService.CheckNotice(id);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }
    @RequestMapping(value = "/replynotice.do",method = RequestMethod.POST)
    @ResponseBody
    public String doReply(Integer adminid,Integer messageid ,String text,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入查看通知函数");

        try {
            noticeService.ReplyNotice(adminid,messageid,text);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }
    @RequestMapping(value = "/sendnotice.do",method = RequestMethod.POST)
    @ResponseBody
    public String doSendNotice(Integer userid,Integer adminid ,String text,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入发送通知函数"+userid+adminid+text);

        try {
            noticeService.SendNotice(userid,adminid,text);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }
    public void setNoticecontroller(UserServiceImpl noticecontroller) {
    }
}
