package com.emse.spring.faircorp;

import com.emse.spring.faircorp.dao.LightDao;
import com.emse.spring.faircorp.hello.ConsoleGreetingService;
import com.emse.spring.faircorp.hello.DummyUserService;
import com.emse.spring.faircorp.hello.GreetingService;
import com.emse.spring.faircorp.model.Status;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(OutputCaptureExtension.class) // 1
@SpringBootTest
class FaircorpApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGreeting(CapturedOutput output) {
        GreetingService greetingService = new ConsoleGreetingService(); // 2
        greetingService.greet("Spring");
        Assertions.assertThat(output.getAll()).contains("Hello, Spring!");
    }

    @Configuration // 2
    @ComponentScan("com.emse.spring.faircorp.hello")
    public static class DummyUserServiceTestConfig {
    }

    @Autowired // 3
    public DummyUserService dummyUserService;

    @Test
    public void testGreetingAll(CapturedOutput output) {
        dummyUserService.greetAll();
        Assertions.assertThat(output).contains("Hello, Elodie!", "Hello, Charles!");
    }


}
