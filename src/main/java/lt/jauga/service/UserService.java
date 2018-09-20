package lt.jauga.service;

import lt.jauga.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    User save(User user);

    String findLoggedInUsername();

    @Query("select p from User p where p.username = :username and p.tenant = :tenant")
    User findByUsernameAndTenantname(@Param("username") String username, @Param("tenant") String tenant);

    Optional<User> findByUsername(String username);

    Collection<User> findAllOrderedByUsername();

    Collection<User> findAllByProfession(User user);
    Optional<User> findByEmail(String email);

}
