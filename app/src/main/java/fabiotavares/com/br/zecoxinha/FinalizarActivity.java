package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class FinalizarActivity extends AppCompatActivity {

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);
        carregarTela();

        //NovoPedido
        TextView novoPedido = findViewById(R.id.retornar);

        novoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FinalizarActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void carregarTela() {
        pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
        String comprovante = "Pedido de " + pedido.getNome() + "\n\n";

        if(!pedido.getHamburguer().equals(0)){
            comprovante = comprovante + pedido.getHamburguer().toString() + ": Hambúrguer\n";
        }
        if(!pedido.getSanduiche().equals(0)){
            comprovante = comprovante + pedido.getSanduiche().toString() + ": Sanduíche\n";
        }
        if(!pedido.getCachorroQuente().equals(0)){
            comprovante = comprovante + pedido.getCachorroQuente().toString() + ": Cachorro-quente\n";
        }
        if(!pedido.getBatataFrita().equals(0)){
            comprovante = comprovante + pedido.getBatataFrita().toString() + ": Batata Frita\n";
        }
        if(!pedido.getBatataRustica().equals(0)){
            comprovante = comprovante + pedido.getBatataRustica().toString() + ": Batata Rústica\n";
        }
        if(!pedido.getBatataChips().equals(0)){
            comprovante = comprovante + pedido.getBatataChips().toString() + ": Batata Chips\n";
        }
        if(!pedido.getRefrigerante().equals(0)){
            comprovante = comprovante + pedido.getRefrigerante().toString() + ": Refrigerante\n";
        }
        if(!pedido.getSuco().equals(0)){
            comprovante = comprovante + pedido.getSuco().toString() + ": Suco\n";
        }
        if(!pedido.getCerveja().equals(0)){
            comprovante = comprovante + pedido.getCerveja().toString() + ": Cerveja\n";
        }
        if(pedido.isDinheiro()){
            comprovante = comprovante + "\nForma de pagamento: Dinheiro\n";
        }
        if(pedido.isDebito()){
            comprovante = comprovante + "\nForma de pagamento: Debito\n";
        }
        if(pedido.isCredito()){
            comprovante = comprovante + "\nForma de pagamento: Crédito\n";
        }
        comprovante = comprovante + "\nTotal R$:: " + pedido.getTotal();

        TextView seuPedido = (TextView)findViewById(R.id.seu_pedido);
        seuPedido.setText(comprovante);

    }
}
