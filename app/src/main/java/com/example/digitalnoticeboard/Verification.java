package com.example.digitalnoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Verification extends AppCompatActivity {

    private Button btnVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);

        btnVector = findViewById(R.id.btnVector);
        btnVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Verification.this, ResetPassword.class);
                startActivity(intent);
            }
        });
    }
}