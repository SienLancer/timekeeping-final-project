package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignInForStaffActivity extends AppCompatActivity {
    ImageButton backSignInS_imgBtn;
    TextView signUpS_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_staff);

        backSignInS_imgBtn = findViewById(R.id.backSignInS_imgBtn);
        signUpS_txt = findViewById(R.id.signUpS_txt);

        backSignInS_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signUpS_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInForStaffActivity.this, SignUpForStaffActivity.class);
                startActivity(i);
            }
        });
    }
}