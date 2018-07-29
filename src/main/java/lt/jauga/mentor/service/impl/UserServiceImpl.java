package lt.jauga.mentor.service.impl;

import lt.jauga.mentor.model.User;
import lt.jauga.mentor.repository.UserRepository;
import lt.jauga.mentor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return (List<User>)userRepository.findAll();
    };
}
