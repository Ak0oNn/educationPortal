package kz.btila.javaEE.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.btila.javaEE.db.User;
import kz.btila.javaEE.db.userManager;

import java.io.IOException;

@WebServlet (value = "/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("add_name");
        String surname = request.getParameter("add_surname");
        String department = request.getParameter("add_department");
        String salary = request.getParameter("add_salary");

        int userSalary= Integer.parseInt(salary);

        User user = new User();
        user.setName(name);
        user.setSalary(userSalary);
        user.setDepartment(department);
        user.setSurname(surname);
        userManager.addUser(user);

        response.sendRedirect("/");

    }
}
