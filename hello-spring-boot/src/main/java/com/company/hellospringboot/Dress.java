package com.company.hellospringboot;

import org.springframework.stereotype.Component;

@Component
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("wearing Dress...");
    }
}
