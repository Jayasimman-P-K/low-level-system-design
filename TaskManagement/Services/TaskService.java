package TaskManagement.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import TaskManagement.Enums.TaskPriority;
import TaskManagement.Enums.TaskStatus;
import TaskManagement.Models.Task;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public Task createTask(String taskId, String title, String description, LocalDateTime dueDate, TaskPriority taskPriority, TaskStatus taskStatus) {
        Task task = new Task(taskId, title, description, dueDate, taskPriority, taskStatus);
        tasks.add(task);
        return task;
    }

    public Task getTask(String taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(Task task, String title, String description, LocalDateTime dueDate, TaskPriority taskPriority, TaskStatus taskStatus) {
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void markTaskAsCompleted(Task task) {
        task.setTaskStatus(TaskStatus.COMPLETED);
    }
}
