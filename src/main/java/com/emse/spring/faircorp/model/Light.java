package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
//@Table(name = "Light")
public class Light {

    // 2.

    @Id
//    @GeneratedValue
    private Long id;

    // 3.
    @Column(nullable = false)  // 4.
    private Integer level;
    //
//    @Column
//    private Integer color;
    // 4.
    @Enumerated(EnumType.STRING) // 6.
    private Status status;

    @JsonBackReference
    @ManyToOne
    Room room;


    public Light() {
    }

    public Light(Long id, Room room, Integer level, Status status) {
        this.level = level;
        this.status = status;
        this.room = room;
        this.id = id;
//        this.color = color;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
//
//    public Integer getColor() {
//        return color;
//    }
//
//    public void setColor(Integer color) {
//        this.color = color;
//    }
}