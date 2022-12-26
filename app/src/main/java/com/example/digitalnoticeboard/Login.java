package com.example.digitalnoticeboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private TextView logInQuesion;
    private TextView forgot;
    private TextView help;
    private Button logIN;
    private EditText Email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logInQuesion = findViewById(R.id.logInQuestion);

        logInQuesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

        forgot = findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Verification.class);
                startActivity(intent);
            }
        });

        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Emergency.class);
                startActivity(intent);
            }
        });

        logIN =findViewById(R.id.logIN);
        Email =findViewById(R.id.Email);
        password =findViewById(R.id.password);

        logIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter SIS ID", Toast.LENGTH_SHORT).show();
                }

                if (password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Password", Toast.LENGTH_SHORT).show();
                }

                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

                if (!(Email.getText().toString().isEmpty() && password.getText().toString().isEmpty())){

                    firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(Login.this, AdminDashboard.class);
                                startActivity(intent);
                            }

                            else {
                                Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}