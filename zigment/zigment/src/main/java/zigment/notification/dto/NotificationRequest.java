package zigment.notification.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Data
public class NotificationRequest {
    private String userId;
    private String type;
    private String channel;
    private String status; // e.g., sent, failed
    private Date sentAt;
    private String failureReason;
    private String content;
    private String email;
    private Map<String, Boolean> preferences;
    private String timezone;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
    
    
    
}

