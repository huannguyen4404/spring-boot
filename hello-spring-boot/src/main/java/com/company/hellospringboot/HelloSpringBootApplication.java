package com.company.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

        Outfit outfit = context.getBean(Outfit.class);

        System.out.println("Instance: " + outfit);
        outfit.wear();
    }

}
