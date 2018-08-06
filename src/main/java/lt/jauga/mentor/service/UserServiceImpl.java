package lt.jauga.mentor.service;

import lt.jauga.mentor.exception.UserCredentialsUnmatchException;
import lt.jauga.mentor.exception.UserNotFoundException;
import lt.jauga.mentor.model.User;
import lt.jauga.mentor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User doesUserExist(String email) throws UserNotFoundException {
        List<User> users = (List<User>) userRepository.findByEmail(email);
        if(users.size() == 0) {
            throw new UserNotFoundException("User does not exists.");
        }
        return users.get(0);
    }

    @Override
    public User isValidUser(String email, String password) throws UserCredentialsUnmatchException {
        List<User> users = (List<User>) userRepository.findByEmailAndPassword(email, password);
        if(users == null || users.size() == 0) {
            throw new UserCredentialsUnmatchException("Email or password is wrong.");
        }
        return users.get(0);
    }

    @Override
    public User getByEmail(String email) throws UserNotFoundException {
        return this.doesUserExist(email);
    }
}
