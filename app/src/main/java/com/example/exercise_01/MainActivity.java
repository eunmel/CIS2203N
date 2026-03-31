package com.example.exercise_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView tvCounter;
    private static final String COUNT_KEY = "COUNT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Only update padding if it has actually changed to avoid layout loops
            if (v.getPaddingLeft() != systemBars.left || v.getPaddingTop() != systemBars.top ||
                v.getPaddingRight() != systemBars.right || v.getPaddingBottom() != systemBars.bottom) {
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            }
            return insets;
        });

        tvCounter = findViewById(R.id.tvCounter);
        tvCounter.setText(String.valueOf(mCounter));


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 23103014");
        }


        Button btnChangeName = findViewById(R.id.btnChangeName);
        final TextView tvDepartment = findViewById(R.id.tvDepartment);
        Button btnIncrement = findViewById(R.id.btnIncrement);

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDepartment.setText("Angie Ceniza");
            }
        });

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                tvCounter.setText(String.valueOf(mCounter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current counter value
        outState.putInt(COUNT_KEY, mCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore the counter value after rotation
        mCounter = savedInstanceState.getInt(COUNT_KEY);
        tvCounter.setText(String.valueOf(mCounter));
    }
}
