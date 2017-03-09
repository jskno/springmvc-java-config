package springmvc.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by canogjo on 09/03/2017.
 */
@Controller
public class DatabaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/displayPostgresqlUsers")
    public void displayUsers() {

        jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM USER");
        users.stream().forEach(user -> LOGGER.debug("Postgresql username: " + user.get("username")));

    }
}
