package com.uplb.mark.nasc9;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class l1_question_identification_activity extends AppCompatActivity {
    TextView question_text;
    EditText answer_textbox;
    Button submit_button;
    DatabaseCRUD db_CRUD;
    int question_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l1_question_activity);

        answer_textbox = findViewById(R.id.answer_textbox);
        question_text = findViewById(R.id.question_textview);
        db_CRUD = new DatabaseCRUD(this);

        question_id = getIntent().getIntExtra("QUESTION_ID", 0);

        submit_button = findViewById(R.id.submit_answer_button);

        if (db_CRUD.isAnswered(question_id))
        {
            answer_textbox = findViewById(R.id.answer_textbox);
            answer_textbox.setText(db_CRUD.getQuestion(question_id).getString(3));
            submit_button.setEnabled(false);
        }

        // retrieval of question
        question_text.setText(db_CRUD.getQuestion(question_id).getString(2));
        submit_button.setOnTouchListener(check_answer_listener);

    }

    View.OnTouchListener check_answer_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            answer_textbox = findViewById(R.id.answer_textbox);
            submit_button.setBackgroundResource(R.drawable.submit_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = answer_textbox.getText().toString();

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
                submit_button.setBackgroundResource(R.drawable.submit_up);
            }

            return true;
        }
    };
    protected void check_answer(View view)
    {
        answer_textbox = findViewById(R.id.answer_textbox);
        db_CRUD = new DatabaseCRUD(this);
        submit_button.setBackgroundResource(R.drawable.submit_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = answer_textbox.getText().toString();

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
            submit_button.setBackgroundResource(R.drawable.submit_up);
        }
    }



}
