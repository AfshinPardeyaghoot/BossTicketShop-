package servlet;

import dao.TicketDao;
import entity.Book;
import entity.Ticket;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Integer ticketId = Integer.valueOf(req.getParameter("btnValue"));
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TicketDao ticketDao = new TicketDao(entityManager);
        Ticket ticket = ticketDao.load(ticketId);
        Book book = ticket.getBookId() ;
        req.setAttribute("date",book.getDate());
        req.setAttribute("hour",String.valueOf(book.getHour()));
        req.setAttribute("minute",String.valueOf(book.getMinute()));
        req.setAttribute("ownerName",ticket.getOwnerName());
        req.setAttribute("gender",ticket.getGender());
        req.setAttribute("bookid",String.valueOf(book.getId()));
        req.setAttribute("ticketid",String.valueOf(ticket.getId()));
        req.setAttribute("des-city",book.getDestinationCity());
        req.setAttribute("org-city",book.getOriginCity());
        req.getRequestDispatcher("showticket.jsp").forward(req,resp);

    }
}
