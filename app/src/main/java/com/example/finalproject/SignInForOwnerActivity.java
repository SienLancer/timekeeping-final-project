package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInForOwnerActivity extends AppCompatActivity {
    ImageButton backSignInO_imgBtn;
    EditText usernameOLogin_edt, pwOLogin_edt;
    TextView signUpO_txt;
    Button loginO_btn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_owner);
        mAuth = FirebaseAuth.getInstance();

        backSignInO_imgBtn = findViewById(R.id.backSignInO_imgBtn);
        signUpO_txt = findViewById(R.id.signUpO_txt);
        loginO_btn = findViewById(R.id.loginO_btn);
        pwOLogin_edt = findViewById(R.id.pwOLogin_edt);
        usernameOLogin_edt = findViewById(R.id.usernameOLogin_edt);

//        backSignInO_imgBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        loginO_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        signUpO_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInForOwnerActivity.this, SignUpForOwnerActivity.class);
                startActivity(i);
            }
        });
    }

    private void login() {
        String username, password;
        username = usernameOLogin_edt.getText().toString();
        password = pwOLogin_edt.getText().toString();
        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Vui lòng nhập lại cái username giùm!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Vui lòng nhập lại cái pass giùm!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignInForOwnerActivity.this, StaffHomeActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}