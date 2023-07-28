package servlet;

import DB.DBConn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addPost")
public class addPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("categories", DBConn.getCategories());
        req.getRequestDispatcher("addPost.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Long categoryId = Long.parseLong(req.getParameter("category_id"));

        DBConn.addPost(title, content,  categoryId);
        resp.sendRedirect("/home");
    }
}

