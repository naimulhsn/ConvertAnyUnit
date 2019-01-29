package com.skillhunternaim.anotherloser.convertanyunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Time extends AppCompatActivity {
    private TextView msv,sv,minv,hrv,dv,wkv,monv,yv;
    private Spinner spinner;
    private EditText input;
    private double ms=60000,s=60,min=1,hr=0.016666666667,d=0.00069444444,wk=0.000099206,mon=0.000022831,y=0.0000019025;
    private String[] spn={"ms","s","min","hr","d","wk","mon","y"};
    private String selected="min";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        msv=findViewById(R.id.id_millisecond);
        sv=findViewById(R.id.id_second);
        minv=findViewById(R.id.id_minute);
        hrv=findViewById(R.id.id_hour);
        dv=findViewById(R.id.id_day);
        wkv=findViewById(R.id.id_week);
        monv=findViewById(R.id.id_month);
        yv=findViewById(R.id.id_year);

        input=findViewById(R.id.id_input_time);

        spinner=findViewById(R.id.id_spinner_time);
        String[] time_units={"Millisecond [ms]","Second [s]","Minute [min]","Hour [hr]","Day [d]","Week [wk]","Month [mon]","Year [y]"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,android.R.layout.simple_spinner_dropdown_item,time_units);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=spn[position];
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toMinute(inp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected="min";
                double inp= 1;
                toMinute(inp);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toMinute(inp);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void toMinute(double inp){
        double minute=0;
        if(selected=="ms"){
            minute=inp/ms;
        }else if(selected=="s"){
            minute=inp/s;
        }else if(selected=="min"){
            minute=inp/min;
        }else if(selected=="hr"){
            minute=inp/hr;
        }else if(selected=="d"){
            minute=inp/d;
        }else if(selected=="wk"){
            minute=inp/wk;
        }else if(selected=="mon"){
            minute=inp/mon;
        }else if(selected=="y"){
            minute=inp/y;
        }
        setAllUnites(minute);
    }
    private void setAllUnites(double minute){
        DecimalFormat df = new DecimalFormat("#.######");
        msv.setText(df.format(minute*ms));
        sv.setText(df.format(minute*s));
        minv.setText(df.format(minute*min));
        hrv.setText(df.format(minute*hr));
        dv.setText(df.format(minute*d));
        wkv.setText(df.format(minute*wk));
        monv.setText(df.format(minute*mon));
        yv.setText(df.format(minute*y));

    }
}
