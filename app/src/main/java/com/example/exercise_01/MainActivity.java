package com.example.exercise_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hardcode Student ID into the Action Bar Title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 23103014");
        }

        // Initialize UI components
        Button btnChangeName = findViewById(R.id.btnChangeName);
        final TextView tvDepartment = findViewById(R.id.tvDepartment);

        // Set Click Listener to change the TextView to the Chairwoman's name
        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDepartment.setText("Angie Ceniza");
            }
        });
    }
}
