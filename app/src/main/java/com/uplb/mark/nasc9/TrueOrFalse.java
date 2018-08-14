package com.uplb.mark.nasc9;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TrueOrFalse extends AppCompatActivity {
    Button true_button, false_button;
    TextView question_textview;
    DatabaseCRUD db_CRUD;
    int question_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_or_false);

        question_textview = findViewById(R.id.tf_question_textview);
        true_button = findViewById(R.id.true_button);
        false_button = findViewById(R.id.false_button);
        true_button.setOnTouchListener(true_listener);
        false_button.setOnTouchListener(false_listener);
        db_CRUD = new DatabaseCRUD(this);

        question_id = getIntent().getIntExtra("QUESTION_ID", 0);

        if (db_CRUD.isAnswered(question_id))
        {
            if (db_CRUD.getQuestion(question_id).getString(3) == "True")
            {
                true_button.setBackgroundResource(R.drawable.true_down);
            }
            else
            {
                false_button.setBackgroundResource(R.drawable.false_down);
            }
            true_button.setEnabled(false);
            false_button.setEnabled(false);
        }

        question_textview.setText(db_CRUD.getQuestion(question_id).getString(2));
    }

    View.OnTouchListener true_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            true_button.setBackgroundResource(R.drawable.true_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "True";

            if (input.toLowerCase().contains(correct_answer.toLowerCase()))
            {
                db_CRUD.answeredCorrect(question_id);
                finish();
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                true_button.setBackgroundResource(R.drawable.true_up);
            }

            return true;
        }
    };

    View.OnTouchListener false_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            false_button.setBackgroundResource(R.drawable.false_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "False";

            if (input.toLowerCase().contains(correct_answer.toLowerCase()))
            {
                db_CRUD.answeredCorrect(question_id);
                finish();
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "Incorrect Answer!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                false_button.setBackgroundResource(R.drawable.false_up);
            }
            return true;
        }
    };


    protected void true_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        true_button.setBackgroundResource(R.drawable.true_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "True";

        if (input.toLowerCase().contains(correct_answer.toLowerCase()))
        {
            db_CRUD.answeredCorrect(question_id);
            finish();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect Answer!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            true_button.setBackgroundResource(R.drawable.true_up);
        }
    }

    protected void false_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        false_button.setBackgroundResource(R.drawable.false_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "False";

        if (input.toLowerCase().contains(correct_answer.toLowerCase()))
        {
            db_CRUD.answeredCorrect(question_id);
            finish();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect Answer!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            false_button.setBackgroundResource(R.drawable.false_up);
        }
    }
}
