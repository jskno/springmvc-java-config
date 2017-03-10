package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

/**
 * Created by canogjo on 09/03/2017.
 */
public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

    List<BlogPost> findAllBlogPostsByUserAndBlogTitleContaining(User user, String blogTitle);
    List<BlogPost> findAllBlogPostsByUserAndDraft(User user, boolean draft);
}
