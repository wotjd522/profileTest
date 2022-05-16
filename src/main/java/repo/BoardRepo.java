package repo;

import domain.Board;

import java.util.List;

public interface BoardRepo {
    List<Board> findAll();
    Board findBySeq (int seq);
    void insert (Board b);
    void delete (int seq);
    void update (Board b);
}
