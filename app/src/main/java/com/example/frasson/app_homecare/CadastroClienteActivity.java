package com.example.frasson.app_homecare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.frasson.app_homecare.DataBaseObject.ClienteDAO;
import com.example.frasson.app_homecare.usuarios.Cliente;

public class CadastroClienteActivity extends AppCompatActivity {


    private DadosCadastrais dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        
        dados = new DadosCadastrais(this);


    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu){
           MenuInflater inflater = getMenuInflater();
           inflater.inflate(R.menu.menu_cadastro, menu);

            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cadastro_ok:
                Cliente cliente = dados.getCliente();
                ClienteDAO dao = new ClienteDAO(this);
                dao.insere(cliente);
                dao.close();

                Toast.makeText(CadastroClienteActivity.this, "Cliente " + cliente.getNome() + " salvo!", Toast.LENGTH_SHORT).show();


                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

