package web.crud_springboot.service;

import web.crud_springboot.models.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(int id);

    void updateUser(User user);
}
