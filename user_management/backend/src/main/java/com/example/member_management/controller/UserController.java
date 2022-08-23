package com.example.member_management.controller;

import com.example.member_management.controller.dto.request.CreateUserRequest;
import com.example.member_management.controller.dto.request.UpdateUserRequest;
import com.example.member_management.dto.response.StatusResponse;
import com.example.member_management.model.entity.User;
import com.example.member_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public List<User> getAllUsers(){
        return this.userService.getUserList();
    }
    @RequestMapping(value = {"/", "/{id}"},method = RequestMethod.GET)
    public User getUserById(@PathVariable(required = false) Integer id,@RequestParam(required = false) String name){
            if(null !=id){
                return  this.userService.getUserById(id);
            }else {
                return   this.userService.getUserByName(name);
            }
    }
    @DeleteMapping("/{id}")
    public StatusResponse deleteUser(@PathVariable int id) {
        String response=this.userService.deleteUser(id);
        return new StatusResponse(response);
    }
    @PutMapping("/{id}")
    public StatusResponse updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        String response=this.userService.updateUser(id,request);
        return new StatusResponse(response);
    }
    @PostMapping()
    public StatusResponse createUser(@RequestBody CreateUserRequest request) {
        String response=(this.userService.createUser(request));
        return new StatusResponse(response);
    }

}
