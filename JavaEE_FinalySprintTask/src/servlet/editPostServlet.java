package servlet;

        import DB.DBConn;
        import Model.Post;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import java.io.IOException;

@WebServlet (value = "/edit-post")
public class editPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        DBConn.editPost(post);
        resp.sendRedirect("/home?id="+id);
    }
}

