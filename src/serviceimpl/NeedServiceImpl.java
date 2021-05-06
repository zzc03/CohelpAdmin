package serviceimpl;

import entity.ItemJudge;
import entity.Need;
import entity.User;
import mapper.NeedMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import service.NeedService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NeedServiceImpl implements NeedService {
    @Autowired
    private NeedMapper needMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Need> queryAll()
    {
        String sql="select * from table_needapply as a LEFT JOIN table_user as b on a.applyuserid=b.user_id";
        List<Need> needs=new ArrayList<>();
        try{
            List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
            System.out.println("结果为"+result);
//            System.out.println("结果为"+user);
            return Need.toObject(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void JudgeNeed(String userid,String applyid, String view,String viewtext)
    {
        System.out.println("进入审核函数"+userid+applyid+view+viewtext);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            if(view.equals("通过"))
            {

                String sql="select * from table_needapply where applyid="+applyid;
                Map<String,Object> result=jdbcTemplate.queryForMap(sql);
                Need need=Need.toObject(result);
                String insertsql="insert into table_need (need_title,need_text,need_time,need_state,need_reward,need_user_id)values(?,?,?,?,?,?)";
                int num=jdbcTemplate.update(insertsql,need.getNeedtitle(),need.getNeedtext(),need.getNeedtime(),"正在进行",need.getNeedreward(),userid);
               String updatesql="update table_needapply set applystate='已通过',solveuserid="+userid+",solvetime='"+sdf.format(date)+"',solveview='"+viewtext+"' where applyid="+applyid;
                System.out.println("sql为"+updatesql);
                int upnum=jdbcTemplate.update(updatesql);
            }
            else
            {
                String updatesql="update table_needapply set applystate='未通过',solveuserid="+userid+",solvetime='"+sdf.format(date)+"',solveview='"+viewtext+"' where applyid="+applyid;
                System.out.println("sql为"+updatesql);
                int up=jdbcTemplate.update(updatesql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<ItemJudge> queryAllJudge()
    {
        String sql="select * from table_zhongcai as a LEFT JOIN table_needapply as b on a.zc_objectid=b.applyid";

        List<ItemJudge> needs=new ArrayList<>();
        try{
            List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
            System.out.println("结果为"+result);
//            System.out.println("结果为"+user);
            List<ItemJudge> itemJudges=ItemJudge.toObject(result);
            for (ItemJudge a:itemJudges)
            {
                String sql1="select user_name from table_user where user_id="+a.getApplyuserid();
                System.out.println("sql为"+sql1);
                String name=jdbcTemplate.queryForObject(sql1,String.class);
                a.setApplyusername(name);
            }
            return itemJudges;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void JudgeApplyNeed(String userid,String id, String view,String viewtext)
    {
        System.out.println("进入审核函数"+userid+id+view+viewtext);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            if(view.equals("通过"))
            {

                String sql="select * from table_needapply where applyid="+id;
                Map<String,Object> result=jdbcTemplate.queryForMap(sql);
                Need need=Need.toObject(result);
                String insertsql="insert into table_need (need_title,need_text,need_time,need_state,need_reward,need_user_id)values(?,?,?,?,?,?)";
                int num=jdbcTemplate.update(insertsql,need.getNeedtitle(),need.getNeedtext(),need.getNeedtime(),"正在进行",need.getNeedreward(),userid);
                String updatesql="update table_needapply set applystate='已通过',solveuserid="+userid+",solvetime='"+sdf.format(date)+"',solveview='"+viewtext+"' where applyid="+id;
                System.out.println("sql为"+updatesql);
                int upnum=jdbcTemplate.update(updatesql);
                String updatesql1="update table_zhongcai set zc_solveuserid="+userid+",zc_solvetime='"+sdf.format(date)+"',zc_solveview='"+view+"',zc_solveviewtext='"+viewtext+"' where applyid="+id;
                int upnum1=jdbcTemplate.update(updatesql1);
            }
            else
            {
                String updatesql="update table_zhongcai set zc_solveuserid="+userid+",zc_solvetime='"+sdf.format(date)+"',zc_solveview='"+view+"',zc_solveviewtext='"+viewtext+"' where applyid="+id;
                System.out.println("sql为"+updatesql);
                int up=jdbcTemplate.update(updatesql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
