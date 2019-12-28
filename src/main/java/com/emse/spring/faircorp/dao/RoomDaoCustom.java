package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findOnRooms();
    List<Room> findByRoomId(Long id);

}
