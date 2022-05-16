package repo.impl;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import repo.UserRepo;

import java.util.List;

@Component
public class UserImp implements UserRepo {
    @Autowired
    JdbcTemplate template;

    @Override
    public User findById(String id) {
        return template.queryForObject("select * from user where user_id = ?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public User findBySeq(int seq) {
        return template.queryForObject("select * from user where user_seq = ?",
                new BeanPropertyRowMapper<>(User.class), seq);
    }

    @Override
    public void insert(User u) {
        template.update("insert into user(user_id, user_password, user_name, user_role, user_rank, category)" +
                "values(?,?,?,?,1,?)", u.getUserId(), u.getUserPassword(), u.getUserName(), u.getUserRole(), u.getCategory());
    }

    @Override
    public void update(User u) {
        template.update("update user " +
                "set user_password = ?, user_name = ?, user_address = ?, user_telno = ?, user_email = ?, user_role = ?, user_comment = ?, user_category = ?" +
                "where user_seq = ?", u.getUserPassword(), u.getUserName(), u.getUserAddress(), u.getUserTelno(), u. getUserEmail(),u.getUserRole(), u.getUserComment(), u.getCategory(), u.getUserSeq());
    }

    @Override
    public void delete(User u) {
        template.update("delete from user " +
                "where user_id = ? and user_password = ?", u.getUserId(), u.getUserPassword());

    }

    @Override
    public List<User> findAll() {
        return template.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
    }
}
