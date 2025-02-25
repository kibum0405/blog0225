package blog.infra;

import blog.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/blogs")
@Transactional
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(
        value = "/blogs/{id}/blogadded",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Blog blogAdded(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /blog/blogAdded  called #####");
        Optional<Blog> optionalBlog = blogRepository.findById(id);

        optionalBlog.orElseThrow(() -> new Exception("No Entity Found"));
        Blog blog = optionalBlog.get();
        blog.blogAdded();

        blogRepository.save(blog);
        return blog;
    }
}
//>>> Clean Arch / Inbound Adaptor
