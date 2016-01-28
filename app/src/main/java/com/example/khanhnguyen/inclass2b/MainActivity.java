package com.example.khanhnguyen.inclass2b;
/*
Assignment: 2b
File Name: 800580208_InClass01.zip
Full Name: Khanh Nguyen
* */
import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView resultDisplay;
    String resultString;
    double result, inputAmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputView);
        resultDisplay = (TextView) findViewById(R.id.resultDisp);
        final RadioGroup choices = (RadioGroup) findViewById(R.id.choices);

        //submit button and its function
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempHolder = input.getText().toString();
                boolean parsable = false;

                if(input.getText().toString() == null || input.getText().toString().length() ==0 || choices.getCheckedRadioButtonId() == -1){
                    if(choices.getCheckedRadioButtonId() != R.id.clrRdBtn){
                        Log.d("Error", "user failed to input shit");
                        Toast.makeText(MainActivity.this, "No Input Found!", Toast.LENGTH_SHORT).show();
                    }
                    if(choices.getCheckedRadioButtonId() == -1)
                        Toast.makeText(MainActivity.this, "No Choices Picked!", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        result = Double.parseDouble(tempHolder);
                        parsable = true;
                    }catch(NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                        parsable = false;
                    }
                }

                if(parsable){
                    switch (choices.getCheckedRadioButtonId()){
                        case R.id.inRdBtn:
                            result *= 39.3701;
                            break;
                        case R.id.ftRdBtn:
                            result *= 3.28;
                            break;
                        case R.id.mlRdBtn:
                            result *= 0.0006;
                            break;
                    }
                    resultDisplay.setText(result + "");
                }

                if(choices.getCheckedRadioButtonId() == R.id.clrRdBtn)
                    clearALL();

            }
        });

    }

    public void clearALL(){
        result = 0;
        Log.d("Test", "Now it's clean");
        input.setText("");
        resultDisplay.setText("");
    }
}
