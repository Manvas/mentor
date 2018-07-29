package lt.jauga.mentor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @NonNull @Email
    private String email;

    @NonNull
    @JsonIgnore
    private String password;

    /*@NonNull
    private int active;*/

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Role.class)
    private List<Role> roles;

    @CreatedDate
    private Date creationDate;
}
