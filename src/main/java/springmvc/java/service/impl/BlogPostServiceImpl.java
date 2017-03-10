package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

import java.util.Date;
import java.util.List;

/**
 * Created by Jose on 3/6/2017.
 */
public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    BlogPostDAO blogPostDAO;

    @Override
    public void savePost(BlogPost blogPost) {
        LOGGER.debug("BlogPostServiceImpl: savePost is called");
        blogPost.setPublishDate(new Date());
        blogPostDAO.save(blogPost);
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {
        LOGGER.debug("BlogPostServiceImpl: saveAsDraft is called");
        blogPost.setDraft(true);
        blogPostDAO.save(blogPost);
    }

    @Override
    public void deletePost(BlogPost blogPost) {
        blogPostDAO.delete(blogPost);
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean isDraft) {

        return blogPostDAO.findAllBlogPostsByUserAndDraft(user, isDraft);
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserTitleLike(User user, String title) {
        return blogPostDAO.findAllBlogPostsByUserAndBlogTitleContaining(user, title);
    }

    @Override
    public BlogPost findBlogPostById(long id) {
        return blogPostDAO.findOne(id);
    }
}
