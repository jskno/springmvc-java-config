package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.User;

/**
 * Created by canogjo on 10/03/2017.
 */
public interface UserDAO extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}
