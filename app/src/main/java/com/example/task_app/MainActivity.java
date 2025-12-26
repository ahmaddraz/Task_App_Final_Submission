package com.example.task_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;
    private EditText editTitle, editDetails;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.edit_title);
        editDetails = findViewById(R.id.edit_details);
        btnAdd = findViewById(R.id.btn_add);


        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String details = editDetails.getText().toString();

                if (!title.isEmpty() && !details.isEmpty()) {
                    MyTask task = new MyTask(title, details);
                    taskViewModel.insert(task);

                    Toast.makeText(MainActivity.this, "تم حفظ المهمة بنجاح", Toast.LENGTH_SHORT).show();
                    editTitle.setText("");
                    editDetails.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "الرجاء تعبئة جميع الحقول", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}