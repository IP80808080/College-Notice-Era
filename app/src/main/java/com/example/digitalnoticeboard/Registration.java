package com.example.digitalnoticeboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    private TextView rePage;
    private Button u2Register;
    private EditText u2username;
    private EditText u2Phone;
    private EditText u2Email;
    private EditText u2SIS_ID;
    private EditText u2Password;
    private Spinner department;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);


        rePage =findViewById(R.id.rePage);
        u2Register =findViewById(R.id.u2Register);
        u2username =findViewById(R.id.u2username);
        u2Phone =findViewById(R.id.u2Phone);
        u2Email =findViewById(R.id.u2Email);
        u2SIS_ID =findViewById(R.id.u2SIS_ID);
        u2Password =findViewById(R.id.u2Password);
        department =findViewById(R.id.department);

        rePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });

        u2Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (u2username.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter your Name",Toast.LENGTH_SHORT).show();
                }

                if (u2Email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter your Email",Toast.LENGTH_SHORT).show();
                }

                if (u2Phone.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter your Number",Toast.LENGTH_SHORT).show();
                }

                if (u2Password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter your Password",Toast.LENGTH_SHORT).show();
                }

                if (u2SIS_ID.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter your SIS ID",Toast.LENGTH_SHORT).show();
                }

                if (department.getSelectedItem().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Select the Department",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}