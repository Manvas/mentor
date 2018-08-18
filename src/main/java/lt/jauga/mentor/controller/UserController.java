package lt.jauga.mentor.controller;

import lt.jauga.mentor.exception.UserNotFoundException;
import lt.jauga.mentor.helper.ExecStatus;
import lt.jauga.mentor.model.User;
import lt.jauga.mentor.service.MentorService;
import lt.jauga.mentor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;
    MentorService mentorService;

    @Autowired
    public UserController(UserService userService, MentorService mentorService) {
        this.userService = userService;
        this.mentorService = mentorService;
    }

    @GetMapping(value="/token")
    public Map<String, String> getToken(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

    @PostMapping(value="/signup")
    public ExecStatus processSignup(ModelMap model, @RequestBody User reqUser) {
        User user = null;
        try {
            user = userService.doesUserExist(reqUser.getEmail());
        } catch (UserNotFoundException e) {
        }
        if(user != null) {
            return new ExecStatus("USER_ACCOUNT_EXISTS", "User account with same email address exists. Please try again!");
        }
        user = new User();
        user.setEmail(reqUser.getEmail());
        user.setPassword(reqUser.getPassword());
        user.setLastname(reqUser.getLastname());
        user.setRole(reqUser.getRole());
        User persistedUser = userService.save(user);
        //
        // Add entry in doctor table if user is a doctor
        //
        mentorService.addMentor(user);

        return new ExecStatus("USER_ACCOUNT_CREATED", "User account successfully created");
    }

    @PostMapping(value="/user/update")
    public ExecStatus updateUser(ModelMap model, @RequestBody User reqUser) {
        User user = new User();
        user.setId(reqUser.getId());

        user.setLastname(reqUser.getLastname());
        userService.update(user);
        return new ExecStatus("USER_ACCOUNT_UPDATED", "User account successfully updated");
    }

    @PostMapping(value="/update", produces="application/json")
    public ModelAndView updateProfile(ModelMap model, @RequestParam("firstName") String firstName,
                                      @RequestParam("lastName") String lastName, @RequestParam("address") String address,
                                      @RequestParam("contact_number") String contactNumber) {
        return new ModelAndView("update", model);
    }

    @PostMapping(value="/forgotpassword/process", produces="application/json")
    public ModelAndView processForgotPassword(ModelMap model, @RequestParam("emailaddress") String email) {

        User user = null;
        try {
            user = userService.doesUserExist(email);
        } catch (UserNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(user != null) {

        }
        model.addAttribute("message", "An email notification is sent to the registered email address.");
        return new ModelAndView("forgotpassword", model);
    }
}