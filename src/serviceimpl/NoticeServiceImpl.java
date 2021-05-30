package serviceimpl;

import entity.ItemNotice;
import entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import service.NoticeService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Notice> QueryAll()
    {
        String sql="select * from table_message as a LEFT JOIN table_user as b ON   a.send_id=b.user_id where a.message_type=2";
        try{
            List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
            List<Notice> list=Notice.toObject(result);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void CheckNotice(Integer id)
    {
        try{
            String sql="update table_message set is_read=1 where message_id="+id;
            int upnum=jdbcTemplate.update(sql);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void ReplyNotice(Integer adminid,Integer messageid,String text) {
        try {
            Date date=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql="select * from table_message as a LEFT JOIN table_user as b ON   a.send_id=b.user_id where a.message_id="+messageid;
            Map<String,Object> map=jdbcTemplate.queryForMap(sql);
            Notice notice=Notice.toObject(map);
            String insertsql="insert into table_message (message_type,send_id,receive_id,is_read,title,text,time)values(?,?,?,?,?,?,?)";
            int num=jdbcTemplate.update(insertsql,1,adminid,notice.getSendid(),0,"",text,sdf.format(date));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void SendNotice(Integer userid,Integer adminid,String text)
    {
        try {
            Date date=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String insertsql="insert into table_message (message_type,send_id,receive_id,is_read,title,text,time)values(?,?,?,?,?,?,?)";
            int num=jdbcTemplate.update(insertsql,1,adminid,userid,0,"",text,sdf.format(date));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
