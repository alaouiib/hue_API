package com.emse.spring.faircorp.dao;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomDaoCustomImplTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindOnRooms() {
        Assertions.assertThat(roomDao.findByRoomId(new Long(1)))
                .extracting("Name")
                .containsExactly("Room3");
    }

}
