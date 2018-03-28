package com.example.frasson.app_homecare.Lista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.frasson.app_homecare.CadastroProfissionalActivity;
import com.example.frasson.app_homecare.DataBaseObject.ProfissionalDAO;
import com.example.frasson.app_homecare.R;
import com.example.frasson.app_homecare.usuarios.Profissional;

import java.time.Instant;
import java.util.List;

public class ListaProfissionaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profissionais);

        ProfissionalDAO dao = new ProfissionalDAO(this);
        List<Profissional> profissionais = dao.buscaProfissionais();
        dao.close();

        ListView listaProfissionais =(ListView) findViewById(R.id.lista_profissionais);
        ArrayAdapter<Profissional> adapter = new ArrayAdapter<Profissional>(this, android.R.layout.simple_list_item_1, profissionais);
        listaProfissionais.setAdapter(adapter);

        Button cadastrarProfissionais = (Button) findViewById(R.id.button_cadastrar_profissionais);
        cadastrarProfissionais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiCadastro = new Intent(ListaProfissionaisActivity.this, CadastroProfissionalActivity.class);
                startActivity(intentVaiCadastro);
            }
        });

    }



}
