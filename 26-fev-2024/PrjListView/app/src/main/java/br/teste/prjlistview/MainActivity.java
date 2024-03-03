package br.teste.prjlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnMostrar;
    ListView lstMostrar; //mostra o array como uma lista
    // List<String> lstNomes;
    EditText edtQtdeHora, edtValHora;
    List<String> lstSalarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMostrar = findViewById(R.id.btnMostrar);
        lstMostrar = findViewById(R.id.lstMostrar);
        edtQtdeHora = findViewById(R.id.edtQtdeHora);
        edtValHora = findViewById(R.id.edtValHora);

        /*lstNomes = new ArrayList<>();
        lstNomes.add("Opção1");
        lstNomes.add("Opção2");
        lstNomes.add("Opção3");*/

        lstSalarios = new ArrayList<>();

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    /*ArrayAdapter<String> adp = new ArrayAdapter<> //adapta o xml do listView com o array
                        (getBaseContext(), android.R.layout.simple_list_item_1, lstNomes);
                    lstMostrar.setAdapter(adp); //mostre o adaptador*/

                    int qtdeHora = Integer.parseInt(edtQtdeHora.getText().toString());
                    int valHora = Integer.parseInt(edtValHora.getText().toString());

                    if(qtdeHora <= 0 || valHora <= 0){
                        Toast.makeText(MainActivity.this, "Nenhum valor pode estar nulo!!", Toast.LENGTH_LONG).show();
                        edtQtdeHora.setText("");
                        edtValHora.setText("");
                        return;
                    }else{
                        int total = qtdeHora * valHora;

                        lstSalarios.add("R$" + total + ",00");
                        ArrayAdapter<String> adp = new ArrayAdapter<>
                                (getBaseContext(), android.R.layout.simple_list_item_1, lstSalarios);
                        lstMostrar.setAdapter(adp);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Erro!!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        lstMostrar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if(i == 0){
                    Intent it = new Intent(getBaseContext(),Pagina2.class);
                    startActivity(it);
                }
                else if(i == 1){
                    Intent it = new Intent(getBaseContext(),Pagina3.class);
                    startActivity(it);
                }
                else{
                    Intent it = new Intent(getBaseContext(),Pagina4.class);
                    startActivity(it);
                }

                if(i > 2){
                    Toast.makeText(MainActivity.this, "Erro!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}