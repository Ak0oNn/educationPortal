package Bitlab.SprintTask.servlets.task1;

import Bitlab.SprintTask.Entity.Task1.DBManagerTask1;
import Bitlab.SprintTask.Entity.Task1.SprintTask1Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/save-task")
public class saveTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("t_name");
        String deadLineDead = request.getParameter("t_deadlineDate");
        String status = request.getParameter("t_status");


        DBManagerTask1.getTask(new SprintTask1Task(id,name,deadLineDead,status));
        response.sendRedirect("/");
    }
}
