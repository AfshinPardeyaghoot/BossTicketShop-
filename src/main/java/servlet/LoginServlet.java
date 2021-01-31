package servlet;

import dao.BookDao;
import dao.UserDao;
import entity.Book;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = req.getSession();
        String username = req.getParameter("username");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        httpSession.setAttribute("user", UserDao.getUserByUsername(username,entityManager));
        entityManager.getTransaction().commit();
        entityManager.close();
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }
}
