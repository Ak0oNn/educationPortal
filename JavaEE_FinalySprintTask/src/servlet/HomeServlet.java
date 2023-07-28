package servlet;

import DB.DBConn;
import Model.Category;
import Model.Post;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List <Post> posts = DBConn.getPost();
        List <Category> categories = DBConn.getCategory();
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        if(user != null) {
            req.setAttribute("categories", categories);
            req.setAttribute("posts", posts);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
    }
}
