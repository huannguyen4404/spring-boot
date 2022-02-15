package com.company.hellospringboot;

import com.company.hellospringboot.other_package.Bikini;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.company.hellospringboot.other_package")
@SpringBootApplication(scanBasePackages = {"com.company.hellospringboot.other_package"})
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

        Bikini bikini = context.getBean(Bikini.class);
        System.out.println("Bikini: " + bikini);

        Dress dress = context.getBean(Dress.class); // Failed: No qualifying bean of type 'com.company.hellospringboot.Dress' available
        System.out.println("Dress: " + dress);

        Outfit outfit = context.getBean(Outfit.class);

        System.out.println("Instance: " + outfit);
        outfit.wear();
    }

}
