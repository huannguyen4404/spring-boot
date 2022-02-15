package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // singleton|prototype|request|session
public class Dress {
    public void wear() {
        System.out.println("Wearing Dress...");
    }
}
