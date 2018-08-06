package lt.jauga.mentor.service;

import lt.jauga.mentor.exception.UserCredentialsUnmatchException;
import lt.jauga.mentor.exception.UserNotFoundException;
import lt.jauga.mentor.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User doesUserExist(String email) throws UserNotFoundException;
    User isValidUser(String email, String password) throws UserCredentialsUnmatchException;
    User getByEmail(String email) throws UserNotFoundException;
    User save(User user);

}
