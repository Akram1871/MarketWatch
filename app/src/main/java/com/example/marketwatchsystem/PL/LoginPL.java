package com.example.marketwatchsystem.PL;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marketwatchsystem.AL.LoginAL;
import com.example.marketwatchsystem.R;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPL extends AppCompatActivity {

    private ProgressDialog loadingBar;
    private Button LoginButton, PhoneLoginButton;
    private EditText UserEmail, UserPassword;
    private TextView NeedNewAccountLink;

    FirebaseFirestore db;
    DocumentReference ref;
    private CheckBox checkBox;
    private String type="NonAdmin";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db = FirebaseFirestore.getInstance();

        InitializeFields();


        NeedNewAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new LoginAL().SendUserToRegisterActivity(LoginPL.this);
            }
        });


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final String email = UserEmail.getText().toString();
                final String password = UserPassword.getText().toString();
                new LoginAL().AllowUserToLogin(email,password,LoginPL.this,loadingBar,type);
                UserEmail.setText("");
                UserPassword.setText("");
            }
        });

        PhoneLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent phoneLoginIntent = new Intent(LoginPL.this, PhoneLoginPL.class);
                phoneLoginIntent.putExtra("type",type);
                startActivity(phoneLoginIntent);
            }
        });
    }




    @Override
    protected void onStart()
    {
        super.onStart();

       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // if (user != null)
        {
        //    SendUserToMainActivity();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finishAndRemoveTask();
    }



    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            type="Admin";
        }
        else {
            type="NonAdmin";
        }


    }

    private void InitializeFields()
    {
        LoginButton = (Button) findViewById(R.id.login_button);
        PhoneLoginButton = (Button) findViewById(R.id.phone_login_button);
        UserEmail = (EditText) findViewById(R.id.login_email);
        UserPassword = (EditText) findViewById(R.id.login_password);
        NeedNewAccountLink = (TextView) findViewById(R.id.need_new_account_link);
        checkBox = findViewById(R.id.checkbox);
        loadingBar = new ProgressDialog(this);
    }






}

