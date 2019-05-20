package com.chad.calculator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;

import static com.chad.calculator.Constants.*;

public class MainActivity extends AppCompatActivity {

    TextView calcInputView;// = (TextView)findViewById(R.id.text_view_id);

    Button[] buttons = new Button[18];

    Handler mHandler = new Handler();
    String calcInput = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcInputView = (TextView)findViewById(R.id.textView);

        buttons[kZeroButtonID] = (Button)findViewById(R.id.number0);
        buttons[kOneButtonID] = (Button)findViewById(R.id.number1);
        buttons[kTwoButtonID] = (Button)findViewById(R.id.number2);
        buttons[kThreeButtonID] = (Button)findViewById(R.id.number3);
        buttons[kFourButtonID] = (Button)findViewById(R.id.number4);
        buttons[kFiveButtonID] = (Button)findViewById(R.id.number5);
        buttons[kSixButtonID] = (Button)findViewById(R.id.number6);
        buttons[kSevenButtonID] = (Button)findViewById(R.id.number7);
        buttons[kEightButtonID] = (Button)findViewById(R.id.number8);
        buttons[kNineButtonID] = (Button)findViewById(R.id.number9);
        buttons[kDecimalButtonID] = (Button)findViewById(R.id.decimal);
        buttons[kEqualsButtonID] = (Button)findViewById(R.id.equals);
        buttons[kClearButtonID] = (Button)findViewById(R.id.clear);
        buttons[kAddButtonID] = (Button)findViewById(R.id.add);
        buttons[kSubtractButtonID] = (Button)findViewById(R.id.subtract);
        buttons[kMultiplyButtonID] = (Button)findViewById(R.id.multiply);
        buttons[kDivideButtonID] = (Button)findViewById(R.id.divide);
        buttons[kBackButtonID] = (Button)findViewById(R.id.back);


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

        buttons[kZeroButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "0";
                }

            }
        });

        buttons[kOneButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "1";
                }
            }
        });

        buttons[kTwoButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "2";
                }
            }
        });

        buttons[kThreeButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "3";
                }
            }
        });

        buttons[kFourButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "4";
                }
            }
        });

        buttons[kFiveButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "5";
                }
            }
        });

        buttons[kSixButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "6";
                }
            }
        });

        buttons[kSevenButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "7";
                }
            }
        });

        buttons[kEightButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "8";
                }
            }
        });

        buttons[kNineButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "9";
                }
            }
        });

        buttons[kDecimalButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += ".";
                }
            }
        });

        buttons[kEqualsButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calculate();
                }
            }
        });

        buttons[kClearButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcInput = "";
            }
        });

        buttons[kAddButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "+";
                }
            }
        });

        buttons[kSubtractButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "-";
                }
            }
        });

        buttons[kMultiplyButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "*";
                }
            }
        });

        buttons[kDivideButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR"))
                {
                    calcInput += "/";
                }
            }
        });

        buttons[kBackButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!calcInput.equals("ERROR") && calcInput.length() > 0)
                {
                    calcInput = calcInput.substring(0, calcInput.length() - 1);
                }
            }
        });

    }


    void calculate()
    {
        ArrayList<String> operations = new ArrayList<>();
        int numOfOp = 0;
        String temp = "";
        for(int i = 0; i < calcInput.length(); i++)
        {
            if(calcInput.charAt(i) == '+'
            || calcInput.charAt(i) == '*'
            || calcInput.charAt(i) == '/') {
                operations.add(temp);
                operations.add("" + calcInput.charAt(i));
                temp = "";
            }
            else
            {

                if(calcInput.charAt(i) == '-')
                {
                    operations.add(temp);
                    operations.add("+");
                    temp = "";
                }
                else if(calcInput.charAt(i) != '.')
                {
                    numOfOp = 0;
                }

                temp += calcInput.charAt(i);



            }

            if(calcInput.charAt(i) == '+'
            || calcInput.charAt(i) == '*'
            || calcInput.charAt(i) == '/'
            || calcInput.charAt(i) == '.'
            || calcInput.charAt(i) == '-')
            {
                numOfOp++;
            }

            if(numOfOp > 1)
            {
                operations.clear();
                calcInput = "ERROR";
                break;
            }

            if(i == calcInput.length() - 1)
            {
                operations.add(temp);
            }



        }

        while(operations.size() > 1)
        {
            if(operations.get(1).equals("+"))
            {
                operations.set(0, "" + (Double.parseDouble(operations.get(0)) + Double.parseDouble(operations.get(2))));
                operations.remove(1);
                operations.remove(1);
            }
            else if(operations.get(1).equals("*"))
            {
                operations.set(0, "" + (Double.parseDouble(operations.get(0)) * Double.parseDouble(operations.get(2))));
                operations.remove(1);
                operations.remove(1);
            }
            else if(operations.get(1).equals("/"))
            {
                if(!operations.get(2).equals("0"))
                {
                    operations.set(0, "" + (Double.parseDouble(operations.get(0)) / Double.parseDouble(operations.get(2))));
                    operations.remove(1);
                    operations.remove(1);
                }
                else
                {
                    calcInput = "ERROR";
                    operations.clear();
                }

            }
            else
            {
                calcInput = "ERROR";
                operations.clear();
            }
        }

        if(operations.size() == 1)
        {
            calcInput = operations.get(0);
        }


    }




}
