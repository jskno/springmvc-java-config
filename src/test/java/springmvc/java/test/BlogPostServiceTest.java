package springmvc.java.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import springmvc.java.config.WebConfig;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

/**
 * Created by canogjo on 13/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={WebConfig.class}, loader= AnnotationConfigWebContextLoader.class)
public class BlogPostServiceTest {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @Test
    public void savePostTitle() {
        BlogPost blogPost = new BlogPost();
        User user = userService.findUserWithBlogPostsByUsername("user");

        Assert.assertNotNull(user);

        blogPost.setBlogTitle("Test Title1");
        blogPost.setContent("Test Content1");
        blogPost.setUser(user);

        blogPostService.savePost(blogPost);
        Assert.assertTrue(blogPostService.listAllBlogPostsByUserTitleLike(user, "Test Title1").size() == 1);

        blogPostService.deletePost(blogPost);
        Assert.assertTrue(blogPostService.listAllBlogPostsByUserTitleLike(user, "Test Title1").size() == 0);

    }

    @Test
    public void saveAsDraftTest() {
        BlogPost draftBlogPost = new BlogPost();
        User user = userService.findUserWithBlogPostsByUsername("user");

        Assert.assertNotNull(user);

        draftBlogPost.setBlogTitle("Test Draft Title1");
        draftBlogPost.setContent("Test Draft Content1");
        draftBlogPost.setUser(user);

        blogPostService.saveAsDraft(draftBlogPost);
        Assert.assertTrue(blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true).size() > 0);

        blogPostService.deletePost(draftBlogPost);
        Assert.assertTrue(blogPostService.listAllBlogPostsByUserTitleLike(user, "Test Draft Title1").size() == 0);


    }
}
