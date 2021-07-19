package com.example.program8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txt;
    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, save, call, hash, star, del, plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.editTextTextPersonName);

        one = findViewById(R.id.button7);
        one.setOnClickListener(this);

        two = findViewById(R.id.button8);
        two.setOnClickListener(this);

        three = findViewById(R.id.button9);
        three.setOnClickListener(this);

        four = findViewById(R.id.button10);
        four.setOnClickListener(this);

        five = findViewById(R.id.button11);
        five.setOnClickListener(this);

        six = findViewById(R.id.button12);
        six.setOnClickListener(this);

        seven = findViewById(R.id.button13);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.button14);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.button15);
        nine.setOnClickListener(this);

        zero = findViewById(R.id.button16);
        zero.setOnClickListener(this);

        call = findViewById(R.id.button17);
        call.setOnClickListener(this);

        save = findViewById(R.id.button18);
        save.setOnClickListener(this);

        clear = findViewById(R.id.btnclr);
        clear.setOnClickListener(this);

        hash = findViewById(R.id.button20);
        hash.setOnClickListener(this);

        star = findViewById(R.id.button21);
        star.setOnClickListener(this);

        del = findViewById(R.id.button22);
        del.setOnClickListener(this);

        plus = findViewById(R.id.button23);
        plus.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.equals(one))
            txt.append("1");
        if (v.equals(two))
            txt.append("2");
        if (v.equals(three))
            txt.append("3");
        if (v.equals(four))
            txt.append("4");
        if (v.equals(five))
            txt.append("5");
        if (v.equals(six))
            txt.append("6");
        if (v.equals(seven))
            txt.append("7");
        if (v.equals(eight))
            txt.append("8");
        if (v.equals(nine))
            txt.append("9");
        if (v.equals(zero))
            txt.append("0");
        if (v.equals(hash))
            txt.append("#");
        if (v.equals(star))
            txt.append("*");
        if (v.equals(del))
            txt.setText("");
        if (v.equals(plus))
            txt.append("+");

        if (v.equals(clear)) {
            String data = txt.getText().toString();
            if (data.length() > 0) {
                txt.setText(data.substring(0, data.length() - 1));
            } else {
                txt.setText("");
            }
        }

        if (v.equals(call)) {
            String data = txt.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + data));
            startActivity(intent);
        }

        if (v.equals(save)) {
            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.NAME, "Unknown");
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, txt.getText().toString());
            startActivity(intent);
        }
    }
}