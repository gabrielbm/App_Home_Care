package com.example.frasson.app_homecare;

import android.widget.EditText;

import com.example.frasson.app_homecare.usuarios.Cliente;
import com.example.frasson.app_homecare.usuarios.Profissional;

public class DadosCadastrais {

    private EditText profissionalEspecialidade;
    private EditText profissionalTelefone;
    private EditText profissionalNome;
    private EditText clienteNome;
    private EditText clienteTelefone;
    private EditText clienteEndereco;

    public DadosCadastrais(CadastroClienteActivity cliente){
     clienteNome = (EditText) cliente.findViewById(R.id.cliente_nome);
     clienteTelefone = (EditText) cliente.findViewById(R.id.cliente_telefone);
     clienteEndereco = (EditText) cliente.findViewById(R.id.cliente_endereco);
    }
    public Cliente getCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteNome.getText().toString());
        cliente.setTelefone(clienteTelefone.getText().toString());
        cliente.setEndereco(clienteEndereco.getText().toString());

        return cliente;
    }

    public DadosCadastrais(CadastroProfissionalActivity profissional){

        profissionalNome = (EditText) profissional.findViewById(R.id.profissionalNome);
        profissionalTelefone = (EditText) profissional.findViewById(R.id.profissionalTelefone);
        profissionalEspecialidade = (EditText) profissional.findViewById(R.id.profissionalEspecialidade);

    }
    public Profissional getProfissional() {
        Profissional profissional = new Profissional();
        profissional.setNome(profissionalNome.getText().toString());
        profissional.setTelefone(profissionalTelefone.getText().toString());
        profissional.setEspecialidade(profissionalEspecialidade.getText().toString());

        return profissional;
    }

}
