package lt.jauga.mentor.service;

import lt.jauga.mentor.exception.UserNotFoundException;
import lt.jauga.mentor.model.Mentor;
import lt.jauga.mentor.model.User;
import lt.jauga.mentor.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService{

    private MentorRepository mentorRepository;
    private UserService userService;

    public MentorServiceImpl(MentorRepository mentorRepository, UserService userService) {
        this.mentorRepository = mentorRepository;
        this.userService = userService;
    }

    @Override
    public void save(Mentor mentor) {
        mentorRepository.save(mentor);
    }

    @Override
    public List<Mentor> findByProfession(String professionCode) {
        return mentorRepository.findByProfessionCode(professionCode);
    }

    @Override
    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor findByUserEmailAddress(String email) {
        User user = null;
        try {
            user = userService.getByEmail(email);
        } catch (UserNotFoundException e) {
            return null;
        }
        return this.findByUserId(user.getId());
    }

    @Override
    public int findCount() {
        return mentorRepository.findAllCount();
    }

    @Override
    public Mentor findByUserId(int userId) {
        return mentorRepository.findByUserId(userId);
    }

    @Override
    public void addMentor(User user) {
        if(user.getRole() == 1)
        {
            Mentor mentor = new Mentor();
            mentor.setUser(user);
            mentor.setProfessionCode("MENTOR");
            mentorRepository.save(mentor);
        }
    }
}
