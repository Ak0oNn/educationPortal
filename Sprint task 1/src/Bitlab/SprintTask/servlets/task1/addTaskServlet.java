package Bitlab.SprintTask.servlets.task1;

import Bitlab.SprintTask.Entity.Task1.DBManagerTask1;
import Bitlab.SprintTask.Entity.Task1.SprintTask1Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-task")
public class addTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("addTask.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("t_name");
        String deadlineDate = request.getParameter("t_deadlineDate");
        String description = request.getParameter("t_description");

        DBManagerTask1.addTask(new SprintTask1Task(0, name, deadlineDate,description));

        response.sendRedirect("/");
    }
}
