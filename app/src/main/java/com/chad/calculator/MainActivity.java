package com.chad.calculator;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.view.View;
import android.support.v7.widget.Toolbar;
import java.text.NumberFormat;
import java.util.ArrayList;

import static com.chad.calculator.Constants.*;

public class MainActivity extends AppCompatActivity {

    TextView calcInputView;
    TextView toolBarText;

    Button[] buttons = new Button[18];
    CharSequence[] originalButtonText = new CharSequence[buttons.length];

    Handler mHandler = new Handler();
    String calcInput = "";
    Boolean needsClear;
    MediaPlayer snoopPlayer;
    String mode = "";
    Toolbar action;

    LinearLayout topLayout;
    Drawable originalBackground;

    float buttonRotation = 0;
    boolean increasing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        topLayout = findViewById(R.id.topLayout);
        originalBackground = topLayout.getBackground();

        snoopPlayer = MediaPlayer.create(getApplicationContext(), R.raw.snoop);

        action = findViewById(R.id.toolbar);

        calcInputView = findViewById(R.id.textView);
        toolBarText = findViewById(R.id.toolbarText);

        buttons[kZeroButtonID] = findViewById(R.id.number0);
        buttons[kOneButtonID] = findViewById(R.id.number1);
        buttons[kTwoButtonID] = findViewById(R.id.number2);
        buttons[kThreeButtonID] = findViewById(R.id.number3);
        buttons[kFourButtonID] = findViewById(R.id.number4);
        buttons[kFiveButtonID] = findViewById(R.id.number5);
        buttons[kSixButtonID] = findViewById(R.id.number6);
        buttons[kSevenButtonID] = findViewById(R.id.number7);
        buttons[kEightButtonID] = findViewById(R.id.number8);
        buttons[kNineButtonID] = findViewById(R.id.number9);
        buttons[kDecimalButtonID] = findViewById(R.id.decimal);
        buttons[kEqualsButtonID] = findViewById(R.id.equals);
        buttons[kClearButtonID] = findViewById(R.id.clear);
        buttons[kAddButtonID] = findViewById(R.id.add);
        buttons[kSubtractButtonID] = findViewById(R.id.subtract);
        buttons[kMultiplyButtonID] = findViewById(R.id.multiply);
        buttons[kDivideButtonID] = findViewById(R.id.divide);
        buttons[kBackButtonID] = findViewById(R.id.back);

