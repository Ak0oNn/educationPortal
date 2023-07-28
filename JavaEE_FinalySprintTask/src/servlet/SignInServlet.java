package servlet;

import DB.DBConn;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/sign-user")
public class SignInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        if(user == null){
            req.getRequestDispatcher("/signIn.jsp").forward(req,resp);
        }
        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/sign-user?emailerror";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = DBConn.getUserByEmail(email);
        if(user!=null){
            redirect = "/sign-user?passworderror";
            if(user.getPassword().equals(password)){
                redirect = "/home";
                req.getSession().setAttribute("CURRENT_USER", user);
            }
        }
        resp.sendRedirect(redirect);
    }
}
