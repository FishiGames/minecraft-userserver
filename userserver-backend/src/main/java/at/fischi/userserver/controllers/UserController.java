package at.fischi.userserver.controllers;

import at.fischi.userserver.entities.UserEntity;
import at.fischi.userserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("updateUser")
    public UserEntity updateUser(UserEntity userEntity) {
        return this.userService.updateUser(userEntity);
    }

    @GetMapping("requestUserUpdateByUniqueId")
    public UserEntity requestUserUpdateByUniqueId(String uniqueId) {
        return this.userService.getUserFromMojang(UUID.fromString(uniqueId));
    }

    @GetMapping("requestUserUpdateByUserName")
    public UserEntity requestUserUpdateByUserName(String username) {
        return this.userService.getUserFromMojang(this.userService.getUniqueIdFromName(username));
    }
}