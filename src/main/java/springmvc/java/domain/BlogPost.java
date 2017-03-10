package springmvc.java.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jose on 3/6/2017.
 */
@Entity
@Table(name = "blog_post")
public class BlogPost {

    @Id
    @SequenceGenerator(name = "blog_post_id_seq", sequenceName = "blog_post_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_post_id_seq")
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String blogTitle;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "publishdate", nullable = true)
    private Date publishDate;

    @Column(name = "draft")
    private boolean draft;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
