package com.sharma.kartikeya.flashcardz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //When we clcik on the question, the answer appears,
        // when question is clicked again, answer disappears
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(findViewById(R.id.flashcard_answer).getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        //When we click plus sign, we can go to new page
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String new_question = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String new_answer = data.getExtras().getString("string2");

            ((TextView) findViewById(R.id.flashcard_question)).setText(new_question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(new_answer);

        }
    }
}
