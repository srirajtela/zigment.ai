package zigment.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zigment.notification.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    // Custom query to find UserPreference by email
    Optional<UserEntity> findByEmail(String email);
}

