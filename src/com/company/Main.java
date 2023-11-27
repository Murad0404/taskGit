package com.company;

import com.company.controller.TaskController;

public class Main {
    public static void main(String[] args) {

//        System.out.println(UUID.randomUUID().toString());



        TaskController taskManager = new TaskController();
        taskManager.start();


    }

}
