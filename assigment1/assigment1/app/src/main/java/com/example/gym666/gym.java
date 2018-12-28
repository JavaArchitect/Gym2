package com.example.gym666;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class gym extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
    }
    /** Called when the user taps the Send button */
    public void login(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }




    /** Called when the user taps the Send button */
    public void register(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
