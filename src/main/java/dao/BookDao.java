package dao;

import entity.Book;

import javax.persistence.EntityManager;

public class BookDao extends AbstractEntityDao<Book, Integer> {
    public BookDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Book> getClassType() {
        return Book.class;
    }
}
