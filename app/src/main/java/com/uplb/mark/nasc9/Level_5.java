package com.uplb.mark.nasc9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Level_5 extends AppCompatActivity {
    Button question_1_button, question_2_button, question_3_button, question_4_button, question_5_button, question_6_button, question_7_button, question_8_button, question_9_button, question_10_button, question_home_button;
    DatabaseCRUD db_CRUD;
    boolean completed = true;
    @Override
    protected void onResume() {
        super.onResume();
        if (db_CRUD.isAnswered(40)) {
            question_1_button.setBackgroundResource(R.drawable.l1_q1_done);
        }
        else
        {
            question_1_button.setBackgroundResource(R.drawable.l1_q1_up);
            completed = false;
        }


        if (db_CRUD.isAnswered(41)) {
            question_2_button.setBackgroundResource(R.drawable.l1_q2_done);
        }
        else
        {
            question_2_button.setBackgroundResource(R.drawable.l1_q2_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(42)) {
            question_3_button.setBackgroundResource(R.drawable.l1_q3_done);
        }
        else
        {
            question_3_button.setBackgroundResource(R.drawable.l1_q3_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(43)) {
            question_4_button.setBackgroundResource(R.drawable.l1_q4_done);
        }
        else
        {
            question_4_button.setBackgroundResource(R.drawable.l1_q4_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(44)) {
            question_5_button.setBackgroundResource(R.drawable.l1_q5_done);
        }
        else
        {
            question_5_button.setBackgroundResource(R.drawable.l1_q5_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(45)) {
            question_6_button.setBackgroundResource(R.drawable.l1_q6_done);
        }
        else
        {
            question_6_button.setBackgroundResource(R.drawable.l1_q6_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(46)) {
            question_7_button.setBackgroundResource(R.drawable.l1_q7_done);
        }
        else
        {
            question_7_button.setBackgroundResource(R.drawable.l1_q7_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(47)) {
            question_8_button.setBackgroundResource(R.drawable.l1_q8_done);
        }
        else
        {
            question_8_button.setBackgroundResource(R.drawable.l1_q8_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(48)) {
            System.out.println("ANSWERED CORRECTLY");
            question_9_button.setBackgroundResource(R.drawable.l1_q9_done);
        }
        else
        {
            question_9_button.setBackgroundResource(R.drawable.l1_q9_up);
            completed = false;
        }

        if (db_CRUD.isAnswered(49)) {
            question_10_button.setBackgroundResource(R.drawable.l1_q10_done);
        }
        else
        {
            question_10_button.setBackgroundResource(R.drawable.l1_q10_up);
            completed = false;
        }

        question_home_button.setBackgroundResource(R.drawable.l1_home_up);

        if (completed)
        {
            db_CRUD.levelCompleted(4);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);

        db_CRUD = new DatabaseCRUD(this);

        question_1_button = findViewById(R.id.l5_q1_button);
        if (db_CRUD.isAnswered(40)) {
            question_1_button.setBackgroundResource(R.drawable.l1_q1_done);
        }
        question_1_button.setOnTouchListener(l5_q1_touch);


        question_2_button = findViewById(R.id.l5_q2_button);
        if (db_CRUD.isAnswered(41)) {
            question_2_button.setBackgroundResource(R.drawable.l1_q2_done);
        }
        question_2_button.setOnTouchListener(l5_q2_touch);


        question_3_button = findViewById(R.id.l5_q3_button);
        if (db_CRUD.isAnswered(42)) {
            question_3_button.setBackgroundResource(R.drawable.l1_q3_done);
        }
        question_3_button.setOnTouchListener(l5_q3_touch);


        question_4_button = findViewById(R.id.l5_q4_button);
        if (db_CRUD.isAnswered(43)) {
            question_4_button.setBackgroundResource(R.drawable.l1_q4_done);
        }
        question_4_button.setOnTouchListener(l5_q4_touch);


        question_5_button = findViewById(R.id.l5_q5_button);
        if (db_CRUD.isAnswered(44)) {
            question_5_button.setBackgroundResource(R.drawable.l1_q5_done);
        }
        question_5_button.setOnTouchListener(l5_q5_touch);


        question_6_button = findViewById(R.id.l5_q6_button);
        if (db_CRUD.isAnswered(45)) {
            question_6_button.setBackgroundResource(R.drawable.l1_q6_done);
        }
        question_6_button.setOnTouchListener(l5_q6_touch);


        question_7_button = findViewById(R.id.l5_q7_button);
        if (db_CRUD.isAnswered(46)) {
            question_7_button.setBackgroundResource(R.drawable.l1_q7_done);
        }
        question_7_button.setOnTouchListener(l5_q7_touch);


        question_8_button = findViewById(R.id.l5_q8_button);
        if (db_CRUD.isAnswered(47)) {
            question_8_button.setBackgroundResource(R.drawable.l1_q8_done);
        }
        question_8_button.setOnTouchListener(l5_q8_touch);


        question_9_button = findViewById(R.id.l5_q9_button);
        if (db_CRUD.isAnswered(48)) {
            System.out.println("ANSWERED CORRECTLY");
            question_9_button.setBackgroundResource(R.drawable.l1_q9_done);
        }
        question_9_button.setOnTouchListener(l5_q9_touch);


        question_10_button = findViewById(R.id.l5_q10_button);
        if (db_CRUD.isAnswered(49)) {
            question_10_button.setBackgroundResource(R.drawable.l1_q10_done);
        }
        question_10_button.setOnTouchListener(l5_q10_touch);

        question_home_button = findViewById(R.id.l4_home_button);
        question_home_button.setOnTouchListener(l5_home_touch);
    }

    View.OnTouchListener l5_home_touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_home_button.setBackgroundResource(R.drawable.l1_home_down);
            finish();

            return true;
        }
    };

    View.OnTouchListener l5_q1_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_1_button.setBackgroundResource(R.drawable.l1_q1_down);
            Intent q1_intent = new Intent(Level_5.this, TrueOrFalse.class);
            q1_intent.putExtra("QUESTION_ID", 40);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q2_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_2_button.setBackgroundResource(R.drawable.l1_q2_down);
            Intent q1_intent = new Intent(Level_5.this, TrueOrFalse.class);
            q1_intent.putExtra("QUESTION_ID", 41);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q3_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_3_button.setBackgroundResource(R.drawable.l1_q3_down);
            Intent q1_intent = new Intent(Level_5.this, l1_question_identification_activity.class);
            q1_intent.putExtra("QUESTION_ID", 42);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q4_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_4_button.setBackgroundResource(R.drawable.l1_q4_down);
            Intent q1_intent = new Intent(Level_5.this, TrueOrFalse.class);
            q1_intent.putExtra("QUESTION_ID", 43);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q5_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_5_button.setBackgroundResource(R.drawable.l1_q5_down);
            Intent q1_intent = new Intent(Level_5.this, MultipleChoice.class);
            q1_intent.putExtra("QUESTION_ID", 44);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q6_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_6_button.setBackgroundResource(R.drawable.l1_q6_down);
            Intent q1_intent = new Intent(Level_5.this, l1_question_identification_activity.class);
            q1_intent.putExtra("QUESTION_ID", 45);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q7_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_7_button.setBackgroundResource(R.drawable.l1_q7_down);
            Intent q1_intent = new Intent(Level_5.this, TrueOrFalse.class);
            q1_intent.putExtra("QUESTION_ID", 46);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q8_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_8_button.setBackgroundResource(R.drawable.l1_q8_down);
            Intent q1_intent = new Intent(Level_5.this, l1_question_identification_activity.class);
            q1_intent.putExtra("QUESTION_ID", 47);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q9_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_9_button.setBackgroundResource(R.drawable.l1_q9_down);
            Intent q1_intent = new Intent(Level_5.this, l1_question_identification_activity.class);
            q1_intent.putExtra("QUESTION_ID", 48);
            startActivity(q1_intent);
            return true;
        }
    };

    View.OnTouchListener l5_q10_touch = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            question_10_button.setBackgroundResource(R.drawable.l1_q10_down);
            Intent q1_intent = new Intent(Level_5.this, MultipleChoice.class);
            q1_intent.putExtra("QUESTION_ID", 49);
            startActivity(q1_intent);
            return true;
        }
    };
}
