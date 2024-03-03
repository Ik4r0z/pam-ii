package br.teste.prjpagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pagina4 extends AppCompatActivity {
    Button btnMostrar;
    TextView txtMostrar;
    Compartilha cp = new Compartilha();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina4);
        btnMostrar = findViewById(R.id.btnMostrar);
        txtMostrar = findViewById(R.id.txtMostrar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = cp.getNome();
                int qtdeHora = cp.getQtdeHora();
                int valHora = cp.getValHora();
                int total = qtdeHora * valHora;

                txtMostrar.setText(nome + "\n" + "R$ " + total + ",00");
            }
        });
    }
}