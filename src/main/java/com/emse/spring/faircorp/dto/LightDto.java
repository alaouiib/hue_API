package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Status;

public class LightDto {
    private Long id;
    private Long RoomId;
    private int level;
    private Status status;

    public LightDto(){

    }
    public LightDto(Light light){
        this.id = light.getId();
        this.RoomId = light.getRoom().getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return RoomId;
    }

    public void setRoomId(Long roomId) {
        RoomId = roomId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
