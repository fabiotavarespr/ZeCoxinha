package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class MainActivity extends AppCompatActivity {

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicia um pedido
        Button iniciar = findViewById(R.id.iniciar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validaTela()) {
                    Intent i = new Intent(MainActivity.this, SanduicheActivity.class);
                    i.putExtra("obj_pedido", pedido);
                    startActivity(i);
                }
            }
        });

        try {
            pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
            setNome(pedido.getNome());

        } catch (Exception e) {
            pedido = new Pedido();
        }

    }

    private boolean validaTela() {
        String nome = getNome();
        if (nome.equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor, digite seu nome!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            pedido.setNome(getNome());
            return true;
        }

    }

    private String getNome() {
        TextView textView = findViewById(R.id.nome_field);
        return textView.getText().toString();
    }

    private void setNome(String nome) {
        TextView textView = findViewById(R.id.nome_field);
        textView.setText(nome);
    }
}
