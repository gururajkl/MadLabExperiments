package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnplus, btnminus, btndiv, btnmulti, btnequal, btnclear, btndot;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = findViewById(R.id.butone);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btntwo);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btnplus = findViewById(R.id.btnplus);
        btnplus.setOnClickListener(this);

        btnminus = findViewById(R.id.btnminus);
        btnminus.setOnClickListener(this);

        btnmulti = findViewById(R.id.btnmulti);
        btnmulti.setOnClickListener(this);

        btndiv = findViewById(R.id.btndiv);
        btndiv.setOnClickListener(this);

        btnequal = findViewById(R.id.btnequal);
        btnequal.setOnClickListener(this);

        btnclear = findViewById(R.id.btnclear);
        btnclear.setOnClickListener(this);

        btndot = findViewById(R.id.btndot);
        btndot.setOnClickListener(this);

        text = findViewById(R.id.txt);
        text.setText("");
    }

    public void onClick(View v) {
        if (v.equals(btn0))
            text.append("0");
        if (v.equals(btn1))
            text.append("1");
        if (v.equals(btn2))
            text.append("2");
        if (v.equals(btn3))
            text.append("3");
        if (v.equals(btn4))
            text.append("4");
        if (v.equals(btn5))
            text.append("5");
        if (v.equals(btn6))
            text.append("6");
        if (v.equals(btn7))
            text.append("7");
        if (v.equals(btn8))
            text.append("8");
        if (v.equals(btn9))
            text.append("9");
        if (v.equals(btnplus))
            text.append("+");
        if (v.equals(btnminus))
            text.append("-");
        if (v.equals(btnmulti))
            text.append("*");
        if (v.equals(btndiv))
            text.append("/");
        if (v.equals(btnclear))
            text.setText("");
        if (v.equals(btndot))
            text.append(".");

        if (v.equals(btnequal)) {
            try {
                String data = text.getText().toString();
                if (data.contains("/")) {
                    String[] operand = data.split(Pattern.quote("/"));
                    if (operand.length == 2) {
                        double operand1 = Double.parseDouble(operand[0]);
                        double operand2 = Double.parseDouble(operand[1]);
                        double result = operand1 / operand2;
                        text.setText(String.valueOf(result));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("+")) {
                    String[] operand = data.split(Pattern.quote("+"));
                    if (operand.length == 2) {
                        double operand1 = Double.parseDouble(operand[0]);
                        double operand2 = Double.parseDouble(operand[1]);
                        double result = operand1 + operand2;
                        text.setText(String.valueOf(result));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("-")) {
                    String[] operand = data.split(Pattern.quote("-"));
                    if (operand.length == 2) {
                        double operand1 = Double.parseDouble(operand[0]);
                        double operand2 = Double.parseDouble(operand[1]);
                        double result = operand1 - operand2;
                        text.setText(String.valueOf(result));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("*")) {
                    String[] operand = data.split(Pattern.quote("*"));
                    if (operand.length == 2) {
                        double operand1 = Double.parseDouble(operand[0]);
                        double operand2 = Double.parseDouble(operand[1]);
                        double result = operand1 * operand2;
                        text.setText(String.valueOf(result));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
            }
        }
    }
}