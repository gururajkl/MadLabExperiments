package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    String user, pass;
    int count = 0, war = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.usrname);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);
        login.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("data");
        user = bundle.getString("name");
        pass = bundle.getString("pass");
    }

    public void onClick(View v) {
        String user1 = username.getText().toString();
        String pass1 = password.getText().toString();

        if (user.equals(user1) && pass.equals(pass1)) {
            Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
        }
        else {
            count ++;
            if (count == 3) {
                login.setEnabled(false);
                Toast.makeText(getBaseContext(), "Login Attempts Failed", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getBaseContext(), "Login Failed\n " + war-- + " Attempts Left", Toast.LENGTH_LONG).show();
            }
        }
    }
}