package com.example.task_app;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<MyTask>> allTasks;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TaskRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public void insert(MyTask task) {
        executor.execute(() -> taskDao.insert(task));
    }

    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }
}
