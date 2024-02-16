package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    TextView  tempVal;
    Spinner spn;
    Button btn;
    Conversores objConversor = new Conversores();
    CalcularMoneda objMoneda = new CalcularMoneda();
    CalcularAlmacenamiento objAlmacenamiento = new  CalcularAlmacenamiento();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("LON").setIndicator("LONGITUD", null).setContent(R.id.tabLogitud));
        tbh.addTab(tbh.newTabSpec("MON").setIndicator("MONEDAS", null).setContent(R.id.tabMonedas));
        tbh.addTab(tbh.newTabSpec("ALM").setIndicator("ALMACENAMIENTO", null).setContent(R.id.tabAlmacenamiento));

        btn = findViewById(R.id.btnCalcularLongitud);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeLongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnALongitud);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadLongitud);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objConversor.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnCalcularMoneda);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spndemoneda);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAmoneda);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadMoneda);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objMoneda.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnCalcularAlmacenamiento);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                spn = findViewById(R.id.spnDelmacenamiento);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAAlmacenamiento);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadAlmacenamiento);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objAlmacenamiento.convertir (0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
            private void mostrarResultado(double resultado) {
                String mensaje = String.format("Respuesta: %.8f", resultado);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

        });
    }







    private void mostrarResultado(double resultado) {
        String mensaje = String.format("Respuesta: %.2f", resultado);
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }


    private void mostrarError(String mensaje) {
        Toast.makeText(getApplicationContext(), "Error: " + mensaje, Toast.LENGTH_LONG).show();
    }
}

class CalcularAlmacenamiento{
    double[][] valores = {
            // bytes kilobytes megabytes gigabytes terabytes petabytes
            {1.00, 0.001, 0.000001, 0.000000001, 0.000000000001, 0.000000000000001}
    };
    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}


 class CalcularMoneda {
    double[][] valores =  {
            //dolar euro  Mexico  libra suizo canada chino  rublo
            {01.00, 00.93, 017.05, 00.79, 00.88 ,01.35, 07.16, 92.28 }

    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class Conversores {
    double[][] valores = {
            {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}