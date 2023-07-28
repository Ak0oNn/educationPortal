package servlets;

import DB.DBAdmin;
import DB.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Brand;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/brand")
public class BrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = DBAdmin.getBrand();
        req.setAttribute("brand", brands);
        req.getRequestDispatcher("brand.jsp").forward(req,resp);
    }
}
