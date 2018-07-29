package lt.jauga.mentor.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor

public class Comments {

    @Id @GeneratedValue
    private int commentID;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "userID")
    private int userID;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Category.class)
    @JoinColumn(name = "categoryID")
    private int categoryID;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Post.class)
    @JoinColumn(name = "postID")
    private int postID;

    @NonNull
    private String content;

    @CreatedDate
    private Date creationDate;
}
