package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class AcompanhamentoActivity extends
        AppCompatActivity {

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhamento);
        carregarTela();


        //Retornar
        TextView retornar = findViewById(R.id.retornar);

        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcompanhamentoActivity.this, SanduicheActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });

        //Prosseguir
        TextView proximo = findViewById(R.id.proximo);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AcompanhamentoActivity.this, BebidaActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });
    }

    private void carregarTela(){
        pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
        displayQuantidade(pedido.getBatataFrita(), (TextView)findViewById(R.id.quantidade_batata_frita));
        displayQuantidade(pedido.getBatataRustica(), (TextView)findViewById(R.id.quantidade_batata_rustica));
        displayQuantidade(pedido.getBatataChips(), (TextView)findViewById(R.id.quantidade_batata_chips));
    }

    private void displayQuantidade(int quantity, TextView textView) {
        textView.setText("" + quantity);
        TextView total = (TextView)findViewById(R.id.total);
        total.setText(pedido.getTotal().toString());
    }


    public void addBatataFrita(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_frita);
        pedido.setBatataFrita(new Integer(textView.getText().toString()) );
        if (pedido.getBatataFrita() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setBatataFrita(pedido.getBatataFrita() + 1);
        displayQuantidade(pedido.getBatataFrita(), (TextView)findViewById(R.id.quantidade_batata_frita));
    }


    public void delBatataFrita(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_frita);
        pedido.setBatataFrita(new Integer(textView.getText().toString()) );
        if (pedido.getBatataFrita() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setBatataFrita(pedido.getBatataFrita() - 1);
        displayQuantidade(pedido.getBatataFrita(), (TextView)findViewById(R.id.quantidade_batata_frita));
    }

    public void addBatataRustica(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_rustica);
        pedido.setBatataRustica(new Integer(textView.getText().toString()) );
        if (pedido.getBatataRustica() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setBatataRustica(pedido.getBatataRustica() + 1);
        displayQuantidade(pedido.getBatataRustica(), (TextView)findViewById(R.id.quantidade_batata_rustica));
    }


    public void delBatataRustica(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_rustica);
        pedido.setBatataRustica(new Integer(textView.getText().toString()) );
        if (pedido.getBatataRustica() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setBatataRustica(pedido.getBatataRustica() - 1);
        displayQuantidade(pedido.getBatataRustica(), (TextView)findViewById(R.id.quantidade_batata_rustica));
    }

    public void addBatataChips(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_chips);
        pedido.setBatataChips(new Integer(textView.getText().toString()) );
        if (pedido.getBatataChips() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setBatataChips(pedido.getBatataChips() + 1);
        displayQuantidade(pedido.getBatataChips(), (TextView)findViewById(R.id.quantidade_batata_chips));
    }


    public void delBatataChips(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_batata_chips);
        pedido.setBatataChips(new Integer(textView.getText().toString()) );
        if (pedido.getBatataChips() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setBatataChips(pedido.getBatataChips() - 1);
        displayQuantidade(pedido.getBatataChips(), (TextView)findViewById(R.id.quantidade_batata_chips));
    }

    private void mensagemMinimo(){
        Toast.makeText(this, "A quantidade não pode ser menor que 0", Toast.LENGTH_SHORT).show();
    }

    private void mensagemMaximo(){
        Toast.makeText(this, "Quantidade não pode ser maior que 10", Toast.LENGTH_SHORT).show();
    }
}
