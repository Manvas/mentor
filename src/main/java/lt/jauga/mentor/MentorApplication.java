package lt.jauga.mentor;

import lt.jauga.mentor.model.Post;
import lt.jauga.mentor.repository.PostRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.stream.Stream;

@EnableResourceServer
@SpringBootApplication
public class MentorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorApplication.class, args);
	}

	@Bean
	ApplicationRunner init (PostRepository postRepository){
		return args -> {
			Stream.of("pirmas","antras","trecias","ketvirs").forEach(title -> {
				Post post = new Post();
				post.setTitle(title);
				postRepository.save(post);
			});
			postRepository.findAll().forEach(System.out::println);
		};
	}
}
