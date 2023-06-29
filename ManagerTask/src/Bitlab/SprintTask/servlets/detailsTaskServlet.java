package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.DBConnection;
import Bitlab.SprintTask.Entity.Task1.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/details-task")
public class detailsTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Task task = DBConnection.getTaskById(id);
        req.setAttribute("task", task);
        req.getRequestDispatcher("details.jsp").forward(req, resp);
    }
}
