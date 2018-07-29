package lt.jauga.mentor.repository;

import lt.jauga.mentor.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
