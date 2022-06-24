package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText width;
    EditText height;
    EditText consumption;
    EditText layers;
    EditText vol;
    TextView result;

    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton1:
                        j = 1;
                        break;
                    case R.id.radioButton2:
                        j =2;
                        break;
                    case R.id.radioButton3:
                        j = 3;
                        break;
                }
            }
        });
    }
    public void calc(View view) {
        width = (EditText) findViewById(R.id.editText3);
        height = (EditText) findViewById(R.id.editText2);
        consumption = (EditText) findViewById(R.id.editText4);
        layers = (EditText) findViewById(R.id.editText5);
        vol = (EditText) findViewById(R.id.editText6);
        result = (TextView) findViewById(R.id.textView9);

        double width1 = Double.parseDouble(width.getText().toString());
        double height1 = Double.parseDouble(height.getText().toString());
        double consumption1 = Double.parseDouble(consumption.getText().toString());
        double layers1 = Double.parseDouble(layers.getText().toString());
        double vol1 = Double.parseDouble(vol.getText().toString());
        double square = width1 * height1;
        double x = square * consumption1 * layers1;
        double y = x / vol1;
        y = Math.ceil(y);
        int res;
        if (j == 1){
            double y1 = y*10/100;
            y = y+y1;
            y = Math.ceil(y);
            res = (int) y;
            result.setText("Банок необходимо: "+Integer.toString(res));
        }
        else if (j == 2) {
            double y1 = y*15/100;
            y = y+y1;
            y = Math.ceil(y);
            res = (int) y;
            result.setText("Банок необходимо: "+Integer.toString(res));
        }
        else if (j == 3){
            res = (int) y;
            result.setText("Банок необходимо: "+Integer.toString(res));
        }
    }

}