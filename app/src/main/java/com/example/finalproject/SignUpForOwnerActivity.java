package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpForOwnerActivity extends AppCompatActivity {
    Button createAccO_btn;
    EditText usernameOSignUp_edt, pwOSignUp_edt,rePwOSignUp_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_for_owner);

        createAccO_btn = findViewById(R.id.createAccO_btn);
        usernameOSignUp_edt = findViewById(R.id.usernameOSignUp_edt);
        pwOSignUp_edt = findViewById(R.id.pwOSignUp_edt);
        rePwOSignUp_edt = findViewById(R.id.rePwOSignUp_edt);


        createAccO_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUp();

            }
        });



    }

    private void onClickSignUp() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String username, password, repassword;
        username = usernameOSignUp_edt.getText().toString();
        password = pwOSignUp_edt.getText().toString();
        repassword = rePwOSignUp_edt.getText().toString();


        if (password.matches(repassword)){
            mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignUpForOwnerActivity.this, SignUpSuccessOwner.class);
                        startActivity(i);
                        finishAffinity();
                    }else {
                        Toast.makeText(getApplicationContext(), "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
        }

    }


}