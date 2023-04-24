package at.fischi.userserver.configuration;

import lombok.Getter;

@Getter
public class DatabaseConfig {

    private int daysUntilDatabaseEntryExpired = 6;

}
