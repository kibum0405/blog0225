package blog.infra;

import blog.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "blogReadModels",
    path = "blogReadModels"
)
public interface BlogReadModelRepository
    extends PagingAndSortingRepository<BlogReadModel, Long> {}
