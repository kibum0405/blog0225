package blog.domain;

import blog.domain.*;
import blog.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BlogRegistered extends AbstractEvent {

    private Long id;
    private String name;

    public BlogRegistered(Blog aggregate) {
        super(aggregate);
    }

    public BlogRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
