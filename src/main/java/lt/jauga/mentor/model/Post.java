package lt.jauga.mentor.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue
    private int postID;

    @ManyToOne (cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn (name = "userID")
    private int userID;

    @NonNull
    private String Title;

    private String subTitle;

    private String content;

    @CreatedDate
    private Date creationDate;
}
