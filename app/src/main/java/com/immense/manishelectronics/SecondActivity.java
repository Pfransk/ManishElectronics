package com.immense.manishelectronics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class SecondActivity extends AppCompatActivity{
TextView tv;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i =getIntent();
        String s = i.getStringExtra("Name");
tv = (TextView) findViewById(R.id.tv);
button = (Button) findViewById(R.id.Signoutbutton);
tv.setText(s);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    });
    }

}
