package com.manvydas.mentor.Dao;

import com.manvydas.mentor.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>() {
            {
                put(1, new User(1,"z","x"));
                put(2, new User(2, "Dalia", "Engineer"));
                put(3, new User(3, "Donald", "Trucker"));
            }
        };
    }
    public Collection<User> getAllUsers(){
        return this.users.values();
    }
}
