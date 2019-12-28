package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoImpl implements  RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Room> findOnRooms() {
//        String jpql = "select rm from Room rm where rm.floor = :floor";
//        return em.createQuery(jpql, Room.class)
//                .setParameter("floor", '1')
//                .getResultList();
        return null;
    }

    @Override
    public List<Room> findByRoomId(Long id) {
        String jpql = "select rm from Room rm where rm.id = :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }

}
