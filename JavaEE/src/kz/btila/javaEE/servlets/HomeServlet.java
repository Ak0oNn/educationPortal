package kz.btila.javaEE.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.btila.javaEE.db.User;
import kz.btila.javaEE.db.userManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ArrayList<User> users = userManager.getUsers();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Users</title>");
        writer.print("</head>");
        writer.print("<body>");;
        writer.print("<form action = '/add-user' method = 'POST'>");
        writer.print(" NAME <input type='text' name = 'add_name'> <br><br>");
        writer.print(" SURNAME <input type='text' name = 'add_surname'> <br><br>");
        writer.print("DEPARTMENT");
        writer.print("<select name = 'add_department'>");
        writer.print("<option>IT</option>");
        writer.print("<option>HR</option>");
        writer.print("<option>PR</option>");
        writer.print("<option>MANAGEMENT</option>");
        writer.print("</select> <br> <br>");
        writer.print(" SALARY <input type='number' name = 'add_salary'> <br> <br>");
        writer.print("<button>ADD USER </button>");
        writer.print("<button action = '/delete-user' method = 'POST'>Delete</button>");
        writer.print("</form>");


        writer.print("<table padding = '20'>");
        writer.print("<thead>");
        writer.print("<tr>");
        writer.print("<th>NAME</th>");
        writer.print("<th>SURNAME</th>");
        writer.print("<th>DEPARTMENT</th>");
        writer.print("<th>SALARY</th>");
        writer.print("</tr>");
        writer.print("</thead>");
        writer.print("<tbody>");
        for (User u: users){
            writer.print("<tr>");
            writer.print("<td>"+u.getName()+"</td>");
            writer.print("<td>"+u.getSurname()+"</td>");
            writer.print("<td>"+u.getDepartment()+"</td>");
            writer.print("<td>"+u.getSalary()+"</td>");
            writer.print("</tr>");
        }
        writer.print("</tbody>");
        writer.print("</table>");
        writer.print("<body>");
        writer.print("</html>");
    }
}
