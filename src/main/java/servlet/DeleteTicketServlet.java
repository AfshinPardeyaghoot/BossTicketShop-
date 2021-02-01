package servlet;

import dao.TicketDao;
import entity.Ticket;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(req.getParameter("ticket_id"));
        Integer tickectId = Integer.valueOf(req.getParameter("ticket_id"));
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TicketDao ticketDao = new TicketDao(entityManager);
        Ticket ticket = TicketDao.deleteTicket(tickectId,entityManager);
        ticket.setDeleted(true);
        ticketDao.update(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();
        PrintWriter writer = resp.getWriter();
        writer.println("<script>\"  بلیط با موفقیت لغو شد \"</script>");
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }
}
