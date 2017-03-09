package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;

/**
 * Created by Jose on 3/6/2017.
 */
public class WordpressBlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("WordpressBlogPostServiceImpl: savePost is called");
    }
}
