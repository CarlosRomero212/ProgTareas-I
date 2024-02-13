package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tempVal = findViewById(R.id.txtNumero1);
                double Numero1 = Double.parseDouble(tempVal.getText().toString());

                tempVal = findViewById(R.id.txtNumero2);
                double Numero2 = Double.parseDouble(tempVal.getText().toString());

                double respuesta = 0;

                switch (spn.getSelectedItemPosition()){
                    case 0:
                        respuesta = Numero1+Numero2;
                        break;
                    case 1:
                        respuesta = Numero1-Numero2;
                        break;
                    case 2:
                        respuesta = Numero1*Numero2;
                        break;
                    case 3:
                        respuesta = Numero1/Numero2;
                        break;
                    case 4:
                        respuesta = (Numero1 /Numero2) * 100;
                        break;
                    case 5:
                        respuesta = Math.pow(Numero1, Numero2);
                        break;
                    case 6:
                        respuesta = Math.pow(Numero1, 1 / Numero2);
                        break;
                    case 7:
                        respuesta = calcularFactorial((int) Numero2);
                        break;
                }
                tempVal = findViewById(R.id.lblRespuesta);
                tempVal.setText("Respuesta: "+respuesta);
            }
            private double calcularFactorial(int n) {
                if (n == 0 || n == 1) {
                    return 1;
                } else {
                    return n * calcularFactorial(n - 1);
                }
            }
        });
    }
}
