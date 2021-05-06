package mapper;

import entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAccount(resultSet.getString("account"));
        user.setPassword(resultSet.getString("password"));
        user.setIcon(resultSet.getString("icon"));
        return user;
    }
}
