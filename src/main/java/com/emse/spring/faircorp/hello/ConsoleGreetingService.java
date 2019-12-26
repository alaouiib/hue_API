package com.emse.spring.faircorp.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
// instead we can use Qualifier on top of the Primary inside the argument
@Primary
public class ConsoleGreetingService implements GreetingService {
    public void greet(String name) {
        System.out.println("Hello, "+name+"!");
    }
}
