package filter;

import dao.UserDao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        if (username == "" || password == ""){
            writer.println("<script>alert(\" لطفا نام کاربری و رمز ورود را وارد کنید \")</script>");
            request.getRequestDispatcher("index.jsp").include(request,response);
        }
        else {
            if (UserDao.isValidUser(entityManager,username,password)){
                writer.println("<script>alert(\" ورود با موفقیت انجام شد \")</script>");
                filterChain.doFilter(request,response);
            }
            else {
                writer.println("<script>alert(\" نام کاربری یا رمز ورود اشتباه است!! \")</script>");
                request.getRequestDispatcher("index.jsp").include(request,response);
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void destroy() {

    }
}
