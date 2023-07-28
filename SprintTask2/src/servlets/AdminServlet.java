package servlets;

import DB.DBAdmin;
import DB.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Brand;
import model.Item;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin-panel")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = DBAdmin.getAdmin();
        List<Brand> brands = DBAdmin.getBrand();
        req.setAttribute("brands", brands);
        req.setAttribute("items", items);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
