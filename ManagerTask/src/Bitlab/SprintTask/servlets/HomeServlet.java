package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.DBConnection;
import Bitlab.SprintTask.Entity.Task1.Task;
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
        List<Task> tasks = DBConnection.getTasks();
        request.setAttribute("task", tasks);
        request.getRequestDispatcher("task.jsp").forward(request,response);
    }
}
