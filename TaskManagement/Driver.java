package TaskManagement;

import java.time.LocalDateTime;
import java.util.Scanner;

import TaskManagement.Enums.TaskPriority;
import TaskManagement.Enums.TaskStatus;
import TaskManagement.Models.Task;
import TaskManagement.Services.TaskService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskService taskService = new TaskService();

        boolean loop = true;
        while (loop) {
            System.out.println("\n1. Create Task\n2. Update Task\n3. Delete Task\n4. Mark as completed\n5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Enter task ID: ");
                    String taskId = scanner.next();
                    System.out.print("Enter task title: ");
                    String title = scanner.next();
                    System.out.print("Enter task description: ");
                    String description = scanner.next();
                    System.out.print("Enter due date(yyyy-MM-ddTHH:mm:ss): ");
                    LocalDateTime dueDate = LocalDateTime.parse(scanner.next());
                    System.out.print("Enter task priority(HIGH/MEDIUM/LOW): ");
                    TaskPriority taskPriority = TaskPriority.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter task status(PENDING/IN_PROGRESS/COMPLETED)");
                    TaskStatus taskStatus = TaskStatus.valueOf(scanner.next().toUpperCase());
                    Task task = taskService.createTask(taskId, title, description, dueDate, taskPriority, taskStatus);
                    System.out.println("Task created: " + task.getTitle());
                    break;
                }

                case 2: {
                    System.out.print("Enter task ID: ");
                    String taskId = scanner.next();
                    Task taskToUpdate = taskService.getTask(taskId);

                    if (taskToUpdate != null) {
                        String title = scanner.next();
                        System.out.print("Enter task description: ");
                        String description = scanner.next();
                        System.out.print("Enter due date(yyyy-MM-ddTHH:mm:ss): ");
                        LocalDateTime dueDate = LocalDateTime.parse(scanner.next());
                        System.out.print("Enter task priority(HIGH/MEDIUM/LOW): ");
                        TaskPriority taskPriority = TaskPriority.valueOf(scanner.next().toUpperCase());
                        System.out.print("Enter task status(PENDING/IN_PROGRESS/COMPLETED)");
                        TaskStatus taskStatus = TaskStatus.valueOf(scanner.next().toUpperCase());
                        taskService.updateTask(taskToUpdate, title, description, dueDate, taskPriority, taskStatus); 
                        System.out.println("Task updated: " + taskToUpdate.getTitle());   
                    } else {
                        System.out.println("Task not found.");
                    }

                    break;
                }

                case 3: {
                    System.out.print("Enter task ID: ");
                    String taskId = scanner.next();
                    Task taskToDelete = taskService.getTask(taskId);

                    if (taskToDelete != null) {
                        taskService.deleteTask(taskToDelete);
                        System.out.println("Task Deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }

                    break;
                }

                case 4: {
                    System.out.print("Enter Task ID: ");
                    String taskId = scanner.next();
                    Task taskToMark = taskService.getTask(taskId);

                    if (taskToMark != null) {
                        taskService.markTaskAsCompleted(taskToMark);
                        System.out.println("Task marked as completed: " + taskToMark.getTitle());
                    } else {
                        System.out.println("Task not found.");
                    }

                    break;
                }

                case 5: {
                    loop = false;
                    break;
                }

                default: {
                    System.out.println("Not an option. Choose a correct option.");
                    break;
                }
            }
        }
    
        scanner.close();
    }
}