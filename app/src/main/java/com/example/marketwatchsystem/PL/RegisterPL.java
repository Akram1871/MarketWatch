package com.example.marketwatchsystem.PL;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marketwatchsystem.AL.RegisterAL;
import com.example.marketwatchsystem.R;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterPL extends AppCompatActivity {

    private EditText userEmail, userPassword,userName;
    private Button createAccountButton;
    private TextView alreadyHaveAccountLink;
    private FirebaseAuth mAuth;

    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        InitializeFields();

         alreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new RegisterAL().SendUserToLoginActivity(RegisterPL.this);
            }
        });

         createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = userName.getText().toString();
                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                new RegisterAL().CreateNewAccount(name,email,password,RegisterPL.this,loadingBar,mAuth);
                userName.setText("");
                userEmail.setText("");
                userPassword.setText("");
            }
        });
    }


    private void InitializeFields() {
        userName = findViewById(R.id.register_name);
        userEmail = findViewById(R.id.register_email);
        userPassword = findViewById(R.id.register_password);
        createAccountButton = findViewById(R.id.register_button);
        alreadyHaveAccountLink = findViewById(R.id.already_account_link);
        loadingBar = new ProgressDialog(this);
    }


}

