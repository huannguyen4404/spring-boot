package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("biki-ni")
//@Primary
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Wearing Bikini 😍");
    }
}
