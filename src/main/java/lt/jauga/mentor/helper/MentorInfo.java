package lt.jauga.mentor.helper;

import lt.jauga.mentor.model.Mentor;

import java.util.List;

public class MentorInfo {
    private String message;
    private List<Mentor> mentors;
    int count;

    public MentorInfo(String message, List<Mentor> mentors) {
        this.message = message;
        this.mentors = mentors;
    }

    public MentorInfo(String message, int count) {
        this.message = message;
        this.count = count;
    }
}
