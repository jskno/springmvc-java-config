package springmvc.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springmvc.java.dao.UserDAO;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

/**
 * Created by canogjo on 10/03/2017.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User findUserById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findUserWithBlogPostsByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }
}
