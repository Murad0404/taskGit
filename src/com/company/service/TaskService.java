package com.company.service;

import com.company.dto.Task;
import com.company.repository.TaskRepository;
import com.company.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

public class TaskService {

    /** __Task Manager  Console Program__

     Task
     (id(serial),title,content(text),status(varchar),created_date(timestamp),finished_date(timestamp))

     status - TaskStatus - Enum
     ACTIVE,DONE

     ***** Menu *****
     1-Create
     Enter title:
     Enter content:
     2-Active Task List
     3-Finished Task List
     4-Update (by id)
     Enter Task Id:
     Enter Title:
     Enter Content:
     5-Delete by id:
     Enter Delete Task Id:
     6-Mark as Done:
     Enter Task Id To Mark it as Done:
     */

    public void addTask(Task task){

        if (task.getTitle().length()<3){
            System.err.println("TASK QO'SHILDI ");
            return;
        }
        task.setStatus(TaskStatus.ACTIVE);
        task.setCreatedDate(LocalDateTime.now());
        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(task);

    }

    public void showTaskList() {
        TaskRepository taskRepository = new TaskRepository();
        List<Task> taskList = taskRepository.getAllTask();
        for (Task task : taskList){
            if (task.getStatus().equals(TaskStatus.ACTIVE)){
                System.out.println(task);
            }
        }
//        taskList.forEach(task -> System.out.println(task));
    }

    public void showTaskListFinnish() {
        TaskRepository taskRepository = new TaskRepository();
        List<Task> taskList = taskRepository.getAllTaskFinish();
        for (Task task : taskList){
            if (task.getStatus().equals(TaskStatus.DONE)) {
                System.out.println(task);
            }
        }
//        taskList.forEach(task -> System.out.println(task));
    }

    public void deleteTaskByTitle(Integer id) {
        TaskRepository taskRepository = new TaskRepository();
        System.out.println(taskRepository.deleteTask(id));

    }

    public void updateTask(Task task,int id) {
        TaskRepository taskRepository = new TaskRepository();
        taskRepository.updateTask(task,id);
    }
    public void TaskDone(Task task,int id) {
        TaskRepository taskRepository = new TaskRepository();
        taskRepository.doneTask(task,id);
    }
}
