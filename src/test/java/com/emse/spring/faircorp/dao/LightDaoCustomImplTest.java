package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Status;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class LightDaoCustomImplTest {

    @Autowired
    private LightDao lightDao;

    @Test
    public void shouldFindOnLights() {
        Assertions.assertThat(lightDao.findOnLights())
                .hasSize(1)
                .extracting("id", "status")
                .containsExactly(Tuple.tuple(-1L, Status.ON));
    }
    @Test
    public void shouldfindByRoomId() {
        Assertions.assertThat(lightDao.findByRoomId(new Long(-10)))
                .extracting("id","level")
                .contains(Tuple.tuple(-1L, 8));
    }
}