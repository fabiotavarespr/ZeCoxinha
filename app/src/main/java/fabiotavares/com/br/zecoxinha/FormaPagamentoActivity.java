package fabiotavares.com.br.zecoxinha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import fabiotavares.com.br.zecoxinha.domain.Pedido;

public class FormaPagamentoActivity extends AppCompatActivity {

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pagamento);
        carregarTela();

        //Retornar
        TextView retornar = findViewById(R.id.retornar);

        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FormaPagamentoActivity.this, BebidaActivity.class);
                i.putExtra("obj_pedido", pedido);
                startActivity(i);
            }
        });

        //Prosseguir
        TextView proximo = findViewById(R.id.proximo);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validaTela()) {
                    Intent i = new Intent(FormaPagamentoActivity.this, FinalizarActivity.class);
                    i.putExtra("obj_pedido", pedido);
                    startActivity(i);
                }
            }
        });
    }

    private void carregarTela() {
        pedido = (Pedido) getIntent().getSerializableExtra("obj_pedido");
        if(pedido.isDinheiro()){
            RadioButton radioButton = findViewById(R.id.radio_dinheiro);
            radioButton.setChecked(true);
        }
        if(pedido.isDebito()){
            RadioButton radioButton = findViewById(R.id.radio_debito);
            radioButton.setChecked(true);
        }
        if(pedido.isCredito()){
            RadioButton radioButton = findViewById(R.id.radio_credito);
            radioButton.setChecked(true);
        }
        TextView total = (TextView)findViewById(R.id.total);
        total.setText(pedido.getTotal().toString());
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_dinheiro:
                if (checked) {
                    pedido.setDinheiro(true);
                    pedido.setDebito(false);
                    pedido.setCredito(false);
                    break;
                }
            case R.id.radio_debito:
                if (checked) {
                    pedido.setDinheiro(false);
                    pedido.setDebito(true);
                    pedido.setCredito(false);
                    break;
                }
            case R.id.radio_credito:
                if (checked) {
                    pedido.setDinheiro(false);
                    pedido.setDebito(false);
                    pedido.setCredito(true);
                    break;
                }
        }
    }

    private boolean validaTela(){
        if(pedido.getTotal().equals(0)){
            Toast.makeText(this, "Nenhum pedido foi selecionado", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!pedido.isDinheiro() && !pedido.isDebito() && !pedido.isCredito()){
            Toast.makeText(this, "Selecione a forma de pagamento", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
