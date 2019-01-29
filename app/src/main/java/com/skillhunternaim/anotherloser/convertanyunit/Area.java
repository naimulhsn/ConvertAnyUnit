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

public class Area extends AppCompatActivity {
    private TextView mmv,cmv,dmv,mv,inv,ftv,ydv,hav,acv,miv;
    private Spinner spinner;
    private EditText input;
    private double mm=1000000,cm=10000,dm=100,m=1,in=1550.0031,ft=10.76391,yd=1.196,ha=0.0001,ac=0.0002471,mi=0.0000003861;
    private String[] spn={"mm","cm","dm","m","in","ft","yd","ha","ac","mi"};
    private String selected="m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        mmv=findViewById(R.id.id_square_millimeter);
        cmv=findViewById(R.id.id_square_centimeter);
        dmv=findViewById(R.id.id_square_decimeter);
        mv=findViewById(R.id.id_square_meter);
        inv=findViewById(R.id.id_square_inch);
        ftv=findViewById(R.id.id_square_foot);
        ydv=findViewById(R.id.id_square_yard);
        hav=findViewById(R.id.id_square_hectare);
        acv=findViewById(R.id.id_square_acre);
        miv=findViewById(R.id.id_square_mile);

        input=findViewById(R.id.id_input_area);

        spinner=findViewById(R.id.id_spinner_area);
        String[] area_unit={"Square Millimeter [mm²]","Square Centimeter [cm²]","Square Decimeter [dm²]","Meter [m²]","Square Inch [in²]",
                "Square Foot [ft²]","Square Yard [yd²]","Hectare [ha]","Acre [ac]","Square Mile [mi²]"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,area_unit);
        spinner.setAdapter(adapter);
        spinner.setSelection(3);
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
        if(selected=="mm"){
            meter=inp/mm;
        }else if(selected=="cm"){
            meter=inp/cm;
        }else if(selected=="dm"){
            meter=inp/dm;
        }else if(selected=="m"){
            meter=inp/m;
        }else if(selected=="in"){
            meter=inp/in;
        }else if(selected=="ft"){
            meter=inp/ft;
        }else if(selected=="yd"){
            meter=inp/yd;
        }else if(selected=="ha"){
            meter=inp/ha;
        }else if(selected=="ac"){
            meter=inp/ac;
        }else if(selected=="mi"){
            meter=inp/mi;
        }
        setAllUnites(meter);
    }
    private void setAllUnites(double meter){
        DecimalFormat df = new DecimalFormat("#.######");
        mmv.setText(df.format(meter*mm));
        cmv.setText(df.format(meter*cm));
        dmv.setText(df.format(meter*dm));
        mv.setText(df.format(meter*m));
        inv.setText(df.format(meter*in));
        ftv.setText(df.format(meter*ft));
        ydv.setText(df.format(meter*yd));
        hav.setText(df.format(meter*ha));
        acv.setText(df.format(meter*ac));
        miv.setText(df.format(meter*mi));
    }
}
