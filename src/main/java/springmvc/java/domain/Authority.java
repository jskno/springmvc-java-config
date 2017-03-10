package springmvc.java.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by canogjo on 09/03/2017.
 */
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @SequenceGenerator(name = "authorities_id_seq", sequenceName = "authorities_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_id_seq")
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "authority", nullable = false)
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
