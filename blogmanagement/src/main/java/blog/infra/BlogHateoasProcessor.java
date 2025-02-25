package blog.infra;

import blog.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BlogHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Blog>> {

    @Override
    public EntityModel<Blog> process(EntityModel<Blog> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/blogadded")
                .withRel("blogadded")
        );

        return model;
    }
}
