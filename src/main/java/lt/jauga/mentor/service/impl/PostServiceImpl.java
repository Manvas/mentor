package lt.jauga.mentor.service.impl;

import lt.jauga.mentor.model.Post;
import lt.jauga.mentor.repository.PostRepository;
import lt.jauga.mentor.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAllPosts(){
        return (List<Post>)postRepository.findAll();
    }
}
