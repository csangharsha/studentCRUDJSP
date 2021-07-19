package np.edu.cite.controller;

import np.edu.cite.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.VIEW_PATH + "login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // get user data from db
        if("admin@gmail.com".equalsIgnoreCase(email) && "admin".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(Constants.LOGIN_SESSION, true);
            resp.sendRedirect(req.getContextPath() + "/students");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?error");
        }

    }
}
