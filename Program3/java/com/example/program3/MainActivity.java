package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button signup;
    String rgx = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$!@])[A-Za-z\\d$!@]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usrname);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.button);
        signup.setOnClickListener(this);
    }

    public void onClick(View v) {
        String name = username.getText().toString();
        String pass = password.getText().toString();

        if (validpass(pass)) {
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("pass", pass);

            Intent intent = new Intent(this, login.class);
            intent.putExtra("data", bundle);
            Toast.makeText(getBaseContext(), "Signed In", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validpass (String pass)
    {
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }
}