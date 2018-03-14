package com.manvydas.mentor.Service;

import com.manvydas.mentor.Dao.UserDao;
import com.manvydas.mentor.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
