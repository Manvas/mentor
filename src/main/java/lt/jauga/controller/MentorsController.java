package lt.jauga.controller;

import lt.jauga.domain.Post;
import lt.jauga.domain.User;
import lt.jauga.service.PostService;
import lt.jauga.service.UserService;
import lt.jauga.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@Controller
public class MentorsController {
    UserService userService;

    @Autowired
    public MentorsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/mentors", method = RequestMethod.GET)
    public String MentorList(Model model, Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        Collection<User> users = userService.findAllByProfession(user.get());
        model.addAttribute("users", users);
        return "/mentors";
    }
}
