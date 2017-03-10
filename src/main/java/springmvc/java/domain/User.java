package springmvc.java.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by canogjo on 09/03/2017.
 */
@Entity
@Table(name = "USERR")
public class User {

    @Id
    @SequenceGenerator(name = "userr_id_seq", sequenceName = "userr_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userr_id_seq")
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<BlogPost> blogPosts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}
