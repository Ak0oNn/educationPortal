package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.DBConnection;
import Bitlab.SprintTask.Entity.Task1.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/edit-task")
public class editTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("adfsadasd");
        int id = Integer.parseInt(req.getParameter("t_id"));
        String name = req.getParameter("t_name");
        String description = req.getParameter("t_description");
        String deadlineDate = req.getParameter("t_deadlineDate");
        String status = req.getParameter("t_status");
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setStatus(status);
        DBConnection.editTask(task);
        resp.sendRedirect("/details-task?id="+id);
    }
}
