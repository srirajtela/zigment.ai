package zigment.notification.entity;

import java.time.LocalDateTime;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.MapKeyColumn;

public class UserEntity {

    private Preferences preferences;

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    // Nested Preferences Class
    public static class Preferences {
        private boolean marketing;
        private boolean newsletter;
        private boolean updates;

        // Getters and Setters
        public boolean isMarketing() {
            return marketing;
        }

        public void setMarketing(boolean marketing) {
            this.marketing = marketing;
        }

        public boolean isNewsletter() {
            return newsletter;
        }

        public void setNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
        }

        public boolean isUpdates() {
            return updates;
        }

        public void setUpdates(boolean updates) {
            this.updates = updates;
        }
    }

	public void setUserId(String userId) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	public void setPreferences(Map<String, Boolean> preferences2) {
		// TODO Auto-generated method stub
		
	}

	public void setTimezone(String timezone) {
		// TODO Auto-generated method stub
		
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		// TODO Auto-generated method stub
		
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		// TODO Auto-generated method stub
		
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTimezone() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDateTime getCreatedAt() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDateTime getLastUpdated() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @ElementCollection(fetch = FetchType.EAGER)
	    @CollectionTable(name = "user_preferences_metadata") // Child table name
	    @MapKeyColumn(name = "preference_key") // Key column name
	    @Column(name = "preference_value") // Value column name
	    private Map<String, String> metadata;

	    // Getters and Setters
	    public Map<String, String> getMetadata() {
	        return metadata;
	    }

	    public void setMetadata(Map<String, String> metadata) {
	        this.metadata = metadata;
	    }
	    
	    
}

