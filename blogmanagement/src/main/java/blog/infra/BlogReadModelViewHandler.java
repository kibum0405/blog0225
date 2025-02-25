package blog.infra;

import blog.config.kafka.KafkaProcessor;
import blog.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BlogReadModelViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private BlogReadModelRepository blogReadModelRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBlogRegistered_then_CREATE_1(
        @Payload BlogRegistered blogRegistered
    ) {
        try {
            if (!blogRegistered.validate()) return;

            // view 객체 생성
            BlogReadModel blogReadModel = new BlogReadModel();
            // view 객체에 이벤트의 Value 를 set 함
            blogReadModel.setName(blogRegistered.getName());
            // view 레파지 토리에 save
            blogReadModelRepository.save(blogReadModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
