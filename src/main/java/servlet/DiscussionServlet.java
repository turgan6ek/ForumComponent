package servlet;

import dao.AccountDAOImpl;
import dao.AccountDao;
import dao.DiscussionDao;
import dao.DiscussionDaoImpl;
import entity.AccountBean;
import entity.DiscussionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.lang.Integer.valueOf;

@WebServlet(
        value = "/discussion"
)
public class DiscussionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussionDao discussionDao = new DiscussionDaoImpl();
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        int userID = Integer.parseInt(req.getParameter("userid"));
        DiscussionBean discussion = new DiscussionBean(userID, body, title, new Date(), 0, 0);
        discussionDao.insertDiscussion(discussion);
        req.getRequestDispatcher("forum.jsp").forward(req,resp);
    }
}
