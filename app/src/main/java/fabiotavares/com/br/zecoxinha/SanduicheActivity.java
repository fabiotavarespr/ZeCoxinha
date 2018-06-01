package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class SanduicheActivity extends AppCompatActivity {

    private Pedido pedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanduiche);
        carregarTela();

        //Retornar
        TextView retornar = findViewById(R.id.retornar);

        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SanduicheActivity.this, MainActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });

        //Prosseguir
        TextView proximo = findViewById(R.id.proximo);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SanduicheActivity.this, AcompanhamentoActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });
    }

    private void carregarTela(){
        pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
        displayQuantidade(pedido.getHamburguer(), (TextView)findViewById(R.id.quantidade_hamburguer));
        displayQuantidade(pedido.getSanduiche(), (TextView)findViewById(R.id.quantidade_sanduiche));
        displayQuantidade(pedido.getCachorroQuente(), (TextView)findViewById(R.id.quantidade_cachorro_quente));
    }


    private void displayQuantidade(int quantity, TextView textView) {
        textView.setText("" + quantity);
        TextView total = (TextView)findViewById(R.id.total);
        total.setText(pedido.getTotal().toString());
    }


    public void addHamburguer(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_hamburguer);
        pedido.setHamburguer(new Integer(textView.getText().toString()) );
        if (pedido.getHamburguer() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setHamburguer(pedido.getHamburguer() + 1);
        displayQuantidade(pedido.getHamburguer(), (TextView)findViewById(R.id.quantidade_hamburguer));
    }


    public void delHamburguer(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_hamburguer);
        pedido.setHamburguer(new Integer(textView.getText().toString()) );
        if (pedido.getHamburguer() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setHamburguer(pedido.getHamburguer() - 1);
        displayQuantidade(pedido.getHamburguer(), (TextView)findViewById(R.id.quantidade_hamburguer));
    }

    public void addSanduiche(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_sanduiche);
        pedido.setSanduiche(new Integer(textView.getText().toString()) );
        if (pedido.getSanduiche() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setSanduiche(pedido.getSanduiche() + 1);
        displayQuantidade(pedido.getSanduiche(), (TextView)findViewById(R.id.quantidade_sanduiche));
    }


    public void delSanduiche(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_sanduiche);
        pedido.setSanduiche(new Integer(textView.getText().toString()) );
        if (pedido.getSanduiche() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setSanduiche(pedido.getSanduiche() - 1);
        displayQuantidade(pedido.getSanduiche(), (TextView)findViewById(R.id.quantidade_sanduiche));
    }

    public void addCachorroQuente(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_cachorro_quente);
        pedido.setCachorroQuente(new Integer(textView.getText().toString()) );
        if (pedido.getCachorroQuente() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setCachorroQuente(pedido.getCachorroQuente() + 1);
        displayQuantidade(pedido.getCachorroQuente(), (TextView)findViewById(R.id.quantidade_cachorro_quente));
    }


    public void delCachorroQuente(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_cachorro_quente);
        pedido.setCachorroQuente(new Integer(textView.getText().toString()) );
        if (pedido.getCachorroQuente() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setCachorroQuente(pedido.getCachorroQuente() - 1);
        displayQuantidade(pedido.getCachorroQuente(), (TextView)findViewById(R.id.quantidade_cachorro_quente));
    }

    private void mensagemMinimo(){
        Toast.makeText(this, "A quantidade não pode ser menor que 0", Toast.LENGTH_SHORT).show();
    }

    private void mensagemMaximo(){
        Toast.makeText(this, "Quantidade não pode ser maior que 10", Toast.LENGTH_SHORT).show();
    }


}
