package at.fischi.userserver.services;

import at.fischi.userserver.configuration.ConnectionConfig;
import at.fischi.userserver.configuration.DatabaseConfig;
import at.fischi.userserver.configuration.JsonConfig;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    public ConnectionConfig getConnectionConfig() {
        return new JsonConfig<>(new ConnectionConfig()).getItem();
    }

    public DatabaseConfig getDatebaseConfig() {
        return new JsonConfig<>(new DatabaseConfig()).getItem();
    }
}
