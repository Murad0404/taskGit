package com.company.controller;

import com.company.dto.Task;
import com.company.enums.TaskStatus;
import com.company.repository.TaskRepository;
import com.company.service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskController {
    public void start() {

        boolean t = true;
        while (t) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1:
                    createNewTask();
                    break;
                case 2:
                    printTaskList();
                    break;
                case 3:
                    printTaskListfinnish();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    updateTask();
                    break;
                case 6:
                    done();
                    break;
                case 0:
                    t = false;
                    break;
                default:
                    System.out.println("Mazgi");
                    t = false;

            }
        }


    }

    private void createNewTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Title");
        String title = scanner.next();

        System.out.println("Enter Content");
        String content = scanner.next();

        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);

        TaskService taskService = new TaskService();
        taskService.addTask(task);

    }

    public void done() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id");
        Integer id = Integer.valueOf(scanner.next());

        Task task = new Task();
        task.setStatus(TaskStatus.DONE);
        task.setFinishedDate(LocalDateTime.now());
        TaskService taskService = new TaskService();
        taskService.TaskDone(task, id);
    }

    public void updateTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Id");
        Integer id = Integer.valueOf(scanner.next());

        System.out.println("Enter Title");
        String title = scanner.next();

        System.out.println("Enter Content");
        String content = scanner.next();

        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);

        TaskService taskService = new TaskService();
        taskService.updateTask(task, id);
    }

    public void deleteTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id");
        Integer id = scanner.nextInt();

        TaskService taskService = new TaskService();
        taskService.deleteTaskByTitle(id);
    }

    public void printTaskList() {
        TaskService taskService = new TaskService();
        taskService.showTaskList();
    }

    public void printTaskListfinnish() {
        TaskService taskService = new TaskService();
        taskService.showTaskListFinnish();
    }

    public int getAction() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        return action;
    }

    public void showMenu() {
        System.out.println("** Menu \uD83D\uDE01 **");
        System.out.println("1. Add Task");
        System.out.println("2. Active Task List");
        System.out.println("3. Finished Task List");
        System.out.println("4. Delete Task");
        System.out.println("5. Update Task");
        System.out.println("6. done Task");
        System.out.println("0. Exit");
    }

}
