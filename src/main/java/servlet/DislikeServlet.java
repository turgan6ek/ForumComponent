package servlet;

import dao.DiscussionDao;
import dao.DiscussionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/dislike"})
public class DislikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussionDao dao = new DiscussionDaoImpl();
        Integer id = Integer.valueOf(req.getParameter("id"));
        dao.dislike(id);
        req.getRequestDispatcher("discussion.jsp").forward(req, resp);
    }
}
