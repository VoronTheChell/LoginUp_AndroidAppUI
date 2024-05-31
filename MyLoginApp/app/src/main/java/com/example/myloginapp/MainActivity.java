package com.example.myloginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

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


        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.pasword);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        // admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                    {
                        // correct
                        Toast.makeText(MainActivity.this, "Вход успешно выполнен!", Toast.LENGTH_SHORT).show();
                    }
                else
                {
                    // incorrect
                    Toast.makeText(MainActivity.this, "Увы, такого пользователя не существует, или введен не верно пароль!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}