package com.muffin.web.user;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public void save(@RequestBody User user){
        System.out.println(user);
        userService.save(user);
    }
}