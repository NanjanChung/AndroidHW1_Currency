package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText count = null;
    private float rateOfUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.ntd);
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.rate_us, typedValue, true);
        rateOfUS = typedValue.getFloat();
        Log.d("checkme", String.valueOf(rateOfUS));
    }

    public void findRate(View view) {
        if(count.getText().toString().isEmpty())
        {
            new AlertDialog.Builder(this)
                            .setTitle(R.string.problem)
                            .setMessage(R.string.please_enter_ntd)
                            .setPositiveButton(R.string.ok, null)
                            .show();
        }
        else
        {
            int inputCount = Integer.parseInt(count.getText().toString());
            float result = inputCount / rateOfUS;
            new AlertDialog.Builder(this)
                            .setTitle(R.string.result)
                            .setMessage(getString(R.string.usd_is) + result)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    count.setText("");
                                }
                            })
                            .show();
        }
    }
}
