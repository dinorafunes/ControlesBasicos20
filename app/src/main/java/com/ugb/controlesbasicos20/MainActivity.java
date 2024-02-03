package com.ugb.controlesbasicos20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView var1;
    Button btn;
    RadioGroup opt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnC);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = findViewById(R.id.num1);
                double num1 = Double.parseDouble(var1.getText().toString());

                var1 = findViewById(R.id.num2);
                double num2 = Double.parseDouble(var1.getText().toString());

                double respuesta = 0;
                opt1 = findViewById(R.id.group1);

                if (opt1.getCheckedRadioButtonId() == R.id.opSum) {
                    respuesta = num1 + num2;
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opRes) {
                    respuesta = num1 - num2;
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opMul) {
                    respuesta = num1 * num2;
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opDiv) {
                    respuesta = num1 / num2;
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opPor) {
                    respuesta = (num1 / num2) * 100;
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opExp) {
                    respuesta = Math.pow(num1, num2);
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opFac) {
                    for (int i = 1; i <= num1; ++i) {
                        respuesta *= i;
                    }
                }
                if (opt1.getCheckedRadioButtonId() == R.id.opRaz) {
                    respuesta = Math.sqrt(num1);
                }
                var1 = findViewById(R.id.result1);
                var1.setText("Resultado = " + respuesta);
            }
        });
    }
}