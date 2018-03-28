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

import com.example.frasson.app_homecare.CadastroClienteActivity;
import com.example.frasson.app_homecare.DataBaseObject.ClienteDAO;
import com.example.frasson.app_homecare.R;
import com.example.frasson.app_homecare.usuarios.Cliente;

import java.util.List;

public class ListaClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes =  dao.buscaClientes();
        dao.close();

        ListView listaClientes = (ListView) findViewById(R.id.lista_clientes);
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);
        listaClientes.setAdapter(adapter);

        Button cadastrarCliente = (Button) findViewById(R.id.button_cadastrar_cliente);
        cadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiCadastro = new Intent(ListaClientesActivity.this, CadastroClienteActivity.class);
                startActivity(intentVaiCadastro);
            }
        });
    }

}
