package com.immense.manishelectronics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


import com.google.firebase.auth.FirebaseAuth;

import static android.R.layout.simple_spinner_item;


public class SecondActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> arrayAdapter, arrayAdapter2;
    TextView tv;
    Button button,button2;
    MaterialBetterSpinner spinner1, spinner2;
    String s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();
        final String s = i.getStringExtra("Name");

        tv = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.Signoutbutton);
        button2 = (Button) findViewById(R.id.b1);
        spinner1 = (MaterialBetterSpinner) findViewById(R.id.spinner1);
        spinner2 = (MaterialBetterSpinner) findViewById(R.id.spinner2);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Region, simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        tv.setText(s);
        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(this, R.array.SouthMumbai, simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(),Firebase.class);
                    i.putExtra("spinner1",spinner1.getText().toString());
                    i.putExtra("spinner2",spinner2.getText().toString());
                    i.putExtra("Username",s);
                    startActivity(i);
                }
            });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        spinner1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               String s1 = spinner1.getText().toString();
               if(s1.equals("South Mumbai"))
               {
                   ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getBaseContext(), R.array.SouthMumbai, simple_spinner_item);
                   arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner2.setAdapter(arrayAdapter2);
               }
               else if(s1.equals("Eastern Suburbs"))
               {
                   ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getBaseContext(), R.array.EasternSuburbs, simple_spinner_item);
                   arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner2.setAdapter(arrayAdapter2);
               }
               else if(s1.equals("Western Suburbs"))
               {
                   ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getBaseContext(), R.array.WesternSuburbs, simple_spinner_item);
                   arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner2.setAdapter(arrayAdapter2);
               }
               else
               {
                   ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getBaseContext(), R.array.HarbourSuburbs, simple_spinner_item);
                   arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner2.setAdapter(arrayAdapter2);
               }
            }
        });
    }



}
