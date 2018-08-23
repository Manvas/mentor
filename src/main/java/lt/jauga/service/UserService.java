package lt.jauga.service;

import lt.jauga.domain.Post;
import lt.jauga.domain.User;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);

    Collection<User> findAllOrderedByUsername();
}
