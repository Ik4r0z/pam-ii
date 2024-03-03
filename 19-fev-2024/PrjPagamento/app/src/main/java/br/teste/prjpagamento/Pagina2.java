package br.teste.prjpagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pagina2 extends AppCompatActivity {
    EditText edtQtdeHora;
    Button btnProximo;
    Compartilha cp = new Compartilha();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);
        edtQtdeHora = findViewById(R.id.edtQtdeHora);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int qtdeHora = Integer.parseInt(edtQtdeHora.getText().toString());

                    if(qtdeHora <= 0){
                        Toast.makeText(Pagina2.this, "Digite algum valor!!", Toast.LENGTH_LONG).show();
                        edtQtdeHora.setText("");
                        return;
                    }else{
                        cp.setQtdeHora(qtdeHora);

                        Intent it = new Intent(getBaseContext(), Pagina3.class);
                        startActivity(it);
                    }
                }catch (Exception e){
                    Toast.makeText(Pagina2.this, "Erro!!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}