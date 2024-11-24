package zigment.notification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zigment.notification.dto.NotificationRequest;
import zigment.notification.entity.NotificationLog;
import zigment.notification.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Send a Notification
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        try {
            notificationService.sendNotification(notificationRequest);
            return ResponseEntity.ok("Notification sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send notification: " + e.getMessage());
        }
    }

    // Get Notification Logs for a User
    @GetMapping("/{userId}/logs")
    public ResponseEntity<List<NotificationLog>> getUserNotificationLogs(@PathVariable String userId) {
        List<NotificationLog> logs = notificationService.getUserNotificationLogs(userId);
        return ResponseEntity.ok(logs);
    }

    // Get Notification Statistics
    @GetMapping("/stats")
    public ResponseEntity<Object> getNotificationStats() {
        return ResponseEntity.ok(notificationService.getNotificationStats());
    }
}
