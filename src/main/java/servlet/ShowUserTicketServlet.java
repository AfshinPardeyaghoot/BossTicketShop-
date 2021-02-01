package servlet;

import dao.TicketDao;
import entity.Ticket;
import entity.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowUserTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Ticket> tickets = TicketDao.getAllTicketOfUser(user,entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        httpSession.setAttribute("tickets",tickets);
        req.getRequestDispatcher("showAllTicket.jsp").forward(req,resp);

    }
}
