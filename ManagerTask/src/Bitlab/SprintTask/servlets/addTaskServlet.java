package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.DBConnection;
import Bitlab.SprintTask.DB.dbManager;
import Bitlab.SprintTask.Entity.Task1.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-task")
public class addTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("t_name");
        String description = request.getParameter("t_description");
        String deadlineDate = request.getParameter("t_deadlineDate");
        String status = request.getParameter("t_status");
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setStatus(status);
        DBConnection.addTask(task);
        response.sendRedirect("/");
    }
}
