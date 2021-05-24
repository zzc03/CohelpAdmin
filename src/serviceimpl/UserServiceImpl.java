package serviceimpl;

import entity.Need;
import entity.Register;
import entity.User;
import entity.UserCustom;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User select(String account)
    {
        System.out.println("进入serviceimpl函数参数为"+account);
        String sql="select * from table_admin where account="+account;
        System.out.println("sql为"+sql);
        if(jdbcTemplate==null)
        {
            System.out.println("jdbc为空");
        }
        else{
            System.out.println("jdbc不为空");
        }
        try{
            User user=jdbcTemplate.queryForObject(sql,new UserMapper());
            System.out.println("结果为"+user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<UserCustom> queryAllUser()
    {
        String sql="select * from table_user";
        try{
            List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
            System.out.println("结果为"+result);
//            System.out.println("结果为"+user);
            return UserCustom.toObject(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void UserBan(Integer userid,String type)
    {
        try{
            if(type.equals("doban"))
            {
                String sql="update table_user set isvalid='1' where user_id="+userid;
                int num=jdbcTemplate.update(sql);
            }
            else
            {
                String sql="update table_user set isvalid='0' where user_id="+userid;
                int num=jdbcTemplate.update(sql);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public boolean CheckRegister(String userid,String name,String stuid)
    {
        try{
            String sql="select name from table_student where stuid="+stuid;
            String a=jdbcTemplate.queryForObject(sql,String.class);
          if(a!=null && a.equals(name))
          {
              return true;
          }
          else
          {
              return false;
          }
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public List<Register> findAllRegister()
    {
        try{
            String sql="select * from table_register";
            List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
            System.out.println("结果为"+result);
//            System.out.println("结果为"+user);
            return Register.toObject(result);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public void JudgeRegister(String userid,Integer applyid, String view,String viewtext)
    {
        System.out.println("进入审核函数"+userid+applyid+view+viewtext);
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            if(view.equals("通过"))
            {

                String sql="select * from table_register where applyid="+applyid;
                Map<String,Object> result=jdbcTemplate.queryForMap(sql);
                Register register=Register.toObject(result);
                String insertsql="insert into table_user (user_account,user_password,user_name,user_description,user_money,user_icon,isvalid)values(?,?,?,?,?,?,?)";
                int num=jdbcTemplate.update(insertsql,register.getAccount(),register.getPassword(),register.getName(),register.getStuid(),1000,register.getIcon(),0);
                String updatesql="update table_register set state='已通过',solverid="+userid+",solvetime='"+sdf.format(date)+"',solveview='"+viewtext+"' where applyid="+applyid;
                System.out.println("sql为"+updatesql);
                int upnum=jdbcTemplate.update(updatesql);

            }
            else
            {
                String updatesql="update table_register set state='未通过',solverid="+userid+",solvetime='"+sdf.format(date)+"',solveview='"+viewtext+"' where applyid="+applyid;
                System.out.println("sql为"+updatesql);
                int upnum=jdbcTemplate.update(updatesql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

