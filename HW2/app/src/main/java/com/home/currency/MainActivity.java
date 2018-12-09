package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText count;
    private final String emptyInputMessage = "Please enter your NTD amount.";

    private float rateOfUS;
    private float rateOfJP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.ntd);
        rateOfUS = Float.parseFloat(((TextView)findViewById(R.id.rate_us)).getText().toString());

    }

    public void findRate(View view) {
        if(count.getText().toString() == null)
        {
            new AlertDialog.Builder(this)
                            .setTitle("Problem")
                            .setMessage(emptyInputMessage)
                            .setPositiveButton("OK", null)
                            .show();
        }
        else
        {
            int inputCount = Integer.parseInt(count.getText().toString());
            float result = inputCount / rateOfUS;
            new AlertDialog.Builder(this)
                            .setTitle("Result")
                            .setMessage("USD is " + result)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    count.setText("");
                                }
                            })
                            .show();
        }
    }
}
