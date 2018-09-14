package lt.jauga.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Getter @Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Netinkamas El. Pašto formatas")
    @NotEmpty(message = "*Įrašykite El. Paštą")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Slaptažodis turi turėti bent 5 simbolius")
    @NotEmpty(message = "*Įrašykite slaptažodį")
    @JsonIgnore
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "*Slapyvardis turi turėti bent 5 simbolius")
    @NotEmpty(message = "*Įrašykite slapyvardį")
    private String username;

    @Column(name = "name")
    @NotEmpty(message = "*Įrašykite savo vardą")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Įrašykite savo pavardę")
    private String lastName;

    @Column(name = "profession")
    @NotEmpty(message = "*Pasirinkite savo profesija")
    private String profession;

    @Column(name = "active", nullable = false)
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;
}
