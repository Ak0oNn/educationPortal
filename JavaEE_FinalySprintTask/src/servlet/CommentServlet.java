package servlet;

import DB.DBConn;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("comment");
        Long postId = Long.parseLong(req.getParameter("post_id"));
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        DBConn.addComment(comment, postId, user.getId());
        resp.sendRedirect("/details-post?id=" + postId);
    }
}
