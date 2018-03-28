package com.example.frasson.app_homecare;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;

        import com.example.frasson.app_homecare.Lista.ListaClientesActivity;
        import com.example.frasson.app_homecare.Lista.ListaProfissionaisActivity;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

           Button botaoListaCliente = (Button) findViewById(R.id.button_clientes);
            botaoListaCliente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentVaiListaCliente = new Intent(MainActivity.this, ListaClientesActivity.class);
                    startActivity(intentVaiListaCliente);
                }
            });

        Button botaoListaProfissional = (Button) findViewById(R.id.button_profissionais);
        botaoListaProfissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiListaProfissional = new Intent(MainActivity.this, ListaProfissionaisActivity.class);
                startActivity(intentVaiListaProfissional);
            }
        });
    }

}



