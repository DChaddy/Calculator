package com.chad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView calcInputView;// = (TextView)findViewById(R.id.text_view_id);


    Button zeroButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;

    Handler mHandler = new Handler();
    String calcInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcInputView = (TextView)findViewById(R.id.textView);

        zeroButton = (Button)findViewById(R.id.number0);
        oneButton = (Button)findViewById(R.id.number1);
        twoButton = (Button)findViewById(R.id.number2);
        threeButton = (Button)findViewById(R.id.number3);
        fourButton = (Button)findViewById(R.id.number4);
        fiveButton = (Button)findViewById(R.id.number5);
        sixButton = (Button)findViewById(R.id.number6);
        sevenButton = (Button)findViewById(R.id.number7);
        eightButton = (Button)findViewById(R.id.number8);
        nineButton = (Button)findViewById(R.id.number9);


        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                while (true) {
                    try {
                        Thread.sleep(100);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                calcInputView.setText(calcInput);
                            }
                        });
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }).start();

        zeroButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "0";
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "1";
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "2";
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "3";
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "4";
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "5";
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "6";
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "7";
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "8";
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput += "9";
            }
        });

    }




}
