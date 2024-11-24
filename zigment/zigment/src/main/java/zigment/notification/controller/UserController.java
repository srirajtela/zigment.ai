package zigment.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zigment.notification.exception.ResourceNotFoundException;
import zigment.notification.entity.UserEntity;
import zigment.notification.service.UserService;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/preferences")
@Validated
public class UserController {

    @Autowired
    private UserService userPreferenceService;

    // Create User Preference
    @PostMapping
    public ResponseEntity<UserEntity> createPreference(@Validated @RequestBody UserEntity preference) {
        return ResponseEntity.ok(userPreferenceService.createPreference(preference));
    }

    // Get User Preference by ID
    @GetMapping("/{userId}")
    public UserEntity getPreferences(@PathVariable String userId) {
        return userPreferenceService.getPreference(userId);  // Call the service method
    }

    // Update User Preference
    @PatchMapping("/{userId}")
    public ResponseEntity<UserEntity> updatePreference(@PathVariable String userId, @Validated @RequestBody UserEntity updatedPreference) {
        return ResponseEntity.ok(userPreferenceService.updatePreference(userId, updatedPreference));
    }

    // Delete User Preference
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletePreference(@PathVariable String userId) {
        userPreferenceService.deletePreference(userId);
        return ResponseEntity.noContent().build();
    }
}
