package dao;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao extends AbstractEntityDao<User, Integer> {
    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getClassType() {
        return User.class;
    }

    public Boolean isValidUser(EntityManager entityManager, String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);
        query.select(fromUser).where(criteriaBuilder.equal(
                fromUser.get("username"),
                username
        ));
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        User user = typedQuery.getSingleResult();
        if (user.getPassword() == password)
            return true;
        else return false;
    }
}
