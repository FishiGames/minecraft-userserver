package at.fischi.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MinecraftUserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinecraftUserServerApplication.class, args);
    }
}