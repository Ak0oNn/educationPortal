package servlets;

import DB.DBAdmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Brand;
import model.Item;


import java.io.IOException;

@WebServlet(value = "/add-item")
public class addServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("i_name");
        double price = Double.parseDouble(req.getParameter("i_price"));
        String description = req.getParameter("i_description");
        long brandId = Long.parseLong(req.getParameter("brand_id"));
        Item item = new Item();
        Brand brand = DBAdmin.getBrandById(brandId);
        item.setName(name);
        item.setPrice(price);
        item.setDescription(description);
        item.setBrand(brand);
        DBAdmin.addItem(item);
        resp.sendRedirect("/admin.jsp");
    }
}
