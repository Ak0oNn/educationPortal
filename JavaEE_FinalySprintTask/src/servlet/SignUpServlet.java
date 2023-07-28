package servlet;

import DB.DBConn;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/sign-up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re_password");
        String fullName = req.getParameter("full_name");
        String role = req.getParameter("role");

        String redirect = "/sign-user?err-email";
        User user = DBConn.getUserByEmail(email);

        User signUpUser = new User();
        signUpUser.setEmail(email);
        signUpUser.setFullName(fullName);
        signUpUser.setRole(role);
        signUpUser.setPassword(password);
        if (user == null) {
            if (password.equals(rePassword)) {
                DBConn.addUser(signUpUser);
                redirect = "/sign-user?success";
            }
        }
        resp.sendRedirect(redirect);
    }
}

