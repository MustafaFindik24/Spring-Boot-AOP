package com.mustafafindik.aop.Controller;

import com.mustafafindik.aop.Service.UserServiceImpl;
import com.mustafafindik.aop.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public User getUser(@RequestParam Long id){
        return userService.getUser(id);
    }
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
