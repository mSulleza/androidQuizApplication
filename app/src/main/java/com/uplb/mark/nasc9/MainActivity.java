package com.uplb.mark.nasc9;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton play_image_button;
    Button about_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_image_button = findViewById(R.id.playButton);
        play_image_button.setOnTouchListener(play_button_pressed);
        about_button = findViewById(R.id.about_button);
        about_button.setOnTouchListener(about_open);
        this.deleteDatabase("main_db.db");
    }

    @Override
    protected void onResume() {
        super.onResume();
        play_image_button.setBackgroundResource(R.drawable.play_button);
    }

    View.OnTouchListener play_button_pressed = new View.OnTouchListener()
    {
        public boolean onTouch(View v, MotionEvent e)
        {
            int action = e.getAction();
            if (action == MotionEvent.ACTION_DOWN)
            {
                play_image_button.setBackgroundResource(R.drawable.play_button_down);
                Intent level_intent = new Intent(MainActivity.this, LevelSelection.class);
                startActivity(level_intent);
            }
            return true;
        }
    };

    View.OnTouchListener about_open = new View.OnTouchListener()
    {
        public boolean onTouch(View v, MotionEvent e)
        {
            play_image_button.setBackgroundResource(R.drawable.play_button_down);
            Intent about_intent = new Intent(MainActivity.this, About.class);
            startActivity(about_intent);
            return true;
        }
    };
}
