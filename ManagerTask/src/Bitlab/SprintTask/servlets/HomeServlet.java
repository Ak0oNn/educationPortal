package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.dbManager;
import Bitlab.SprintTask.Entity.Task1.model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<model> tasks = dbManager.getTasks();
        request.setAttribute("task", tasks);
        request.getRequestDispatcher("task.jsp").forward(request,response);
    }
}
