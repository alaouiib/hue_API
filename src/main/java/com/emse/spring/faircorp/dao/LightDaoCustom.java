package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Light;

import java.util.List;

public interface LightDaoCustom {
    List<Light> findOnLights();
    List<Light> findByRoomId(Long id);


}
