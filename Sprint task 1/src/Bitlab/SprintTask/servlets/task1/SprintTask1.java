package Bitlab.SprintTask.servlets.task1;

import Bitlab.SprintTask.Entity.Task1.DBManagerTask1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/Task1")

public class SprintTask1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Task", DBManagerTask1.getTasks());
        request.getRequestDispatcher("manager.jsp").forward(request, response);
    }
}
