package lt.jauga.mentor.repository;

import lt.jauga.mentor.model.Mentor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MentorRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public MentorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Mentor> findByProfessionCode(String code) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Mentor> query = session.getNamedQuery("findByProfession");
        query.setParameter("professionCode", code);
        List<Mentor> mentors = query.getResultList();
        return mentors;
    }


    public Mentor findByUserId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Mentor> query = session.getNamedQuery("findById");
        query.setParameter("id", userId);
        List<Mentor> mentors = query.getResultList();
        return mentors.get(0);
    }


    public List<Mentor> findByLocation(String location) {
        return null;
    }

    public List<Mentor> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Mentor> query = session.getNamedQuery("findAll");
        List<Mentor> mentors = query.getResultList();
        return mentors;
    }

    public int findAllCount() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Number> query = session.getNamedQuery("findAllCount");
        int count = ((Number)query.getSingleResult()).intValue();
        return count;
    }

    public Mentor save(Mentor mentor) {
        Session session = this.sessionFactory.openSession();
        session.save(mentor);
        session.close();
        return mentor;
    }
}
