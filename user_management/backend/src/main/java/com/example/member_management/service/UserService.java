package com.example.member_management.service;

import com.example.member_management.controller.dto.request.CreateUserRequest;
import com.example.member_management.controller.dto.request.UpdateUserRequest;
import com.example.member_management.model.UserRepository;
import com.example.member_management.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUserList(){
        return this.userRepository.findAll();
    }
    public User getUserById(int id){
        return this.userRepository.findById(id);
    }
    public User getUserByName(String name){
        return this.userRepository.findByName(name);
    }
    public String deleteUser(int id) {
        User user = this.userRepository.findById(id);
        if (null == user) {
            return "Fail";
        } else {
            this.userRepository.deleteById(id);
            return "ok";
        }
    }
    public String updateUser(int id, UpdateUserRequest request) {

        User getUser = this.userRepository.findById(id);
        if (null == getUser) {
            return "Fail";
        } else {
            getUser.setName(request.getName());
            getUser.setAge(request.getAge());
            this.userRepository.save(getUser);
            return "ok";
        }
    }
    public String createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        this.userRepository.save(user);
        return "OK";
    }

}
