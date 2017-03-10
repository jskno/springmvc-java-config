package springmvc.java.service;

import springmvc.java.domain.User;

/**
 * Created by canogjo on 10/03/2017.
 */
public interface UserService {

    User findUserById(long id);
    User findUserWithBlogPostsByUsername(String username);
}
