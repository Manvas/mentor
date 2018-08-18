package lt.jauga.mentor.controller;

import lt.jauga.mentor.helper.MentorInfo;
import lt.jauga.mentor.model.Mentor;
import lt.jauga.mentor.service.MentorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorSearchController {
    final static Logger logger = LoggerFactory.getLogger(MentorSearchController.class);

    @Autowired
    MentorService mentorService;

    @GetMapping(value="/mentor/count")
    public MentorInfo getMentorsCount(ModelMap model) {
        int count = mentorService.findCount();
        return new MentorInfo("All doctors count", count);
    }

    @RequestMapping(value="/mentor/{code}", method= RequestMethod.GET)
    public MentorInfo getBySpecialityCode(ModelMap model, @PathVariable("code") String code) {
        List<Mentor> mentors = mentorService.findByProfession(code);
        if(mentors == null) {
            return new MentorInfo("No Doctors found!", null);
        }
        return new MentorInfo("Doctors found", mentors);
    }

    @GetMapping(value="/mentor", produces="application/json")
    public MentorInfo findAll(ModelMap model) {

        List<Mentor> mentors = mentorService.findAll();
        if(mentors == null) {
            return new MentorInfo("No Doctors found!", null);
        }
        return new MentorInfo("Doctors found", mentors);
    }
}
