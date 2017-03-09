package springmvc.java.service;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

/**
 * Created by Jose on 3/6/2017.
 */
public interface BlogPostService {

    void savePost(BlogPost blogPost);
    void saveAsDraft(BlogPost blogPost);
    void deletePost(BlogPost blogPost);
    List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean isDraft);
    List<BlogPost> listAllBlogPostsByUserTitleLike(User user, String title);
    BlogPost findBlogPostById(long id);
}
