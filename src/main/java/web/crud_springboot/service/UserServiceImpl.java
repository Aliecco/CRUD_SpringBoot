package web.crud_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.crud_springboot.dao.UserDao;
import web.crud_springboot.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(int id){
        return userDao.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user){
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int id){
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
