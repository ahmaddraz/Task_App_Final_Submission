package com.example.task_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(MyTask task);

    @Query("SELECT * FROM tasks_table")
    LiveData<List<MyTask>> getAllTasks();
}
