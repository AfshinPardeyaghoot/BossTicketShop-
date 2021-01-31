package dao;

import entity.Book;
import entity.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UserDao extends AbstractEntityDao<User, Integer> {
    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getClassType() {
        return User.class;
    }

    public static Boolean isValidUser(EntityManager entityManager , String username, String password) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);
        query.select(fromUser).where(criteriaBuilder.equal(
                fromUser.get("username"),
                username
        ));
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        User user = null ;
        try {
            user = typedQuery.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }

        entityManager.getTransaction().commit();

        if (user != null){
            System.out.println(user.getPassword());
            System.out.println(password);
            if (user.getPassword().equals(password))
                return true;
            else
                return false ;
        }
        else return false;
    }

    public static User getUserByUsername(String username,EntityManager entityManager){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> fromUser = criteriaQuery.from(User.class);
        criteriaQuery.select(fromUser).where(criteriaBuilder.equal(
                fromUser.get("username"),
                username
        ));
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
