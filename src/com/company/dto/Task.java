package com.company.dto;

import com.company.enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String title;

    private String content;

    private TaskStatus status;

    private LocalDateTime createdDate;

    private LocalDateTime finishedDate;

    public Task(Integer id, String title, String content, TaskStatus status, LocalDateTime createdDate,LocalDateTime finishedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdDate = createdDate;
        this.finishedDate =finishedDate;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDateTime finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getWritableString() {
        return id + "#" + title + "#" + content + "#" + status + "#" + createdDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", finishedDate=" + finishedDate +
                '}';
    }
}
