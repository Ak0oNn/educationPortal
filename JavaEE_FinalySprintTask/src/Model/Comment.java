package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private long id;
    private String comment;
    private LocalDateTime Post_date;
    private User user;
    private Post post;

    public Comment() {
    }

    public Comment(long id, String comment, LocalDateTime post_date, User user, Post post) {
        this.id = id;
        this.comment = comment;
        Post_date = post_date;
        this.user = user;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getPost_date() {
        return Post_date;
    }

    public void setPost_date(LocalDateTime post_date) {
        Post_date = post_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
