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

public class Temperature extends AppCompatActivity {
    private TextView cv,fv,kv,rv,nv,rev;
    private Spinner spinner;
    private EditText input;
    private double c=1,f=33.8,k=274.15,r=493.47,n=0.33,re=0.8;
    private String[] spn={"c","f","k","r","n","re"};
    private String selected="c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        cv=findViewById(R.id.id_celsius);
        fv=findViewById(R.id.id_fahrenheit);
        kv=findViewById(R.id.id_kelvin);
        rv=findViewById(R.id.id_rankine);
        nv=findViewById(R.id.id_newton);
        rev=findViewById(R.id.id_reamur);

        input=findViewById(R.id.id_input_temperature);

        spinner=findViewById(R.id.id_spinner_temperature);
        String[] area_unit={"Celsius(ºC)","Fahrenheit(ºF)","Kelvin(K)","Rankine(ºR)","Newton(ºN)","Reamur(ºRé)"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,area_unit);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=spn[position];
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toCelsius(inp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected="c";
                double inp= 1;
                toCelsius(inp);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toCelsius(inp);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void toCelsius(double inp){
        double celsius=0;
        if(selected=="c"){
            celsius=inp/c;
        }else if(selected=="f"){
            celsius=inp/f;
        }else if(selected=="k"){
            celsius=inp/k;
        }else if(selected=="r"){
            celsius=inp/r;
        }else if(selected=="n"){
            celsius=inp/re;
        }
        setAllUnites(celsius);
    }
    private void setAllUnites(double celsius){
        DecimalFormat df = new DecimalFormat("#.######");
        cv.setText(df.format(celsius*c));
        fv.setText(df.format(celsius*f));
        kv.setText(df.format(celsius*k));
        rv.setText(df.format(celsius*r));
        nv.setText(df.format(celsius*n));
        rev.setText(df.format(celsius*re));

    }
}
