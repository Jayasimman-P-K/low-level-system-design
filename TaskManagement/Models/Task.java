package TaskManagement.Models;

import java.time.LocalDateTime;

import TaskManagement.Enums.TaskPriority;
import TaskManagement.Enums.TaskStatus;

public class Task {
    private final String taskId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    // private Reminder reminder;

    public Task(String taskId, String title, String description, LocalDateTime dueDate, TaskPriority taskPriority, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
    
}
