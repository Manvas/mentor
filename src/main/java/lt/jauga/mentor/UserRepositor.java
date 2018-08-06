package lt.jauga.mentor;

import lt.jauga.mentor.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositor extends CrudRepository<User, Long> {

}
