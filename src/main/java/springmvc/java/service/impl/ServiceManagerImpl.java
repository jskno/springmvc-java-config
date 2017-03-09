package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.ServiceManager;

/**
 * Created by Jose on 3/6/2017.
 */
public class ServiceManagerImpl implements ServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManagerImpl.class);

    @Autowired
    @Qualifier("WordpressBlogPostService")
    private BlogPostService blogPostService;

    @Override
    public void sendBlogPost(BlogPost blogPost) {
        LOGGER.debug("ServiceManagerImpl: sendBlogPost is called");
        blogPostService.savePost(blogPost);
    }
}
