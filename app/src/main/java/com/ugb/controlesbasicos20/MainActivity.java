package com.ugb.controlesbasicos20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    TextView tempVal;
    Spinner spn;
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    conversores miObj = new conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversor);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("LON").setContent(R.id.tabLongitud).setIndicator("LONGITUD", null));
        tbh.addTab(tbh.newTabSpec("ALM").setContent(R.id.tabAlmacenamiento).setIndicator("ALMACENAMIENTO", null));
        tbh.addTab(tbh.newTabSpec("MON").setContent(R.id.tabMonedas).setIndicator("MONEDAS", null));
        tbh.addTab(tbh.newTabSpec("MAS").setContent(R.id.tabMasa).setIndicator("MASA", null));
        tbh.addTab(tbh.newTabSpec("VOL").setContent(R.id.tabVolumen).setIndicator("VOLUMEN", null));
        tbh.addTab(tbh.newTabSpec("TMP").setContent(R.id.tabTiempo).setIndicator("TIEMPO", null));

        btn = findViewById(R.id.btnConvertirL);
        btn1 = findViewById(R.id.btnConvertirM);
        btn2 = findViewById(R.id.btnConvertirA);
        btn3 = findViewById(R.id.btnConvertirM1);
        btn4 = findViewById(R.id.btnConvertirV);
        btn5 = findViewById(R.id.btnConvertirT);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAlon);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBlon);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadL);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAmon);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBmon);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadM);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir1(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAalm);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBalm);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadA);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir2(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAmas);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBmas);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadM1);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir3(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAvol);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBvol);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadV);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir4(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnAtmp);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnBtmp);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadT);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir5(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
    }
}
class conversores{
    double[][] valores1={
            {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371}
    };
    double[][] valores2={
            {1, 0.93, 0.79, 0.88, 150.16, 7.22, 92.28, 17.05}
    };
    double[][] valores3={
            {1, 1024, 1048576, 1073741824, 1099511627776.0, 1125899906842624.0, 1152921504606846976.0}
    };
    double[][] valores4={
            {1, 453.59237, 0.45359237, 453592.37, 453592370, 0.00045359237, 16, 0.022046, 0.0005, 0.000446429}
    };
    double[][] valores5={
            {1, 0.001, 0.001, 1000, 1, 10, 100, 1000, 0.473176, 3.78541}
    };
    double[][] valores6={
            {1, 60, 3600, 24, 168, 730, 8760, 87600, 876000, 8760000}
    };
    public double convertir (int opcion, int de, int a, double cantidad){
        return valores1[opcion][a]/valores1[opcion][de]*cantidad;
    }
    public double convertir1 (int opcion, int de, int a, double cantidad){
        return valores2[opcion][a]/valores2[opcion][de]*cantidad;
    }
    public double convertir2 (int opcion, int de, int a, double cantidad){
        return valores3[opcion][a]/valores3[opcion][de]*cantidad;
    }
    public double convertir3 (int opcion, int de, int a, double cantidad){
        return valores4[opcion][a]/valores4[opcion][de]*cantidad;
    }
    public double convertir4 (int opcion, int de, int a, double cantidad){
        return valores5[opcion][a]/valores5[opcion][de]*cantidad;
    }
    public double convertir5 (int opcion, int de, int a, double cantidad){
        return valores6[opcion][a]/valores6[opcion][de]*cantidad;
    }
}