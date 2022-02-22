package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Henry Nguyen", "henry@abc.com", "0964111397", "henry.jpg", "slime"));
        users.add(new User(2, "DNhan Nguyen", "dnhan@abc.com", "0901111575", "dnhan.jpg", "peopeo"));
        users.add(new User(3, "Mie Nguyen", "mie@abc.com", "0964111297", "mie.jpg", "snowqueen"));
        users.add(new User(4, "Lizzie Nguyen", "lizzie@abc.com", "0964111197", "lizzie.jpg", "citiboiz"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }

        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }

        return null;
    }
}
