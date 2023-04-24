package at.fischi.userserver.repositories;

import at.fischi.userserver.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findUserEntityByUsernameEqualsIgnoreCase(String username);

}
