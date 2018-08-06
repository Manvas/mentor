package lt.jauga.mentor.repository;

import lt.jauga.mentor.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }

    public List<User> findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.getNamedQuery("findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }

    public User save(User user) {
        Session session = this.sessionFactory.openSession();
        session.save(user);
        session.close();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findByEmailAndPassword(String email, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.getNamedQuery("findByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getResultList();
    }
}
