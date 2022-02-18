package dao;

import models.User;

import java.util.List;

public interface IntUser {
    //    CRUDE
    void create(User user);
    List<User> findAll();
    User findbyId(int id);
    void deleteAll();
    void deleteById(int id);
}
