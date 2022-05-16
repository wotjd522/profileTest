package repo.impl;

import domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import repo.BoardRepo;

import java.util.List;
@Component
public class BoardImp implements BoardRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Board> findAll() {
        return template.query("select * from board order by board_seq",
                new BeanPropertyRowMapper<>(Board.class));
    }

    @Override
    public Board findBySeq(int seq) {
        return template.queryForObject("select * from board where board_seq = ?",
                new BeanPropertyRowMapper<>(Board.class), seq);
    }

    @Override
    public void insert(Board b) {
        template.update("insert into board(title, category, content, user_role, user_seq)" +
                "values (?,?,?,?,?)",b.getTitle(), b.getCategory(), b.getContent(), b.getUserRole(), b.getUserSeq());
    }

    @Override
    public void delete(int seq) {
        template.update("delete from board " +
                "where board_seq = ?", seq);
    }

    @Override
    public void update(Board b) {
        template.update("update board " +
                "set title = ?, content = ?" , b.getTitle(), b.getContent());
    }
}
