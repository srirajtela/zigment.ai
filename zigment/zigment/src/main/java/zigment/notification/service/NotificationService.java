package zigment.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Query;
import zigment.notification.entity.NotificationLog;
import zigment.notification.repository.NotificationLogRepository;
import zigment.notification.dto.NotificationRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    private NotificationLogRepository notificationLogRepository;

    /**
     * Sends a notification based on the request details.
     *
     * @param notificationRequest The notification request containing details.
     */
    public void sendNotification(NotificationRequest notificationRequest) {
        NotificationLog log = new NotificationLog();
        
        // Set fields for NotificationLog
        log.setUserId(notificationRequest.getUserId());
        log.setType(notificationRequest.getType());
        log.setChannel(notificationRequest.getChannel());
        log.setStatus("pending"); // Default status
        log.setSentAt(new Date()); // Set current date as sent time

        // Add metadata
        Map<String, String> metadata = Map.of(
            "content", notificationRequest.getContent()
        );
        log.setMetadata(metadata);

        // Simulate sending notification
        try {
            // Simulate notification sending logic (e.g., via email, SMS, or push)
            boolean isSent = simulateNotificationSending(notificationRequest);

            // Update log status based on the result
            if (isSent) {
                log.setStatus("sent");
            } else {
                log.setStatus("failed");
                log.setFailureReason("Simulation of failure in sending notification.");
            }
        } catch (Exception e) {
            log.setStatus("failed");
            log.setFailureReason(e.getMessage());
        }

        // Save log to repository
        notificationLogRepository.save(log);
    }

    /**
     * Simulates the sending of a notification.
     *
     * @param request The notification request.
     * @return true if the notification is sent successfully, false otherwise.
     */
    private boolean simulateNotificationSending(NotificationRequest request) {
        // Simulated logic: you can add actual notification-sending logic here.
        // For now, let's assume all notifications are sent successfully.
        return true;
    }
    public List<NotificationLog> getUserNotificationLogs(String userId) {
        // Fetch logs from the repository using the userId
        return notificationLogRepository.findByUserId(userId);
    }
    public Map<String, Long> getNotificationStats() {
        Map<String, Long> stats = new HashMap<>();
        
        // Count the number of notifications by status
        stats.put("sent", notificationLogRepository.countByStatus("sent"));
        stats.put("pending", notificationLogRepository.countByStatus("pending"));
        stats.put("failed", notificationLogRepository.countByStatus("failed"));
        
        return stats;
    }
    
}