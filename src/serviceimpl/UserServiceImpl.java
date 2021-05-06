package serviceimpl;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.UserService;

import java.util.List;

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

//    public void setDataSource(DriverManagerDataSource dataSource) {
//    }
}

