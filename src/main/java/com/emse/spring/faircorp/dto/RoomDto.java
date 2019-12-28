package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;

import java.util.List;

public class RoomDto {

    private Long id;

    private String name;

    private String floor;

    List<Light> lights;

    public RoomDto(){

    }

    public RoomDto(List<Light> lights) {
        this.lights = lights;
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.lights = room.getLights();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return this.getId()+this.getName()+this.getFloor();
    }
}