package com.douglasmaziero.hamburgueriaz.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.douglasmaziero.hamburgueriaz.R;
import com.douglasmaziero.hamburgueriaz.model.Adicional;
import com.douglasmaziero.hamburgueriaz.model.Pedido;

public class FinalizarPedidoActivity extends AppCompatActivity {

    TextView textNome, textQuantidade, textTotal, textBacon, textQueijo, textOnion, buttonRequest ,inputEmail;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        textNome = findViewById(R.id.textNome);
        textQuantidade = findViewById(R.id.textQuantidade);
        textTotal = findViewById(R.id.textValor);
        textBacon = findViewById(R.id.textBacon);
        textQueijo = findViewById(R.id.textQueijo);
        textOnion = findViewById(R.id.textOnion);
        buttonRequest = findViewById(R.id.buttonRequestEmail);
        inputEmail = findViewById(R.id.inputEmail);




        textNome.setText(getIntent().getStringExtra("textNameCliente"));
        textQuantidade.setText(String.valueOf(getIntent().getIntExtra("textQuantidade", 0)));
        textTotal.setText(String.valueOf(getIntent().getDoubleExtra("textValor", 0)));
        textBacon.setText(getIntent().getBooleanExtra("textBacon", false) ? "Sim" : "Não");
        textQueijo.setText(getIntent().getBooleanExtra("textQueijo", false) ? "Sim" : "Não");
        textOnion.setText(getIntent().getBooleanExtra("textOnion", false) ? "Sim" : "Não");

        buttonRequest.setOnClickListener(v -> {
            if (inputEmail.getText().toString().isEmpty()) {
                inputEmail.setError("Digite seu email");
                return;
            }

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{inputEmail.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de " + textNome.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, "Nome do cliente : " + textNome.getText().toString() + "\n" +
                    "Tem Bacon: " + textBacon.getText().toString() + "\n" +
                    "Tem Queijo: " + textQueijo.getText().toString() + "\n" +
                    "Tem Onion: " + textOnion.getText().toString() + "\n" +
                    "Quantidade: " + textQuantidade.getText().toString() + "\n" +
                    "Preço final: R$ " + textTotal.getText().toString() + "\n");
            startActivity(intent);
        });
    }
}