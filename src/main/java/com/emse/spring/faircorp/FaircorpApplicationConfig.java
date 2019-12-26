package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1
@Configuration
public class FaircorpApplicationConfig {

    // 2
    @Bean
    @Autowired
    // we can use Qualifier here instead of Primary
    public CommandLineRunner greetingCommandLine(GreetingService gsComponent) { // 3
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 4

                gsComponent.greet("Spring");
            }
        };
    }
}