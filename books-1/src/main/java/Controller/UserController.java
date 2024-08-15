package Controller;

import java.awt.print.Book;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.BookRepository;
import Service.UserService;
import model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> optionalUser = userService.findByUsername(user.getUsername());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            String token = tokenProvider.createToken(new Authentication(optionalUser.get(), null));
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

}
