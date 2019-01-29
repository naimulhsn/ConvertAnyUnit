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

public class Volume extends AppCompatActivity {
    private TextView mla,la,cma,dma,ma,ina,fta,yda,us_gala,uk_galaa,us_bbla,uk_bbla,us_pta,ca,tbspa,tspa;
    private Spinner spinner;
    private EditText input;
    private double ml=1000000,l=1000,cm=1000000,dm=1000,m=1,in=610233.7441,ft=35.314667,yd=1.307951,us_gal=264.172052,uk_gal=219.969249,
            us_bbl=8.3864,uk_bbl=6.11025,us_pt=2113.37642,c=4226.7528377,tbsp=67628.454,tsp=202884.1362111;
    private String[] spn={"ml","l","cm","dm","m","in","ft","yd","us_gal","uk_gal","us_bbl","uk_bbl","us_pt","c","tbsp","tsp"};
    private String selected="m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        mla=findViewById(R.id.id_millileter);
        la=findViewById(R.id.id_litre);
        cma=findViewById(R.id.id_cubic_cm);
        dma=findViewById(R.id.id_cubic_dm);
        ma=findViewById(R.id.id_cubic_m);
        ina=findViewById(R.id.id_cubic_in);
        fta=findViewById(R.id.id_cubic_ft);
        yda=findViewById(R.id.id_cubic_yd);
        us_gala=findViewById(R.id.id_us_gallon);
        uk_galaa=findViewById(R.id.id_uk_gallon);
        us_bbla=findViewById(R.id.id_us_barel);
        uk_bbla=findViewById(R.id.id_uk_barel);
        us_pta=findViewById(R.id.id_us_pint);
        ca=findViewById(R.id.id_cup);
        tbspa=findViewById(R.id.id_tablespoon);
        tspa=findViewById(R.id.id_teaspoon);


        input=findViewById(R.id.id_input_volume);

        spinner=findViewById(R.id.id_spinner_volume);
        String[] area_unit={"Milliliter(ml cc)","Litre(L)","Cubic Centimeter(cm3)","Cubic Decimeter(dm3)","Cubic meter(m3)","Cubic Inch(in3)",
                "Cubic foot(ft3)", "Cubic yard(yd3)","Gallon(US gal)",
                "Gallon(UK gal","Barel(US bbl)","Barel(UK bbl)","Pint(US pt)","Cup(c)","Tablespoon(tbsp)","Teaespoon(tsp)"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,area_unit);
        spinner.setAdapter(adapter);
        spinner.setSelection(4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=spn[position];
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toKg(inp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected="volume";
                double inp= 1;
                toKg(inp);
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toKg(inp);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void toKg(double inp){
        double volume=0;
        if(selected=="ml"){
            volume=inp/ml;
        }else if(selected=="l"){
            volume=inp/l;
        }else if(selected=="cm"){
            volume=inp/cm;
        }else if(selected=="dm"){
            volume=inp/dm;
        }else if(selected=="m"){
            volume=inp/m;
        }else if(selected=="in"){
            volume=inp/in;
        }else if(selected=="ft"){
            volume=inp/ft;
        }else if(selected=="yd"){
            volume=inp/yd;
        }else if(selected=="us_gal"){
            volume=inp/us_gal;
        }else if(selected=="uk_gal"){
            volume=inp/uk_gal;
        }else if(selected=="us_bbl"){
            volume=inp/us_bbl;
        }else if(selected=="uk_bbl"){
            volume=inp/uk_bbl;
        }else if(selected=="us_pt"){
            volume=inp/us_pt;
        }else if(selected=="c"){
            volume=inp/c;
        }else if(selected=="tbsp"){
            volume=inp/tbsp;
        }else if(selected=="tsp"){
            volume=inp/tsp;
        }
        setAllUnites(volume);
    }
    private void setAllUnites(double volume){
        DecimalFormat df = new DecimalFormat("#.######");
        mla.setText(df.format(volume*ml));
        la.setText(df.format(volume*l));
        cma.setText(df.format(volume*cm));
        dma.setText(df.format(volume*dm));
        ma.setText(df.format(volume*m));
        ina.setText(df.format(volume*in));
        fta.setText(df.format(volume*ft));
        yda.setText(df.format(volume*yd));
        us_gala.setText(df.format(volume*us_gal));
        uk_galaa.setText(df.format(volume*uk_gal));
        us_bbla.setText(df.format(volume*us_bbl));
        uk_bbla.setText(df.format(volume*uk_bbl));
        us_pta.setText(df.format(volume*us_pt));
        ca.setText(df.format(volume*c));
        tbspa.setText(df.format(volume*tbsp));
        tspa.setText(df.format(volume*tsp));

    }
}
