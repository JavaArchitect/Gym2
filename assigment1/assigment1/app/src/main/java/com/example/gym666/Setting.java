package com.example.gym666;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public void homepage(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void train(View view) {
        Intent intent = new Intent(this, Train.class);
        startActivity(intent);
    }
    public void myself(View view) {
        Intent intent = new Intent(this, Myself.class);
        startActivity(intent);
    }
    public void friends(View view) {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }
    public void setting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }
}
