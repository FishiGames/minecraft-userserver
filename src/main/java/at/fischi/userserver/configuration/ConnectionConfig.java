package at.fischi.userserver.configuration;

import lombok.Getter;

import java.util.List;

@Getter
public class ConnectionConfig {

    private List<String> whitelistedIps = List.of("0:0:0:0:0:0:0:1", "0.0.0.0", "127.0.0.1", "10.", "172.");

}
