package com.example.task_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks_table")
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String details;

    public MyTask(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}