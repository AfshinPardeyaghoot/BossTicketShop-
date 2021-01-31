package servlet;

import dao.BookDao;
import entity.Book;
import entity.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String originCity = req.getParameter("origin_city") ;
        String destination = req.getParameter("destination_city");
        String date = req.getParameter("date");
        req.setAttribute("date",date);
        req.setAttribute("origin_city",originCity);
        req.setAttribute("destination_city",destination);

        if (date == ""){
            writer.println("<script>alert(\" لطفا تاریخ را وارد کنید \")</script>");
            req.getRequestDispatcher("search.jsp").include(req,resp);
        }
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> books = BookDao.getBooksByDateAndCity(date,destination,originCity,entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        books.sort(Comparator.comparing(Book::getHour));
        if (books != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("books",books);
            req.getRequestDispatcher("search.jsp").include(req,resp);
        }
        else {
            writer.println("<script>alert(\" سفری در تاریخ مشخص شده بین این شهر ها موجود نیست \")</script>");
            req.getRequestDispatcher("search.jsp").include(req,resp);
        }
    }
}
