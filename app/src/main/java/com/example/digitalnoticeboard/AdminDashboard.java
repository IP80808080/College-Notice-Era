package com.example.digitalnoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminDashboard extends AppCompatActivity {

    FloatingActionButton more, aboutUs, logOut;
    Animation open_anime, close_anime, from_bottom, to_bottom;
    boolean isOpen = false;
    private FloatingActionButton setting;
    private CircleImageView profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        more = (FloatingActionButton) findViewById(R.id.more);
        aboutUs = (FloatingActionButton) findViewById(R.id.setting);
        logOut = (FloatingActionButton) findViewById(R.id.logOut);

        open_anime = AnimationUtils.loadAnimation(this,R.anim.open_anime);
        close_anime = AnimationUtils.loadAnimation(this,R.anim.close_anime);

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.from_bottom);
        to_bottom = AnimationUtils.loadAnimation(this,R.anim.to_bottom);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationF();
            }
        });


    }

    private void animationF(){
        if (isOpen){
            more.startAnimation(from_bottom);
            aboutUs.startAnimation(close_anime);
            logOut.startAnimation(close_anime);
            aboutUs.setClickable(false);
            logOut.setClickable(false);
            isOpen=false;
        }
        else {
            more.startAnimation(to_bottom);
            aboutUs.startAnimation(open_anime);
            logOut.startAnimation(open_anime);
            aboutUs.setClickable(true);
            logOut.setClickable(true);
            isOpen=true;
        }

        setting.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, Settings.class);
                startActivity(intent);
            }
        });

        profile_image = findViewById(R.id.profile_image);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this, EditProfile.class);
                startActivity(intent);
            }
        });
    }
}