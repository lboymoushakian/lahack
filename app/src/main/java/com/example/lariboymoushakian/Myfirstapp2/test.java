package com.example.lariboymoushakian.myfirstapp2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class test extends AppCompatActivity {
    int numDrinks = 0;
 int roundedweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //String gender = intent.getStringExtra("gender");
        String weight1 = intent.getStringExtra("weight");

        int weight = Integer.valueOf(weight1);
        if (weight > 240)
            weight = 240;
        if (weight < 100)
            weight = 100;
        roundedweight = ((weight + 5) / 10) - 10;

    }
    public void update(){

        double[][] bac = new double[][]{
                {.000, .038,	.075,	.113,	.150,	.188,	.225,	.263,	.300,	.338,	.375,	.413,	.450},
                {.000, .034,	.066,	.103,	.137,	.172,	.207,	.241,	.275,	.309,	.344,	.379,	.412},
                {.000, .031,	.063,	.094,	.125,	.156,	.188,	.219,	.250,	.281,	.313,	.344,	.375},
                {.000, .029,	.058,	.087,	.116,	.145,	.174,	.203,	.232,	.261,	.290,	.320,	.348},
                {.000, .027,	.054,	.080,	.107,	.134,	.161,	.188,	.214,	.241,	.268,	.295,	.321},
                {.000, .025,	.050,	.075,	.100,	.125,	.151,	.176,	.201,	.226,	.251,	.276,	.301},
                {.000, .023,	.047,	.070,	.094,	.117,	.141,	.164,	.188,	.211,	.234,	.258,	.281},
                {.000, .022,	.045,	.066,	.088,	.110,	.132,	.155,	.178,	.200,	.221,	.244,	.265},
                {.000, .021,	.042,	.063,	.083,	.104,	.125,	.146,	.167,	.188,	.208,	.229,	.250},
                {.000, .020,	.040,	.059,	.079,	.099,	.119,	.138,	.158,	.179,	.198,	.217,	.237},
                {.000, .019,	.038,	.056,	.075,	.094,	.113,	.131,	.150,	.169,	.188,	.206,	.225},
                {.000, .018,	.036,	.053,	.071,	.090,	.107,	.125,	.143,	.161,	.179,	.197,	.215},
                {.000, .017,	.034,	.051,	.068,	.085,	.102,	.119,	.136,	.153,	.170,	.188,	.205},
                {.000, .016,	.032,	.049,	.065,	.081,	.098,	.115,	.130,	.147,	.163,	.180,	.196},
                {.000, .016,	.031,	.047,	.063,	.078,	.094,	.109,	.125,	.141,	.156,	.172,	.188}
        };

        double dbac =  bac[roundedweight][numDrinks];
        if (dbac >= 0.08)
        {
            TextView warning = (TextView) findViewById(R.id.warning);
            warning.setVisibility(View.VISIBLE);
            warning.setText("Unsafe to drive.");
            ImageButton uber = (ImageButton) findViewById(R.id.uber);
            uber.setVisibility(View.VISIBLE);

            uber.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_MAIN);
                    PackageManager managerclock = getPackageManager();
                    i = managerclock.getLaunchIntentForPackage("com.ubercab");
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                }
            });

        }



        /*
        final Chronometer simpleChronometer = (Chronometer) findViewById(R.id.chronometer); // initiate a chronometer

        simpleChronometer.setBase(SystemClock.elapsedRealtime());
        simpleChronometer.start(); // start a chronometer
        simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {



            public void onChronometerTick(Chronometer chronometer) {

                if(chronometer.getBase() % 3600000 == 0)
                {
                    TextView newbac = (TextView) findViewById(R.id.newbac);
                    double newb = dbac - .015;
                    newbac.setText(Double.toString(newb));
                }

            }

        });
        */
        String message = "BAC: " + Double.toString(dbac);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
    public void click1(View view) {
        numDrinks++;
        update();

    }
    public void click2(View view){
        numDrinks +=2;
        update();
    }

}
