package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.BlogPost;

/**
 * Created by canogjo on 09/03/2017.
 */
public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {
}
