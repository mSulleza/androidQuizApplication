package com.uplb.mark.nasc9;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class LevelSelection extends AppCompatActivity {
    Button home_button, level_1_button, level_2_button, level_3_button, level_4_button, level_5_button;
    DatabaseCRUD db_Helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        db_Helper = new DatabaseCRUD(this);

        home_button = findViewById(R.id.home_button);
        level_1_button = findViewById(R.id.level_1_button);
        level_2_button = findViewById(R.id.level_2_button);
        level_3_button = findViewById(R.id.level_3_button);
        level_4_button = findViewById(R.id.level_4_button);
        level_5_button = findViewById(R.id.level_5_button);

        home_button.setOnTouchListener(home_listener);
        level_1_button.setOnTouchListener(level_1_listener);
        level_2_button.setOnTouchListener(level_2_listener);
        level_3_button.setOnTouchListener(level_3_listener);
        level_4_button.setOnTouchListener(level_4_listener);
        level_5_button.setOnTouchListener(level_5_listener);

        if (db_Helper.isCompleted(0) )
        {
            level_2_button.setBackgroundResource(R.drawable.level_1_up);
            level_2_button.setEnabled(true);
        }
        else
        {
            level_2_button.setBackgroundResource(R.drawable.level2_lock);
            level_2_button.setEnabled(false);
        }

        if (db_Helper.isCompleted(1) )
        {
            level_3_button.setBackgroundResource(R.drawable.level_3_up);
            level_3_button.setEnabled(true);
        }
        else
        {
            level_3_button.setBackgroundResource(R.drawable.level3_lock);
            level_3_button.setEnabled(false);
        }
        if (db_Helper.isCompleted(2) )
        {
            level_4_button.setBackgroundResource(R.drawable.level_4_up);
            level_4_button.setEnabled(true);
        }
        else
        {
            level_4_button.setBackgroundResource(R.drawable.level4_lock);
            level_4_button.setEnabled(false);
        }
        if (db_Helper.isCompleted(3) )
        {
            level_5_button.setBackgroundResource(R.drawable.level_5_up);
            level_5_button.setEnabled(true);
        }
        else
        {
            level_5_button.setBackgroundResource(R.drawable.level5_lock);
            level_5_button.setEnabled(false);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        startActivity(getIntent());
        level_1_button.setBackgroundResource(R.drawable.level_1_up);

        if (db_Helper.isCompleted(0) )
        {
            level_2_button.setBackgroundResource(R.drawable.level_2_up);
            level_2_button.setEnabled(true);
        }
        else
        {
            level_2_button.setBackgroundResource(R.drawable.level2_lock);
            level_2_button.setEnabled(false);
        }

        if (db_Helper.isCompleted(1) )
        {
            level_3_button.setBackgroundResource(R.drawable.level_3_up);
            level_3_button.setEnabled(true);
        }
        else
        {
            level_3_button.setBackgroundResource(R.drawable.level3_lock);
            level_3_button.setEnabled(false);
        }
        if (db_Helper.isCompleted(2) )
        {
            level_4_button.setBackgroundResource(R.drawable.level_4_up);
            level_4_button.setEnabled(true);
        }
        else
        {
            level_4_button.setBackgroundResource(R.drawable.level4_lock);
            level_4_button.setEnabled(false);
        }

        if (db_Helper.isCompleted(3) )
        {
            level_5_button.setBackgroundResource(R.drawable.level_5_up);
            level_5_button.setEnabled(true);
        }
        else
        {
            level_5_button.setBackgroundResource(R.drawable.level5_lock);
            level_5_button.setEnabled(false);
        }
    }

    View.OnTouchListener home_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            home_button.setBackgroundResource(R.drawable.home_down);
            LevelSelection.this.finish();
            return false;
        }
    };

    View.OnTouchListener level_1_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            level_1_button.setBackgroundResource(R.drawable.level_1_down);
            Intent level_1_intent = new Intent(LevelSelection.this, Level_1.class);
            startActivity(level_1_intent);
            return false;
        }
    };

    View.OnTouchListener level_2_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            level_2_button.setBackgroundResource(R.drawable.level_2_down);
            Intent level_2_intent = new Intent(LevelSelection.this, Level_2.class);
            startActivity(level_2_intent);
            return false;
        }
    };

    View.OnTouchListener level_3_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            level_3_button.setBackgroundResource(R.drawable.level_3_down);
            Intent level_3_intent = new Intent(LevelSelection.this, Level_3.class);
            startActivity(level_3_intent);
            return false;
        }
    };

    View.OnTouchListener level_4_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            level_4_button.setBackgroundResource(R.drawable.level_4_down);
            Intent level_4_intent = new Intent(LevelSelection.this, Level_4.class);
            startActivity(level_4_intent);
            return false;
        }
    };

    View.OnTouchListener level_5_listener = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            level_5_button.setBackgroundResource(R.drawable .level_5_down);
            Intent level_5_intent = new Intent(LevelSelection.this, Level_5.class);
            startActivity(level_5_intent);
            return false;
        }
    };

}
