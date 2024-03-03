package br.teste.prjpagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNome;
    Button btnProximo;
    Compartilha cp = new Compartilha();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = findViewById(R.id.edtNome);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String nome = edtNome.getText().toString();

                    if(nome.equals("")){
                        Toast.makeText(MainActivity.this, "Digite algum valor!!", Toast.LENGTH_LONG).show();
                        edtNome.setText("");
                        return;
                    }else{
                        cp.setNome(nome);

                        Intent it = new Intent(getBaseContext(), Pagina2.class);
                        startActivity(it);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Erro!!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}