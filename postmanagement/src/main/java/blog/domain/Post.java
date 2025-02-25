package blog.domain;

import blog.PostmanagementApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Post_table")
@Data
//<<< DDD / Aggregate Root
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String postName;

    @Embedded
    private PostId postId;

    public static PostRepository repository() {
        PostRepository postRepository = PostmanagementApplication.applicationContext.getBean(
            PostRepository.class
        );
        return postRepository;
    }
}
//>>> DDD / Aggregate Root