        for(int i = 0; i < originalButtonText.length; i++)
        {
            originalButtonText[i] = buttons[i].getText();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                calcInputView.setText(calcInput);
                                needsClear = calcInput.equals("ERROR") || calcInput.equals("Figure it out yourself");
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                if(calcInput.equals("420") && !mode.equals("Snoop"))
                                {
                                    snoopMode();
                                }
                                else if(calcInput.equals("666") && !mode.equals("Devil"))
                                {
                                    devilMode();
                                }
                                else if(calcInput.equals("5138008") && !mode.equals("Boobies"))
                                {
                                    boobies();
                                }
                                else if(calcInput.equals("69") && !mode.equals("Sexy"))
                                {
                                    sexy();
                                }
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                for(int i = 0; i < buttons.length; i++)
                                {
                                    buttons[i].setRotation(buttonRotation);
                                }
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                if(mode.equals("Snoop"))
                                {
                                    if(increasing)
                                    {
                                        if(buttonRotation < 5)
                                        {
                                            buttonRotation += 0.2;
                                        }
                                        else
                                        {
                                            increasing = false;
                                        }
                                    }
                                    else
                                    {
                                        if(buttonRotation > -5)
                                        {
                                            buttonRotation -= 0.2;
                                        }
                                        else
                                        {
                                            increasing = true;
                                        }
                                    }

                                }
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        buttons[kZeroButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "0";
                }

            }
        });

        buttons[kOneButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "1";
                }
            }
        });

        buttons[kTwoButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "2";
                }
            }
        });

        buttons[kThreeButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "3";
                }
            }
        });

        buttons[kFourButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "4";
                }
            }
        });

        buttons[kFiveButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "5";
                }
            }
        });

        buttons[kSixButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "6";
                }
            }
        });

        buttons[kSevenButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "7";
                }
            }
        });

        buttons[kEightButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "8";
                }
            }
        });

        buttons[kNineButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "9";
                }
            }
        });

        buttons[kDecimalButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += ".";
                }
            }
        });

        buttons[kEqualsButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    if((int)(Math.random() * 10) < 2)
                    {
                        calcInput = "Figure it out yourself";
                    }
                    else
                    {
                        calculate();
                    }

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
                if(!needsClear)
                {
                    calcInput += "+";
                }
            }
        });

        buttons[kSubtractButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "-";
                }
            }
        });

        buttons[kMultiplyButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "*";
                }
            }
        });

        buttons[kDivideButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear)
                {
                    calcInput += "/";
                }
            }
        });

        buttons[kBackButtonID].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!needsClear && calcInput.length() > 0)
                {
                    calcInput = calcInput.substring(0, calcInput.length() - 1);
                }
            }
        });

    }


    void calculate()
    {
        ArrayList<String> operations = new ArrayList<>();
        calcInput = calcInput.replaceAll(",", "");
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

                if (calcInput.charAt(i) == '-') {
                    if(!temp.equals(""))
                    {
                        operations.add(temp);
                    }
                    else
                    {
                        operations.add("0");
                    }

                    operations.add("+");
                    temp = "";
                }

                temp += calcInput.charAt(i);

            }

            if(i == calcInput.length() - 1)
            {
                operations.add(temp);
            }



        }

        try
        {
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
                    operations.set(0, "" + (Double.parseDouble(operations.get(0)) / Double.parseDouble(operations.get(2))));
                    operations.remove(1);
                    operations.remove(1);
                }
            }
        }
        catch(Exception e)
        {
            calcInput = "ERROR";
            operations.clear();
        }

        if(operations.size() == 1)
        {
            if(operations.get(0).equals("Infinity")
            || operations.get(0).equals("-Infinity")
            || operations.get(0).equals("NaN"))
            {
                calcInput = "ERROR";
            }

            if(!needsClear)
            {
                NumberFormat format = NumberFormat.getInstance();
                format.setMaximumFractionDigits(10);
                calcInput = "" + format.format(Double.parseDouble(operations.get(0)));
            }

        }


    }


    void snoopMode()
    {

        mode = "Snoop";
        snoopPlayer.start();

        topLayout.setBackgroundResource(R.color.White);

        buttonRotation = 0;

        for(int i = 0; i < buttons.length; i++)
        {
            int color = Color.argb(255,(int)(Math.random() * 150),255,(int)(Math.random() * 150));
            buttons[i].setBackgroundColor(color);
            buttons[i].setText(originalButtonText[i]);
        }

        calcInputView.setBackgroundColor(Color.WHITE);

        action.setBackgroundColor(Color.GREEN);

        toolBarText.setText("Smoke the devil's lettuce");

    }

    void devilMode()
    {

        mode = "Devil";

        topLayout.setBackgroundResource(R.color.White);

        buttonRotation = 180;

        for(int i = 0; i < buttons.length; i++)
        {
            int color = Color.argb(255,255,(int)(Math.random() * 100),(int)(Math.random() * 100));
            buttons[i].setBackgroundColor(color);
            buttons[i].setText(originalButtonText[i]);
        }

        calcInputView.setBackgroundColor(Color.argb(150, 255, 0, 0));

        action.setBackgroundColor(Color.RED);

        toolBarText.setText("THE DEVIL IS WATCHING");

    }

    void boobies()
    {
        mode = "Boobies";

        topLayout.setBackgroundResource(R.color.White);

        buttonRotation = 0;

        for(int i = 0; i < buttons.length; i++)
        {
            int color = Color.argb(255,210,180,140);
            buttons[i].setBackgroundColor(color);
            buttons[i].setText("(.)");
        }

        calcInputView.setBackgroundColor(Color.WHITE);

        action.setBackgroundColor(Color.argb(255,210,180,140));

        toolBarText.setText("Nice ;)");

    }

    void sexy()
    {
        mode = "Sexy";

        topLayout.setBackgroundResource(R.mipmap.ryan_raynolds);

        buttonRotation = 0;

        for(int i = 0; i < buttons.length; i++)
        {
            int color = Color.argb(100,0,0,0);
            buttons[i].setBackgroundColor(color);
            buttons[i].setText(originalButtonText[i]);
        }

        calcInputView.setBackgroundColor(Color.argb(0,0,0,0));

        action.setBackgroundColor(Color.argb(0,0,0,0));

        toolBarText.setText("");

    }

}
