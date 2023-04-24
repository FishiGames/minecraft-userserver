package at.fischi.userserver.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

@Accessors(chain = true)
@Entity
public class UserEntity {

    @Id
    @Column(unique = true, length = 36)
    private String uniqueId;

    @Getter
    @Setter
    @Column(unique = true)
    private String username;

    @Getter
    @Setter
    @Column(columnDefinition = "longtext")
    private String value;

    @Getter
    @Setter
    @Column(columnDefinition = "longtext")
    private String signature;

    @Getter
    @Setter
    @Column(columnDefinition = "date")
    private Date expired;

    public boolean isExpired() {
        return expired == null || this.getExpired().getTime() <= new Date().getTime();
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId.toString();
    }

    public UUID getUniqueId() {
        return UUID.fromString(uniqueId);
    }

}