package servlet;

import dao.DiscussionDao;
import dao.DiscussionDaoImpl;
import entity.DiscussionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/page"}
)
public class DisPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussionDao discussionDao = new DiscussionDaoImpl();
        Integer id = Integer.valueOf(req.getParameter("id")) ;
        DiscussionBean discussion = discussionDao.getDiscussion(id);
        System.out.println(id);
        req.getSession().setAttribute("discussion", discussion);
        req.getRequestDispatcher("discussion.jsp").forward(req, resp);
    }
}
