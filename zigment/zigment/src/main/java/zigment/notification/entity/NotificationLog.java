package zigment.notification.entity;

//import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "notification_logs")
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "type", nullable = false)
    private String type; // e.g., marketing, newsletter, updates

    @Column(name = "channel", nullable = false)
    private String channel; // e.g., email, sms, push

    @Column(name = "status", nullable = false)
    private String status; // e.g., pending, sent, failed

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;

    private String failureReason;

    @Column(columnDefinition = "TEXT")
   // private String metadata;
    
    private Map<String, String> metadata;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

//	public String getMetadata() {
//		return metadata;
//	}
//
//	public void setMetadata(String metadata) {
//		this.metadata = metadata;
//	}
	
	
	
    // Getters and Setters
    // ...
}

