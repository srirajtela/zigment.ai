package zigment.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zigment.notification.entity.NotificationLog;

import java.util.List;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {

    // Fetch logs by userId
    List<NotificationLog> findByUserId(String userId);

    // Fetch logs by userId and type
    List<NotificationLog> findByUserIdAndType(String userId, String type);
    
    long countByStatus(String status);
}

