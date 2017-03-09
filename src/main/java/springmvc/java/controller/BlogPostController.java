package springmvc.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;

/**
 * Created by canogjo on 09/03/2017.
 */
@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // save a blog post
    // save a draft blog post

    // this method can be used inside a page
    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(
            @RequestParam(value="title") String title,
            @RequestParam(value="content") String content,
            @RequestParam(value="draft", required = false) boolean isDraft
            ) {
        BlogPost blogPost = new BlogPost();
        blogPost.setContent(content);
        blogPost.setBlogTitle(title);
        if (isDraft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }
        return new ModelAndView("newBlogpost", "message", "Blog Post is saved");

    }
}
