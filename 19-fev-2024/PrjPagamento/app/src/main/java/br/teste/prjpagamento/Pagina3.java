package br.teste.prjpagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pagina3 extends AppCompatActivity {
    EditText edtValHora;
    Button btnProximo;
    Compartilha cp = new Compartilha();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina3);
        edtValHora = findViewById(R.id.edtValHora);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int valHora = Integer.parseInt(edtValHora.getText().toString());

                    if(valHora <= 0){
                        Toast.makeText(Pagina3.this, "Digite algum valor!!", Toast.LENGTH_LONG).show();
                        edtValHora.setText("");
                        return;
                    }else{
                        cp.setValHora(valHora);

                        Intent it = new Intent(getBaseContext(), Pagina4.class);
                        startActivity(it);
                    }
                }catch (Exception e){
                    Toast.makeText(Pagina3.this, "Erro!!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}