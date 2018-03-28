package com.example.frasson.app_homecare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.frasson.app_homecare.DataBaseObject.ProfissionalDAO;
import com.example.frasson.app_homecare.usuarios.Profissional;


public class CadastroProfissionalActivity extends AppCompatActivity {

    private DadosCadastrais dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_profissional);

        dados = new DadosCadastrais(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastro, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case R.id.menu_cadastro_ok:
                    Profissional profissional = dados.getProfissional();
                    ProfissionalDAO dao = new ProfissionalDAO(this);
                    dao.insere(profissional);
                    dao.close();

                    Toast.makeText(CadastroProfissionalActivity.this, "Profissional " + profissional.getNome() +  " salvo!", Toast.LENGTH_SHORT).show();

                    finish();
                    break;
            }

            return super.onOptionsItemSelected(item);
    }

    }


