package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        btn = findViewById(R.id.Calcular);
        tempVal = findViewById(R.id.txtNumero1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Numero1 = Double.parseDouble(tempVal.getText().toString());
                double respuesta = 0;

                if (Numero1 <= 18) {
                    respuesta = 6.0;
                } else if (Numero1 <= 28) {
                    respuesta = 6.0 + 0.45 * (Numero1 - 18);
                } else {
                    respuesta = 6.0 + 0.45 * (28 - 18) + 0.65 * (Numero1 - 28);
                }

                tempVal = findViewById(R.id.Repuesta);
                tempVal.setText("Respuesta: $ "+respuesta);

            }
        });
    }
}
