package com.example.marketwatchsystem.AL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.marketwatchsystem.Client;
import com.example.marketwatchsystem.PL.RegisterPL;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAL {

    public void AllowUserToLogin(String email, String password, final Context context,
                                 final ProgressDialog loadingBar, final String type)
    {
        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(context, "Please enter email...", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(context, "Please enter password...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Sign In");
            loadingBar.setMessage("Please wait....");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(context, "Logged in Successful" , Toast.LENGTH_SHORT).show();
                                SendUserToMainActivity(type,context);
                                loadingBar.dismiss();
                            }
                            else
                            {
                                //String message = task.getException().toString();
                                Toast.makeText(context, "Your Information is not Valid", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });

        }
    }


    public void SendUserToMainActivity(String type,Context context)
    {
        UserType.getUserTypeInstance().setType(type);
        Intent mainIntent = new Intent(context, Client.class);
        context.startActivity(mainIntent);
    }

    public void SendUserToRegisterActivity(Context context1)
    {
        Intent registerIntent = new Intent(context1, RegisterPL.class);
        context1.startActivity(registerIntent);
    }

}
