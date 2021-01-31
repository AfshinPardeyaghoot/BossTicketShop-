package servlet;

import com.mysql.cj.xdevapi.DatabaseObject;
import dao.TicketDao;
import entity.Book;
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

public class BuyTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = req.getSession();
        Integer bookId = (Integer) httpSession.getAttribute("bookId");
        List<Book> books = (List<Book>)httpSession.getAttribute("books");
        Book book = books.stream().filter(book1 -> book1.getId().equals(bookId)).findFirst().get() ;
        User user = (User) httpSession.getAttribute("user");
        String ownerName = req.getParameter("ownerName");
        String gender = req.getParameter("gender");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TicketDao ticketDao = new TicketDao(entityManager);
        Ticket ticket = new Ticket();
        ticket.setBookId(book);
        ticket.setGender(gender);
        ticket.setOwnerName(ownerName);
        ticket.setUserId(user);
        ticket.setDeleted(false);
        ticketDao.save(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
