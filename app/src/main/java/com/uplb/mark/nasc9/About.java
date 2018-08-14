package com.uplb.mark.nasc9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    Button about_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        about_exit = findViewById(R.id.about_exit_button);
        about_exit.setOnTouchListener(exit_about);

    }

    View.OnTouchListener exit_about = new View.OnTouchListener()
    {
        public boolean onTouch(View v, MotionEvent e)
        {
            finish();
            return true;
        }
    };
}
