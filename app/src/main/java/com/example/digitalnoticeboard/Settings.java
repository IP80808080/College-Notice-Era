package com.example.digitalnoticeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    private CardView card3;
    private CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, About_Us.class);
                startActivity(intent);
            }
        });

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, ChangeInfo.class);
                startActivity(intent);
            }
        });
    }
}