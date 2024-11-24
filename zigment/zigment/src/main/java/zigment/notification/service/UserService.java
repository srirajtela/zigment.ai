package zigment.notification.service;

//import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;
import zigment.notification.dto.NotificationRequest;
import zigment.notification.entity.UserEntity;
import zigment.notification.repository.UserRepository;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUserPreference(NotificationRequest dto) {
        // Map DTO to Entity
        UserEntity userPreference = new UserEntity();
        userPreference.setUserId(dto.getUserId());
        userPreference.setEmail(dto.getEmail());
        userPreference.setPreferences(dto.getPreferences());
        userPreference.setTimezone(dto.getTimezone());
        userPreference.setCreatedAt(dto.getCreatedAt());
        userPreference.setLastUpdated(dto.getLastUpdated());

        return userRepository.save(userPreference);
    }
    
    public UserEntity createPreference(UserEntity userEntity) {
        // Save or update user preferences in the database
        return userRepository.save(userEntity);
    }
    
    public UserEntity getPreference(String userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);  // Retrieve by userId
        return userEntity.orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public UserEntity updatePreference(String userId, UserEntity updatedUserEntity) {
        Optional<UserEntity> existingUserOpt = userRepository.findById(userId);
        
        if (existingUserOpt.isPresent()) {
            UserEntity existingUser = existingUserOpt.get();

            // Update fields with the new preferences
            existingUser.setEmail(updatedUserEntity.getEmail());
            existingUser.setPreferences(updatedUserEntity.getPreferences());
            existingUser.setTimezone(updatedUserEntity.getTimezone());
            existingUser.setCreatedAt(updatedUserEntity.getCreatedAt());
            existingUser.setLastUpdated(updatedUserEntity.getLastUpdated());
            
            // Save and return the updated user entity
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found for update");
        }
    }
    
    public void deletePreference(String userId) {
        // Check if the user exists before attempting to delete
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        
        if (userEntity.isPresent()) {
            userRepository.deleteById(userId);  // Delete user preferences by userId
        } else {
            throw new RuntimeException("User not found for deletion");
        }
    }
}
