package lt.jauga.mentor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="user")
@NamedQueries({
        @NamedQuery(
                name = "findByEmail",
                query = "from User u where u.email = :email"
        ),
        @NamedQuery(
                name = "findByEmailAndPassword",
                query = "from User u where u.email= :email and u.password = :password"
        ),
})
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private int role;
    @Column(name = "first_name") private String firstname;
    @Column(name = "last_name") private String lastname;
    @Column(name = "create_time") private Timestamp createTime;
    @Column(name = "last_updated") private Timestamp lastUpdated;
}
