package com.example.marketwatchsystem.AL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.marketwatchsystem.PL.LoginPL;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterAL {
    private Context context;

    public void CreateNewAccount(final String name, final String email, final String password, final Context context1,
                                 final ProgressDialog loadingBar, final FirebaseAuth mAuth) {
       context = context1;
        if(TextUtils.isEmpty(email)){
            Toast.makeText(context, "Please enter your email..", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context, "Please enter your password..", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Creating New Account");
            loadingBar.setMessage("Plaese wait, while we are creating new account for you...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(context, "Account created Successfully", Toast.LENGTH_SHORT).show();
                                CreateNewDatabase(name,email,password,mAuth);
                                loadingBar.dismiss();
                            }
                            else{
                                String message = task.getException().toString();
                                Toast.makeText(context, "Error: "+message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });


        }
    }

    private void CreateNewDatabase(String name,String email, String password,FirebaseAuth mAuth) {
        HashMap<String, Object> TimeAndDate = new HashMap<>();
        TimeAndDate.put("DateAndTime","");
        String currentUserId = mAuth.getCurrentUser().getUid();

        DocumentReference time = FirebaseFirestore.getInstance().collection("Client").document(currentUserId);
        time.set(TimeAndDate);

        Map<String, Object> reg_entry = new HashMap<>();
        reg_entry.put("Id", mAuth.getUid());
        reg_entry.put("Name", name);
        reg_entry.put("Email", email);
        reg_entry.put("Password", password);
        // reg_entry.put("Online_status", "offline");


        FirebaseFirestore.getInstance().collection("Client").document(currentUserId).set(reg_entry)
                .addOnSuccessListener(new OnSuccessListener< Void >() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        /*Toast.makeText(context, "User Registered",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);*/
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });

    }

    public void SendUserToLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginPL.class);
        context.startActivity(intent);
    }
}
