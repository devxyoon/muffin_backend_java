package com.muffin.web.user;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/idCheck/{emailId}")
    public boolean idCheck(@PathVariable String emailId){
        System.out.println(emailId);
        return userService.exists(emailId);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> save(@RequestBody User user){
        System.out.println(user);
        userService.save(user);
        Optional<User> findUser = userService.findById(user.getEmailId());
        return findUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/signIn")
    public ResponseEntity<User> login(@RequestBody User user){
        Optional<User> findUser = userService.findById(user.getEmailId());
        if(findUser.isPresent()){
            User returnUser = findUser.get();
            return returnUser.getPassword().equals(user.getPassword()) ? ResponseEntity.ok(returnUser) : ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
