package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "hello-world", method = RequestMethod.GET)
    public ResponseEntity<?> helloWord() {
//        User user = new User(1, "Henry", "henry@gmail.com", "0964912397", "henry.jpg", "miemie");

        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
