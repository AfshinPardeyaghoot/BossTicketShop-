package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ConfirmFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Integer bookId =Integer.valueOf(req.getParameter("btnValue"));
        System.out.println(bookId);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("bookId",bookId);
        req.getRequestDispatcher("ConfirmForm.jsp").forward(req,resp);
    }
}
