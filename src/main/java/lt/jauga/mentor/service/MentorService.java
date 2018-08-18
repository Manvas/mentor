package lt.jauga.mentor.service;

import lt.jauga.mentor.model.Mentor;
import lt.jauga.mentor.model.User;

import java.util.List;

public interface MentorService {
    void save(Mentor mentor);
    List<Mentor> findByProfession(String professionCode);
    List<Mentor> findAll();
    Mentor findByUserEmailAddress( String email );
    int findCount();
    Mentor findByUserId(int userId);
    void addMentor(User user);
}
