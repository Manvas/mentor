package lt.jauga.mentor.service;

import lt.jauga.mentor.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    List<User> findAllUsers();
}
