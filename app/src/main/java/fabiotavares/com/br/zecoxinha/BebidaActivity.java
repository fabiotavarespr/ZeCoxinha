package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class BebidaActivity extends AppCompatActivity {

    private Pedido pedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida);
        carregarTela();

        //Retornar
        TextView retornar = findViewById(R.id.retornar);

        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BebidaActivity.this, AcompanhamentoActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });

        //Prosseguir
        TextView proximo = findViewById(R.id.proximo);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BebidaActivity.this, FormaPagamentoActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });
    }

    private void carregarTela(){
        pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
        displayQuantidade(pedido.getRefrigerante(), (TextView)findViewById(R.id.quantidade_refrigerante));
        displayQuantidade(pedido.getSuco(), (TextView)findViewById(R.id.quantidade_suco));
        displayQuantidade(pedido.getCerveja(), (TextView)findViewById(R.id.quantidade_cerveja));
    }

    private void displayQuantidade(int quantity, TextView textView) {
        textView.setText("" + quantity);
        TextView total = (TextView)findViewById(R.id.total);
        total.setText(pedido.getTotal().toString());
    }


    public void addRefrigerante(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_refrigerante);
        pedido.setRefrigerante(new Integer(textView.getText().toString()) );
        if (pedido.getRefrigerante() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setRefrigerante(pedido.getRefrigerante() + 1);
        displayQuantidade(pedido.getRefrigerante(), (TextView)findViewById(R.id.quantidade_refrigerante));
    }


    public void delRefrigerante(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_refrigerante);
        pedido.setRefrigerante(new Integer(textView.getText().toString()) );
        if (pedido.getRefrigerante() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setRefrigerante(pedido.getRefrigerante() - 1);
        displayQuantidade(pedido.getRefrigerante(), (TextView)findViewById(R.id.quantidade_refrigerante));
    }

    public void addSuco(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_suco);
        pedido.setSuco(new Integer(textView.getText().toString()) );
        if (pedido.getSuco() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setSuco(pedido.getSuco() + 1);
        displayQuantidade(pedido.getSuco(), (TextView)findViewById(R.id.quantidade_suco));
    }


    public void delSuco(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_suco);
        pedido.setSuco(new Integer(textView.getText().toString()) );
        if (pedido.getSuco() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setSuco(pedido.getSuco() - 1);
        displayQuantidade(pedido.getSuco(), (TextView)findViewById(R.id.quantidade_suco));
    }

    public void addCerveja(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_cerveja);
        pedido.setCerveja(new Integer(textView.getText().toString()) );
        if (pedido.getCerveja() == 10) {
            mensagemMaximo();
            return;
        }
        pedido.setCerveja(pedido.getCerveja() + 1);
        displayQuantidade(pedido.getCerveja(), (TextView)findViewById(R.id.quantidade_cerveja));
    }


    public void delCerveja(View view) {
        TextView textView = (TextView)findViewById(R.id.quantidade_cerveja);
        pedido.setCerveja(new Integer(textView.getText().toString()) );
        if (pedido.getCerveja() == 0) {
            mensagemMinimo();
            return;
        }
        pedido.setCerveja(pedido.getCerveja() - 1);
        displayQuantidade(pedido.getCerveja(), (TextView)findViewById(R.id.quantidade_cerveja));
    }

    private void mensagemMinimo(){
        Toast.makeText(this, "A quantidade não pode ser menor que 0", Toast.LENGTH_SHORT).show();
    }

    private void mensagemMaximo(){
        Toast.makeText(this, "Quantidade não pode ser maior que 10", Toast.LENGTH_SHORT).show();
    }
}
