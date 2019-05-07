package com.example.moderncalclator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    //private Button doubZero;
    private Button dot;
    private Button add;
    private Button subtract;
    private Button divide;
    private Button multiply;
    private Button clear;
    private Button percentage;
    private Button equal;
    private TextView results;
    private TextView userInput;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char EQU = 0;
    private final char DIVISION = '/';
    private Double val1 = Double.NaN;
    private Double val2;
    private char ACTION;
    private CharSequence charSequence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUIViews();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "0");
            }
        });

       /*** doubZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "00");
            }
        }); ***/

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ ".");

            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString()+ "%");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                results.setText(String.valueOf(val1)+ "+");
                userInput.setText(null);

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                results.setText(String.valueOf(val1)+ "-");
                userInput.setText(null);

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                results.setText(String.valueOf(val1)+ "/");
                userInput.setText(null);

            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                results.setText(String.valueOf(val1)+ "*");
                userInput.setText(null);

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                results.setText(results.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                userInput.setText(null);


            }
        });
           //Setting the delete button to clear the results one by one
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInput.getText().length() > 0){

                    CharSequence charSequence = userInput.getText().toString();
                    userInput.setText(charSequence.subSequence(0, charSequence.length() -1));

                }
                else
                {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    userInput.setText(null);
                    results.setText(null);
                }
            }
        });




    }

    private void setUIViews(){

        zero = (Button)findViewById(R.id.button_zero);
        one = (Button)findViewById(R.id.button_one);
        two = (Button)findViewById(R.id.button_two);
        three = (Button)findViewById(R.id.button_three);
        four = (Button)findViewById(R.id.button_four);
        five = (Button)findViewById(R.id.button_five);
        six = (Button)findViewById(R.id.button_six);
        seven = (Button)findViewById(R.id.button_seven);
        eight = (Button)findViewById(R.id.button_eight);
        nine = (Button)findViewById(R.id.button_nine);
       // doubZero = (Button)findViewById(R.id.button_doublZero);
        dot = (Button)findViewById(R.id.button_dot);
        add = (Button)findViewById(R.id.button_addition);
        subtract = (Button)findViewById(R.id.button_subtraction);
        divide = (Button)findViewById(R.id.button_divide);
        multiply = (Button)findViewById(R.id.button_multiply);
        clear = (Button)findViewById(R.id.button_clear);
        results = (TextView) findViewById(R.id.TV_userResults_id);
        userInput = (TextView)findViewById(R.id.TV_userInput_id);
        equal = (Button)findViewById(R.id.button_equal);
        percentage = (Button)findViewById(R.id.button_percentage);

    }

    private void compute(){

        if (!Double.isNaN(val1)){

            val2 = Double.parseDouble(userInput.getText().toString());

            switch (ACTION){

                case ADDITION:
                    val1 = val1 + val2;
                    break;

                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;

                case DIVISION:
                    val1 = val1 / val2;
                    break;


                case EQU:
                    break;
            }
        }
        else {

            val1 = Double.parseDouble(userInput.getText().toString());
        }
    }




}
