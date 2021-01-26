package dao;

import entity.Ticket;

import javax.persistence.EntityManager;

public class TicketDao extends AbstractEntityDao<Ticket, Integer> {

    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getClassType() {
        return Ticket.class;
    }
}
