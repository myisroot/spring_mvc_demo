package com.spring.mvc.demo.dao;

import com.spring.mvc.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public User get(Integer id) {
        String sql = "SELECT * FROM USER where id =?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = template.queryForObject(sql, rowMapper, id);
        return user;
    }

}
