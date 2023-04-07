package ru.mirea.duplingv.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String dateString = (String) getIntent().getSerializableExtra("date");
        TextView DateTextView = findViewById(R.id.textViewForDate);
        DateTextView.setText("КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУУПЕ\nСОСТАВЛЯЕТ 121\nТекущее время " + dateString);
    }
}