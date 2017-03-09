package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

import java.util.List;

/**
 * Created by Jose on 3/6/2017.
 */
public class MediumBlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MediumBlogPostServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("MediumBlogPostServiceImpl: savePost is called");
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {

    }

    @Override
    public void deletePost(BlogPost blogPost) {

    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean isDraft) {
        return null;
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserTitleLike(User user, String title) {
        return null;
    }

    @Override
    public BlogPost findBlogPostById(long id) {
        return null;
    }
}
