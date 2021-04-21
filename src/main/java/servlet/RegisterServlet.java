package servlet;

import dao.AccountDAOImpl;
import dao.AccountDao;
import entity.AccountBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        value = "/register"
)
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDao accountDao = new AccountDAOImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if (accountDao.ifExists(username)) {
            req.setAttribute("message", "Such username is already exists");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        else {
            AccountBean account = new AccountBean(username, password, email);
            accountDao.insertAccount(account);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
