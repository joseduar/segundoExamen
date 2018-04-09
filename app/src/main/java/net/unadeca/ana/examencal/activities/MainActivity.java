package net.unadeca.ana.examencal.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.unadeca.ana.examencal.R;
import net.unadeca.ana.examencal.database.models.ExamencalTable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num1, num2;
    Button s, r, m, d, p;
    TextView resultado;
    String signo;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.n1);
        num2 = findViewById(R.id.n2);

        s = findViewById(R.id.s);
        r = findViewById(R.id.r);
        m = findViewById(R.id.m);
        d = findViewById(R.id.d);

        resultado = findViewById(R.id.resultado);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actividad = new Intent(getApplicationContext(), ResultadosActivity.class);
                getApplicationContext().startActivity(actividad);
            }
        });
        //creo los eventos

        s.setOnClickListener(this);
        r.setOnClickListener(this);
        m.setOnClickListener(this);
        d.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String Cifra1 = num1.getText().toString();
        String Cifra2 = num2.getText().toString();

        int int1 = Integer.parseInt(Cifra1);
        int int2 = Integer.parseInt(Cifra2);

        int rta = 0;

        switch (v.getId()) {
            case R.id.s:
                rta = int1 + int2;
                result = rta;
                signo = "+";
                guardar();
                break;
            case R.id.r:
                rta = int1 - int2;
                signo = "-";
                guardar();
                break;
            case R.id.m:
                rta = int1 * int2;
                signo = "*";
                guardar();
                break;
            case R.id.d:
                rta = int1 / int2;
                signo = "/";
                guardar();
                break;
        }
        resultado.setText("" + rta);
    }

    private void guardar() {
        ExamencalTable registro = new ExamencalTable();
        registro.integer1 = num1.getText().toString();
        registro.integer2 = num2.getText().toString();
        registro.operador = signo;
        registro.resultado = result;
        registro.save();
    }
}


