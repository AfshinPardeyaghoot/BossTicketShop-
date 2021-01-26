package dao;

import javax.persistence.EntityManager;

public class City extends AbstractEntityDao<City, Integer> {

    public City(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getClassType() {
        return City.class;
    }
}
