package com.example.digitalnoticeboard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(" Helpful College App")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("kasambe.kamlesh1@gmail.com ")
                .addWebsite("https://www.Myme.temp")
                .addYoutube("Kamlesh_Kasambe")
                .addPlayStore("com.example.Digital_Notice_Board")
                .addInstagram("kasambekamlesh")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by Kamlesh Kasambe", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About_Us.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}