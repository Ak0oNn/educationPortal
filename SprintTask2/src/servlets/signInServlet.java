package servlets;

import DB.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
@WebServlet(value = "/sign-user")
public class signInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        if(user == null){
            req.getRequestDispatcher("/signIn.jsp").forward(req,resp);
        }
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/sign-user?emailerror";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = DBConnector.getUser(email);
        if(user!=null){
            redirect = "/sign-user?passworderror";
            if(user.getPassword().equals(password)){
                redirect = "/profile";
                req.getSession().setAttribute("CURRENT_USER", user);
            }
        }
        resp.sendRedirect(redirect);
    }
}
