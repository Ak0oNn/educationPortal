package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.DBConnection;
import Bitlab.SprintTask.DB.dbManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete-task")
public class deleteTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DBConnection.deleteTaskById(id);
        resp.sendRedirect("/");
    }
}
