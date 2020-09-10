package dao.JdbcTemplate;

import domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 使用Spring 的  JdbcTemplate 实现 CURD
public class JdbcTemplateDao {

    private JdbcTemplate jdbcTemplate;

    // xml注入
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void save(User user) {
        int count = jdbcTemplate.update("insert into `user` values (null,?,?)",
                user.getUsername(),
                user.getUserpwd());
        System.out.println(count);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("select * from user", new Object[]{}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getShort("id"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                return user;
            }
        });
    }

    public List<User> getAllUsingLambdaExpression() {
        return jdbcTemplate.query("select * from user", new Object[]{}, (rs, i) -> {
            User user = new User();
            user.setId(rs.getShort("id"));
            user.setUsername(rs.getString("username"));
            user.setUserpwd(rs.getString("userpwd"));
            return user;
        });
    }


}
