# Designing a Task Management System

## Requirements

1. The task management system should allow users to create, update, and delete tasks.
2. Each task should have a title, description, due date, priority, and status (e.g., pending, in progress, completed).
3. Users should be able to assign tasks to other users and set reminders for tasks.
4. The system should support searching and filtering tasks based on various criteria (e.g., priority, due date, assigned user).
5. Users should be able to mark tasks as completed and view their task history.
6. The system should handle concurrent access to tasks and ensure data consistency.
7. The system should be extensible to accommodate future enhancements and new features.

### Project Structure

```css
src
├── models
│   ├── Task.java
│   └── Reminder.java
├── enums
│   ├── TaskStatus.java
│   └── TaskPriority.java
├── services
│   └── TaskService.java
└── main
    └── Driver.java

```

## Explanation

1. **Task Model**: Represents a task with fields like title, description, due date, priority, status, assigned user, and reminder.
2. **TaskStatus Enum**: Defines the different statuses a task can have (PENDING, IN_PROGRESS, COMPLETED).
3. **TaskPriority Enum**: Defines the different priorities a task can have (LOW, MEDIUM, HIGH).
4. **User Model**: Represents a user with fields like id, name, and email.
5. **Reminder Model**: Represents a reminder for a task with fields like reminder time and message.
6. **TaskService Class**: Provides methods to create, update, delete, search, mark tasks as completed, and get task history.
7. **UserService Class**: Provides methods to create and retrieve users.
8. **Driver Class**: The main class that simulates the task management system with user interaction through the console.
