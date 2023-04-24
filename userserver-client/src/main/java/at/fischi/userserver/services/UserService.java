package at.fischi.userserver.services;

import at.fischi.userserver.entities.UserEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Getter
    public static UserService instance;
    private final WebService webService;

    private String baseUrl;

    private UserService(String baseUrl) {
        instance = this;

        this.baseUrl = baseUrl;
        if (!baseUrl.endsWith("/")) {
            this.baseUrl += "/";
        }

        this.webService = new WebService();
    }

    public static UserService getInstance(String baseUrl) {
        return (instance == null ? new UserService(baseUrl) : instance);
    }

    public UserEntity getUserByName(String username) {
        var response = this.webService.getRequest(baseUrl + "user/getUserByUserName?username=" + username);
        return GSON.fromJson(response, UserEntity.class);
    }

    public UserEntity getUserByUniqueId(UUID uniqueId) {
        var response = this.webService.getRequest(baseUrl + "user/getUserByUniqueId?uniqueId=" + uniqueId);
        return GSON.fromJson(response, UserEntity.class);
    }
}