package DB;

import Model.Category;
import Model.Comment;
import Model.Post;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBConn {
    private static Connection connection;

    static{
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/JavaEE_FinalySprintTask",
                    "postgres",
                    "kenzo2015"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Post> getPost(){
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select p.id, p.content, p.post_date, p.title, c.name  from posts p  " +
                            "inner join posts_categories c on p.category_id = c.id");
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                Post post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setPostDate(resultSet.getDate("post_date"));
                post.setContent(resultSet.getString("content"));
                post.setTitle(resultSet.getString("title"));

                Category category =new Category();
                category.setName(resultSet.getString("name"));

                post.setCategory(category);
                posts.add(post);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static List<Category> getCategory(){
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement(
                    "select * from posts_categories order by id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return categories;
    }
    public static User getUserByEmail(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getString("role_id"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public static User getUSerById(Long id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from users where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into users(email, password, full_name, role_id ) "
                            + "values (?, ?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getRole());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Post getPostById(Long id) {
        Post post = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select p.id, p.post_date,c.name as cName ,p.title, p.content from posts p   " +
                            "inner join posts_categories c on p.category_id = c.id "
                            + " where p.id = ?" );

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setPostDate(resultSet.getDate("post_date"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));

                Category category = new Category();
                category.setName(resultSet.getString("cName"));
                post.setCategory(category);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select a.id, a.name from posts_categories a");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    public static void addPost(String title, String content,  Long categoryId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into posts(title, content,post_date , category_id) "
                            + "values (?,?,now(),?)");
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, categoryId);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "update users set "
                            + "email = ?, password = ?, full_name =? "
                            + "where id = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePostById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from posts where id=?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editPost(Post post) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "update posts set "
                            + " title = ?, content =? "
                            + "where id = ?");
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getContent());
            statement.setLong(3, post.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addComment(String comment, Long postId, Long userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into comments(comment, news_id, user_id, post_date) "
                            + "values (?, ?, ?, now())");
            statement.setString(1, comment);
            statement.setLong(2, postId);
            statement.setLong(3, userId);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> getCommentsByPostId(Long postId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(""
                    + "select * from comments where post_id = ?");
            statement.setLong(1, postId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPost(getPostById(postId));

                Long userId = resultSet.getLong("user_id_id");
                User user = getUSerById(userId);
                comment.setUser (user);

                LocalDateTime post_date = resultSet.getTimestamp("created_date").toLocalDateTime();

                comment.setPost_date(post_date);

                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
}
