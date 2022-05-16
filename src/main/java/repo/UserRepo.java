package repo;

import domain.User;

import java.util.List;

public interface UserRepo {
    User findById(String id);
    User findBySeq(int seq);
    void insert(User u);
    void update(User u);
    void delete(User u);

    List<User> findAll();

}
