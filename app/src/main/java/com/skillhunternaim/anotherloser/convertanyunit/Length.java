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

public class Length extends AppCompatActivity {
    private TextView umv,mmv,cmv,dmv,mv,kmv,miv,inv,ftv,ydv;
    private Spinner spinner;
    private EditText input;
    private double um=1000000,mm=1000,cm=100,dm=10,m=1,km=0.001,mi=0.000621,in=39.370079,ft=3.28084,yd=1.0936;
    private String[] spn={"um","mm","cm","dm","m","km","mi","in","ft","yd"};
    private String selected="m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        umv=findViewById(R.id.id_micrometer);
        mmv=findViewById(R.id.id_milimeter);
        cmv=findViewById(R.id.id_centimeter);
        dmv=findViewById(R.id.id_decimeter);
        mv=findViewById(R.id.id_meter);
        kmv=findViewById(R.id.id_kilometer);
        miv=findViewById(R.id.id_mile);
        inv=findViewById(R.id.id_inch);
        ftv=findViewById(R.id.id_foot);
        ydv=findViewById(R.id.id_yeard);

        input=findViewById(R.id.id_input_length);
        spinner=findViewById(R.id.id_spinner_length);
        String[] length_unites={"Micrometer[µm]","Millimeter[mm]","Centimeter[cm]","Decimeter[dm]","Meter[m]","Kilometer[km]",
                "Mile[mi]","Inch[in]","Foot[ft]","Yard[yd]"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,length_unites);
        spinner.setAdapter(adapter);
        spinner.setSelection(4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=spn[position];
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toMeter(inp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected="m";
                double inp= 1;
                toMeter(inp);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toMeter(inp);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



    }
    private void toMeter(double inp){
        double meter=0;
        if(selected=="um"){
            meter=inp/um;
        }else if(selected=="mm"){
            meter=inp/mm;
        }else if(selected=="cm"){
            meter=inp/cm;
        }else if(selected=="dm"){
            meter=inp/dm;
        }else if(selected=="m"){
            meter=inp/m;
        }else if(selected=="km"){
            meter=inp/km;
        }else if(selected=="mi"){
            meter=inp/mi;
        }else if(selected=="in"){
            meter=inp/in;
        }else if(selected=="ft"){
            meter=inp/ft;
        }else if(selected=="yd"){
            meter=inp/yd;
        }
        setAllUnites(meter);
    }
    private void setAllUnites(double meter){
        DecimalFormat df = new DecimalFormat("#.######");
        umv.setText(df.format(meter*um));
        mmv.setText(df.format(meter*mm));
        cmv.setText(df.format(meter*cm));
        dmv.setText(df.format(meter*dm));
        mv.setText(df.format(meter*m));
        kmv.setText(df.format(meter*km));
        miv.setText(df.format(meter*mi));
        inv.setText(df.format(meter*in));
        ftv.setText(df.format(meter*ft));
        ydv.setText(df.format(meter*yd));
    }
}
