package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
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

        throw new NotFoundException("User not existed.");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        for (User user : users) {
            if (user.getEmail().equals(req.getEmail())) {
                throw new DuplicateRecordException("Email existed already.");
            }
        }

        User user = new User();
        user.setId(users.size() + 1);
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPhone(req.getPhone());
        user.setPassword(req.getPassword());

        users.add(user);

        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        for (User user : users) {
            if (user.getId() != id) {
                continue;
            }

            if (!user.getEmail().equals(req.getEmail())) {
                for (User tmp : users) {
                    if (tmp.getEmail().equals(req.getEmail())) {
                        throw new DuplicateRecordException("Email has been existed already.");
                    }
                }
                user.setEmail(req.getEmail());
            }

            user.setName(req.getName());
            user.setPhone(req.getPhone());
            user.setPassword(req.getPassword());

            return UserMapper.toUserDto(user);
        }

        throw new NotFoundException("No user found.");
    }

    @Override
    public boolean deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }

        throw new NotFoundException("No user found.");
    }
}
