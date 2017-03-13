package springmvc.java.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by canogjo on 09/03/2017.
 */
@Controller
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    // save a blog post
    // save a draft blog post

    // this method can be used inside a page
    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(
            @RequestParam(value="title") String title,
            @RequestParam(value="content") String content,
            @RequestParam(value="draft", required = false) boolean isDraft, Locale locale,
            Principal principal
            ) {
        BlogPost blogPost = new BlogPost();
        blogPost.setContent(content);
        blogPost.setBlogTitle(title);

        blogPost.setUser(userService.findUserWithBlogPostsByUsername(principal.getName()));

        if (isDraft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }
        return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved", null, locale));
    }

    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public ModelAndView blogPosts(Principal principal) {
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost> blogPosts = user.getBlogPosts();
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value ="/draftblogposts", method = RequestMethod.GET)
    public ModelAndView draftBlogPosts(Principal principal) {
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost> drafBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true);
        return new ModelAndView("blogposts", "blogposts", drafBlogPosts);
    }

    @RequestMapping(value = "/searchbytitle", method = RequestMethod.POST)
    public ModelAndView searchByTitle(@RequestParam(value = "title") String title, Principal principal) {
        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost> blogPosts = blogPostService.listAllBlogPostsByUserTitleLike(user, title);
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/getblogpostbyid/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostById(@PathVariable(value = "id") Long idBlogPost) {
        return blogPostService.findBlogPostById(idBlogPost);
    }
}
