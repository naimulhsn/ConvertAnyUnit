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

public class Weight extends AppCompatActivity {
    private TextView mgv,gv,kgv,lbv,ozv,grv,metric_tv,us_tv,uk_tv,stv,cwtv,ctv;
    private Spinner spinner;
    private EditText input;
    private double mg=1000000,g=1000,kgg=1,lb=2.204623,oz=35.273962,gr=15432.3884,metric_t=0.001,
            us_t=0.000984,uk_t=0.001102,st=0.157473,cwt=0.0196824,ct=5000;
    private String[] spn={"mg","g","kg","lb","oz","gr","metric_t","us_t","uk_t","st","cwt","ct"};
    private String selected="kg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        mgv=findViewById(R.id.id_milligram);
        gv=findViewById(R.id.id_gram);
        kgv=findViewById(R.id.id_kilogram);
        lbv=findViewById(R.id.id_pound);
        ozv=findViewById(R.id.id_ounce);
        grv=findViewById(R.id.id_grain);
        metric_tv=findViewById(R.id.id_metric_ton);
        us_tv=findViewById(R.id.id_us_ton);
        uk_tv=findViewById(R.id.id_uk_t);
        stv=findViewById(R.id.id_uk_stone);
        cwtv=findViewById(R.id.id_hundred_weight);
        ctv=findViewById(R.id.id_carat);

        input=findViewById(R.id.id_input_weight);

        spinner=findViewById(R.id.id_spinner_weight);
        String[] area_unit={"Milligram [mg]","Gram [g]","Kilogram [kg]","pound [lb]","Ounce [oz]","Grain [gr]",
                "Ton [metric t]","Ton [US t]","Ton [UK t]","Stone [UK st]","Hundred Weight [cwt]","Carat [ct]"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,area_unit);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=spn[position];
                double inp= Double.parseDouble( "0"+input.getText().toString().trim());
                toKg(inp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected="kg";
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
        double kg=0;
        if(selected=="mg"){
            kg=inp/mg;
        }else if(selected=="g"){
            kg=inp/g;
        }else if(selected=="kg"){
            kg=inp/kgg;
        }else if(selected=="lb"){
            kg=inp/lb;
        }else if(selected=="oz"){
            kg=inp/oz;
        }else if(selected=="gr"){
            kg=inp/gr;
        }else if(selected=="metric_t"){
            kg=inp/metric_t;
        }else if(selected=="us_t"){
            kg=inp/us_t;
        }else if(selected=="uk_t"){
            kg=inp/uk_t;
        }else if(selected=="st"){
            kg=inp/st;
        }else if(selected=="cwt"){
            kg=inp/cwt;
        }else if(selected=="ct"){
            kg=inp/ct;
        }
        setAllUnites(kg);
    }
    private void setAllUnites(double kg){
        DecimalFormat df = new DecimalFormat("#.######");
        mgv.setText(df.format(kg*mg));
        gv.setText(df.format(kg*g));
        kgv.setText(df.format(kg*kg));
        lbv.setText(df.format(kg*lb));
        ozv.setText(df.format(kg*oz));
        grv.setText(df.format(kg*gr));
        metric_tv.setText(df.format(kg*metric_t));
        us_tv.setText(df.format(kg*us_t));
        uk_tv.setText(df.format(kg*uk_t));
        stv.setText(df.format(kg*st));
        cwtv.setText(df.format(kg*cwt));
        ctv.setText(df.format(kg*ct));
    }
}
