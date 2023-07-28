package servlet;

import DB.DBConn;
import Model.Post;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/details-post")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Post post = DBConn.getPostById(id);
        req.setAttribute("comments", DBConn.getCommentsByPostId(id));
        req.setAttribute("new", post);
        req.getRequestDispatcher("details.jsp").forward(req,resp);
    }
}
