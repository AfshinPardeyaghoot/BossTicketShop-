package dao;

import javax.persistence.EntityManager;


public abstract class AbstractEntityDao<T, U> {


    private EntityManager entityManager;


    public AbstractEntityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T load(U id) {
        return entityManager.find(getClassType(), id);
    }

    public void save(T t) {
        entityManager.persist(t);
    }

    public void delete(T t) {
        entityManager.remove(t);
    }

    public void update(T t) {
        entityManager.merge(t);
    }

    public abstract Class<T> getClassType();

}
