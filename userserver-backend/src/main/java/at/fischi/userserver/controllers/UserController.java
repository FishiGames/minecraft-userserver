package at.fischi.userserver.controllers;

import at.fischi.userserver.entities.UserEntity;
import at.fischi.userserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getUserByUserName")
    public UserEntity getUserByUserName(String username) {
        return userService.getUser(username);
    }

    @GetMapping("getUserByUniqueId")
    public UserEntity getUserByUniqueId(String uniqueId) {
        return userService.getUser(UUID.fromString(uniqueId));
    }
}