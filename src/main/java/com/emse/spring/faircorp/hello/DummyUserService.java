package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyUserService implements GreetingService{
    public void greetAll(){
        List<String> names = new ArrayList<String>();
        names.add("Elodie");
        names.add("Charles");
        names.forEach(name -> {
            greet(name);
        });
    };

    @Override
    public void greet(String name) {
        System.out.println("Hello, "+name+"!");
    }
}
