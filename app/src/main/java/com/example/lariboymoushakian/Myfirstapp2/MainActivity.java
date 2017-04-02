package com.example.lariboymoushakian.myfirstapp2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean clickedm = false;
    boolean clickedf = false;
    public static final String EXTRA_MESSAGE = "hi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, test.class);

        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        intent.putExtra("name", name);




        //EditText et1 = (EditText) findViewById(R.id.gender);
        //String gender = et1.getText().toString();
        //intent.putExtra("gender", gender);

        EditText et2 = (EditText) findViewById(R.id.weight);
        String weight= et2.getText().toString();
        intent.putExtra("weight", weight);

        startActivity(intent);
    }


}
