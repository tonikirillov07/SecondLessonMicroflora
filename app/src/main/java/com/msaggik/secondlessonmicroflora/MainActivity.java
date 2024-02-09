package com.msaggik.secondlessonmicroflora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    private int count = 0;
    private int preCount = 0;
    private static final String SAVE_COUNT_KEY = "counter";

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        count = savedInstanceState.getInt(SAVE_COUNT_KEY);
        output.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SAVE_COUNT_KEY, count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v ->{
            countFibonacci();
            output.setText(String.valueOf(count));
        });
    }

    private void countFibonacci() {
        if(count == 0 && preCount == 0) { // условие начала отсчёта
            count = 1; // появление первой бактерии
        }

        if (count == 1 && preCount == 0) { // условие первого поколения
            preCount = 1; // деление бактерии на две
        } else { // в следующих поколениях происходит деление в соответствии с принципом последовательности ряда Фибоначчи
            int pre = count; // буферное сохранение счётчика популяции предыдущего поколения
            count = count + preCount; // подсчёт счётчика популяции текущего поколения
            preCount = pre; // переинициализации счётчика популяции предыдущего поколения
        }
    }
}