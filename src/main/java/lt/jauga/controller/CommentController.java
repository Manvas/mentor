package lt.jauga.controller;

import lt.jauga.domain.Comment;
import lt.jauga.domain.Post;
import lt.jauga.domain.User;
import lt.jauga.service.CommentService;
import lt.jauga.service.PostService;
import lt.jauga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


public class CommentController {


}
