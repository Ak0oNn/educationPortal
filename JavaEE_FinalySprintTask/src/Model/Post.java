package Model;

import java.util.Date;

public class Post {
    private long id;
    private Date postDate;
    private Category category;
    private String title;
    private String content;

    public Post() {
    }

    public Post(long id, Date postDate, Category category, String title, String content) {
        this.id = id;
        this.postDate = postDate;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
