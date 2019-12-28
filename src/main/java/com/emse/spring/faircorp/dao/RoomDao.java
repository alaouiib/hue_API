package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomDao extends RoomDaoCustom,JpaRepository<Room, Long> {

    @Modifying
    @Query("delete from Light lt where lt.room.id=:id")
    void deleteLightsByRoomId(@Param("id") Long id);
}
