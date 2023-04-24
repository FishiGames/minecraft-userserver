package at.fischi.userserver.services;

import at.fischi.userserver.entities.UserEntity;
import at.fischi.userserver.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ConfigService configService;
    private final WebService webService;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    public UserService(UserRepository userRepository, WebService webService, ConfigService configService) {
        this.userRepository = userRepository;
        this.configService = configService;
        this.webService = webService;
    }

    public UUID getUniqueIdFromName(String username) {
        var response = this.webService.getRequest("https://api.mojang.com/users/profiles/minecraft/" + username);
        var hashMap = this.gson.fromJson(response, HashMap.class);
        var uuid = (String) hashMap.get("id");

        return UUID.fromString(String.format("%s-%s-%s-%s-%s", uuid.substring(0,8), uuid.substring(8,12), uuid.substring(12,16), uuid.substring(16,20), uuid.substring(20)));
    }

    public UserEntity getUserFromMojang(UUID uniqueId) {
        try {
            var response = this.webService.getRequest("https://sessionserver.mojang.com/session/minecraft/profile/" + uniqueId + "?unsigned=false");
            var hashMap = this.gson.fromJson(response, HashMap.class);

            var userEntity = new UserEntity();
            userEntity.setUniqueId(uniqueId);
            userEntity.setUsername(hashMap.get("name").toString());

            var linkedTreeMap = (LinkedTreeMap<String, String>) ((ArrayList) hashMap.get("properties")).get(0);
            userEntity.setSignature(linkedTreeMap.get("signature"));
            userEntity.setValue(linkedTreeMap.get("value"));

            userEntity.setExpired(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(this.configService.getDatebaseConfig().getDaysUntilDatabaseEntryExpired())));

            this.userRepository.deleteById(userEntity.getUniqueId().toString());
            this.userRepository.save(userEntity);

            return userEntity;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public UserEntity updateUser(UserEntity userEntity) {
        userEntity.setExpired(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(this.configService.getDatebaseConfig().getDaysUntilDatabaseEntryExpired())));

        this.userRepository.deleteById(userEntity.getUniqueId().toString());
        this.userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity getUser(String username) {
        var user = this.userRepository.findUserEntityByUsernameEqualsIgnoreCase(username);
        if(user == null || user.isExpired()) {
            user = this.getUser(this.getUniqueIdFromName(username));
        }

        return user;
    }

    public UserEntity getUser(UUID uniqueId) {
        var user = this.userRepository.findById(uniqueId.toString()).orElse(null);
        if(user == null || user.isExpired()) {
            user = this.getUserFromMojang(uniqueId);
        }

        return user;
    }
}