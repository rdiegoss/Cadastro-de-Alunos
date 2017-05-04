package com.example.rodrigodiego.cadastroaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ListaAlunoActivity extends AppCompatActivity {

    private EditText edNome;
    private Button botao;
    private ListView listView;

    private List<String> listaAluno;
    private ArrayAdapter<String> adapter;
    private int adapterLayout = android.R.layout.simple_list_item_1;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_aluno);

        edNome = (EditText) findViewById(R.id.edNomeListagem);
        botao = (Button) findViewById(R.id.btAddListagem);
        listView = (ListView) findViewById(R.id.lvListagem);

        listaAluno = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, adapterLayout, listaAluno);

        listView.setAdapter(adapter);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAluno.add(edNome.getText().toString());
                edNome.setText("");
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();

        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_novo:
//                Toast.makeText(ListaAlunoActivity.this, "Você clicou no NOVO", Toast.LENGTH_LONG).show();
//                return false;
                Intent intent = new Intent(ListaAlunoActivity.this, FormularioActivity.class);
                startActivity(intent);
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
