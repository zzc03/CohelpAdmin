package mapper;

import entity.Need;
import entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NeedMapper implements RowMapper<Need> {
    @Override
    public Need mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        Need need=new Need();
        need.setApplyid(resultSet.getInt("applyid"));
        need.setApplyuserid(resultSet.getInt("applyuserid"));
        need.setNeedtitle(resultSet.getString("needtitle"));
        need.setNeedtext(resultSet.getString("needtext"));
        need.setNeedtime(resultSet.getString("needtime"));
        need.setApplystate(resultSet.getString("applystate"));
        need.setSolveuserid(resultSet.getInt("solveuserid"));
        need.setSolovetime(resultSet.getString("solvetime"));
        need.setSolveview(resultSet.getString("solveview"));
        need.setNeedreward(resultSet.getInt("needreward"));
        need.setUsername(resultSet.getString("username"));
        return need;
    }
}
