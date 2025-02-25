package blog.domain;

import blog.BlogmanagementApplication;
import blog.domain.BlogRegistered;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Blog_table")
@Data
//<<< DDD / Aggregate Root
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> visitName;

    @ElementCollection
    private List<PostId> postId;

    @PostPersist
    public void onPostPersist() {
        BlogRegistered blogRegistered = new BlogRegistered(this);
        blogRegistered.publishAfterCommit();
    }

    public static BlogRepository repository() {
        BlogRepository blogRepository = BlogmanagementApplication.applicationContext.getBean(
            BlogRepository.class
        );
        return blogRepository;
    }

    //<<< Clean Arch / Port Method
    public void blogAdded() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
