package com.example.moodtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputMood;
    private TextView outputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMood = findViewById(R.id.inputMood);
        outputMessage = findViewById(R.id.outputMessage);
        Button generateButton = findViewById(R.id.generateButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateMessage();
            }
        });
    }

    private void generateMessage() {
        String inputText = inputMood.getText().toString();

        if (inputText.isEmpty()) {
            outputMessage.setText("Пожалуйста, введите число!");
            return;
        }

        int mood = Integer.parseInt(inputText);

        String message;
        if (mood >= 80) {
            message = "Ты супер! Продолжай в том же духе! 🔥";
        } else if (mood >= 50) {
            message = "Отлично! Но всегда есть место для роста! 😊";
        } else if (mood >= 20) {
            message = "Не унывай, завтра будет лучше! 💪";
        } else {
            message = "Ты не один! Все наладится, просто верь в себя. ❤️";
        }

        outputMessage.setText(message);
    }
}
