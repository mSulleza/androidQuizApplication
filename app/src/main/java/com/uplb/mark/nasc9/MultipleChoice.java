package com.uplb.mark.nasc9;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MultipleChoice extends AppCompatActivity {
    Button a_button, b_button, c_button, d_button;
    TextView question_textview;
    DatabaseCRUD db_CRUD;
    int question_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        question_textview = findViewById(R.id.l3_question_textview);
        a_button = findViewById(R.id.a_button);
        b_button = findViewById(R.id.b_button);
        c_button = findViewById(R.id.c_button);
        d_button = findViewById(R.id.d_button);
        db_CRUD = new DatabaseCRUD(this);
        a_button.setOnTouchListener(a_listener);
        b_button.setOnTouchListener(b_listener);
        c_button.setOnTouchListener(c_listener);
        d_button.setOnTouchListener(d_listener);

        question_id = getIntent().getIntExtra("QUESTION_ID", 0);

        question_textview.setText(db_CRUD.getQuestion(question_id).getString(2));
        a_button.setText(Html.fromHtml(db_CRUD.getQuestion(question_id).getString(5)));
        b_button.setText(Html.fromHtml(db_CRUD.getQuestion(question_id).getString(6)));
        c_button.setText(Html.fromHtml(db_CRUD.getQuestion(question_id).getString(7)));
        d_button.setText(Html.fromHtml(db_CRUD.getQuestion(question_id).getString(8)));

        if (db_CRUD.isAnswered(question_id)) {
            switch (db_CRUD.getQuestion(question_id).getString(3))
            {
                case "A":
                    a_button.setBackgroundResource(R.drawable.multiple_down);
                    break;
                case "B":
                    b_button.setBackgroundResource(R.drawable.multiple_down);
                    break;
                case "C":
                    c_button.setBackgroundResource(R.drawable.multiple_down);
                    break;
                case "D":
                    d_button.setBackgroundResource(R.drawable.multiple_down);
                    break;
            }
            a_button.setEnabled(false);
            b_button.setEnabled(false);
            c_button.setEnabled(false);
            d_button.setEnabled(false);
        }
    }

    View.OnTouchListener a_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a_button.setBackgroundResource(R.drawable.multiple_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "A";

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
                a_button.setBackgroundResource(R.drawable.multiple_up);
            }
            return true;
        }
    };

    View.OnTouchListener d_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d_button.setBackgroundResource(R.drawable.multiple_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "D";

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
                d_button.setBackgroundResource(R.drawable.multiple_up);
            }
            return true;
        }
    };

    View.OnTouchListener b_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b_button.setBackgroundResource(R.drawable.multiple_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "B";

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
                b_button.setBackgroundResource(R.drawable.multiple_up);
            }
            return true;
        }
    };

    View.OnTouchListener c_listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c_button.setBackgroundResource(R.drawable.multiple_down);
            String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
            // retrieval of answer
            String input = "C";

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
                c_button.setBackgroundResource(R.drawable.multiple_up);
            }
            return true;
        }
    };

    protected void a_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        a_button.setBackgroundResource(R.drawable.multiple_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "A";

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
            a_button.setBackgroundResource(R.drawable.multiple_up);
        }
    }

    protected void b_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        b_button.setBackgroundResource(R.drawable.multiple_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "B";

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
            b_button.setBackgroundResource(R.drawable.multiple_up);
        }
    }

    protected void c_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        c_button.setBackgroundResource(R.drawable.multiple_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "C";

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
            c_button.setBackgroundResource(R.drawable.multiple_up);
        }
    }

    protected void d_answer(View view)
    {
        db_CRUD = new DatabaseCRUD(this);
        d_button.setBackgroundResource(R.drawable.multiple_down);
        String correct_answer = db_CRUD.getQuestion(question_id).getString(3);
        // retrieval of answer
        String input = "D";

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
            d_button.setBackgroundResource(R.drawable.multiple_up);
        }
    }
}
