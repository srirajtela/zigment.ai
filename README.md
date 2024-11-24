## Features

### User Preferences Management
- **Create, update, retrieve, and delete** user notification preferences.
- Supports customizable preferences for:
  - Marketing
  - Newsletters
  - Updates
- Flexible **frequency** and **channel selection** options:
  - Frequency: Daily, Weekly, Monthly, Never
  - Channels: Email, SMS, Push

### Notification Management
- **Send notifications** based on user preferences.
- **Log notification status**: Tracks `sent`, `pending`, and `failed` states.
- **View statistics** and **user-specific logs** for notifications.

### Validation
- Enforces valid formats and data types using `javax.validation`:
  - Email addresses
  - Frequency types
  - Required fields

### Error Handling
- Custom exceptions for:
  - **Resource Not Found**: When a requested entity is missing.
  - **Invalid Operations**: For actions that do not comply with system rules.
 
    ## Technologies Used

### Backend
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For interacting with the PostgreSQL database.
- **Hibernate**: ORM framework for managing database entities.
- **MongoDB**: For storing notification logs (via Spring Data Mongo).

### Dependencies
- **Lombok**: Reduces boilerplate code for getters, setters, and constructors.
- **MapStruct**: Simplifies DTO mappings.
- **Hibernate Validator**: Provides field validation using annotations.

### Database
- **MongoDB**: Used for storing notification logs.
- **PostgreSQL**: Used for managing user preferences.


### Build Tool
- **Maven**: Dependency management and project build system.

## API Endpoints

### User Preferences
| **Method** | **Endpoint**                | **Description**               |
|------------|-----------------------------|--------------------------------|
| `POST`     | `/api/preferences`          | Create user preferences        |
| `GET`      | `/api/preferences/{userId}` | Get preferences for a user     |
| `PATCH`    | `/api/preferences/{userId}` | Update user preferences        |
| `DELETE`   | `/api/preferences/{userId}` | Delete user preferences        |

### Notification Management
| **Method** | **Endpoint**                       | **Description**                |
|------------|------------------------------------|---------------------------------|
| `POST`     | `/api/notifications/send`          | Send a notification             |
| `GET`      | `/api/notifications/{userId}/logs` | View logs for a user            |
| `GET`      | `/api/notifications/stats`         | View notification statistics    |


