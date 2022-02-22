package com.example.demo.controller;

import com.example.demo.UserService;
import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //    @RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(required = false, defaultValue = "") String keyword) {
        List<UserDto> users = userService.searchUser(keyword);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq req) {
        UserDto user = userService.createUser(req);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDto user = userService.updateUser(req, id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete completed.");
    }
}
