package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.service.EmailService;

/**
 * Created by Jose on 3/6/2017.
 */
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail() {
        LOGGER.debug("EmailServiceImpl: sendEmail is called");

    }
}
