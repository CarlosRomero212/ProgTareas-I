package com.example.calculadora;

import static com.example.calculadora.R.id.btnConvertir2;

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
    TextView tempVal;
    Spinner spn;
    Button btn;
    Conversores objConversor = new Conversores();
    CalcularMoneda objMoneda = new CalcularMoneda();
    CalcularAlmacenamiento objAlmacenamiento = new CalcularAlmacenamiento();
    CalcularTiempo objTiempo = new CalcularTiempo();
    CalcularMasa objMasa = new CalcularMasa();
    CalcularVolumen objVolumen = new CalcularVolumen();
    CalcularTransferencia objTransferencia = new CalcularTransferencia();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("LON").setIndicator("LONG", null).setContent(R.id.Longitud));
        tbh.addTab(tbh.newTabSpec("MON").setIndicator("MON", null).setContent(R.id.Monedas));
        tbh.addTab(tbh.newTabSpec("ALM").setIndicator("ALM", null).setContent(R.id.Almacenamiento));
        tbh.addTab(tbh.newTabSpec("TIM").setIndicator("TIM", null).setContent(R.id.Tiempo));
        tbh.addTab(tbh.newTabSpec("VOL").setIndicator("VOL", null).setContent(R.id.Volumen));
        tbh.addTab(tbh.newTabSpec("MAS").setIndicator("MAS", null).setContent(R.id.Masa));
        tbh.addTab(tbh.newTabSpec("TRA").setIndicator("TRAN", null).setContent(R.id.Transferencia));

        btn = findViewById(R.id.btnConvertir1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeLongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnALongitud);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad1);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objConversor.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(btnConvertir2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeMoneda);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMoneda);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad2);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objMoneda.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeAlmacenamiento);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAalmacenamiento);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad3);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objAlmacenamiento.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeTiempo);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnATiempo);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad4);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objTiempo.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeVolumen);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAVolumen);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad5);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objVolumen.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeMasa);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMasa);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad6);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objMasa.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeTransferencia);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnATransferencia);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad7);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objTransferencia.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

    }

    private void mostrarResultado(double resultado) {
        String mensaje = String.format("Respuesta: %.1f", resultado);
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }

    private void mostrarError(String mensaje) {
        Toast.makeText(getApplicationContext(), "Error: " + mensaje, Toast.LENGTH_LONG).show();
    }
}

class CalcularMoneda {
    double[][] valores =  {
            {1.0, 0.93, 17.19, 0.79, 0.91}
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

class CalcularAlmacenamiento {
    double[][] valores =  {
            {1,0.001,0.000001,1e-9,1e-12,1e-15,8,0.008,0.000008,8e-9,8e-12,8e-15}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularTiempo {
    double[][] valores =  {
            {31557600,315576000,31557600,525960,8766,365.25,52.1785,12,1}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularVolumen {
    double[][] valores =  {
            {0.001,1,1000,1000000,0.035314666721489, 61.0237440,0.2641720523}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularMasa {
    double[][] valores =  {
            {1,0.001,1.0e-6,1.0e-9,0.45359237,0.028349523125,907.18474,1000,6350.29}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularTransferencia {
    double[][] valores =  {
            {1,1000,100000,1000000,1000000000,1000000000}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}