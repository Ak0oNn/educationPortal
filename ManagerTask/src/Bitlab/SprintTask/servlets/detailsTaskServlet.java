package Bitlab.SprintTask.servlets;

import Bitlab.SprintTask.DB.dbManager;
import Bitlab.SprintTask.Entity.Task1.model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/details-task")
public class detailsTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("t_name");
        String description = req.getParameter("t_description");
        String deadLineDead = req.getParameter("t_deadLineDate");
        String status = req.getParameter("t_status");


        dbManager.getTask(new model(id,name,description,deadLineDead,status));
        resp.sendRedirect("/");

    }
}
