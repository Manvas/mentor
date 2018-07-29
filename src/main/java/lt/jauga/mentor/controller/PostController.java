package lt.jauga.mentor.controller;

import lt.jauga.mentor.model.Post;
import lt.jauga.mentor.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Post> posts(){
        return postRepository.findAll().stream()
                .collect(Collectors.toList());
    }

}
