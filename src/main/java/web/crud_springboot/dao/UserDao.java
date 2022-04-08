package web.crud_springboot.dao;

import web.crud_springboot.models.User;

import java.util.List;

public interface UserDao {

    void updateUser(User user);

    List<User> findAll();

    User getById(int id);

    void save(User user);

    void deleteById(int id);
}