package lt.jauga.mentor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name="mentor")
@NamedQueries({
        @NamedQuery(
                name = "findByProfession",
                query = "from Mentor u where u.professionCode = :professionCode"
        ),
        @NamedQuery(
                name = "findAll",
                query = "from Mentor"
        ),
        @NamedQuery(
                name = "findAllCount",
                query = "select count(d) from Mentor d"
        ),
        @NamedQuery(
                name = "findById",
                query = "from Mentor d where d.user.id = :id"
        ),
})
@Getter @Setter
public class Mentor implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "profession_code")
    private String professionCode;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}