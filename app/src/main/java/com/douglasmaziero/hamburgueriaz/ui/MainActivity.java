package com.douglasmaziero.hamburgueriaz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.douglasmaziero.hamburgueriaz.R;
import com.douglasmaziero.hamburgueriaz.model.Adicional;
import com.douglasmaziero.hamburgueriaz.model.Pedido;

public class MainActivity extends AppCompatActivity {
    Pedido pedido = new Pedido();
    private TextView textCount;
    private Button buttonMore;
    private Button buttonLess;

    private Button buttonRequest;
    private TextView textResume;
    private TextView textValue;
    private EditText inputName;
    private CheckBox checkBacon;
    private CheckBox checkQueijo;
    private CheckBox checkOnion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputName = findViewById(R.id.inputName);
        textResume = findViewById(R.id.textResume);
        buttonMore = findViewById(R.id.buttonMore);
        buttonLess = findViewById(R.id.buttonLess);
        textCount = findViewById(R.id.textCount);
        checkBacon = findViewById(R.id.checkBacon);
        checkQueijo = findViewById(R.id.checkQueijo);
        checkOnion = findViewById(R.id.checkOnion);
        buttonRequest = findViewById(R.id.buttonRequest);

        buttonMore.setOnClickListener(v -> {
            pedido.adicionarLanche();
            textCount.setText(String.valueOf(pedido.getQuantidade()));
        });

        buttonLess.setOnClickListener(v -> {
            pedido.tirarLanche();
            textCount.setText(String.valueOf(pedido.getQuantidade()));
        });

        buttonRequest.setOnClickListener(v -> {
            pedido.setNomeCliente(inputName.getText().toString());

            if (checkBacon.isChecked()) {
                pedido.adicionarAdicional(new Adicional("Bacon", 2));
            }
            if (checkQueijo.isChecked()) {
                pedido.adicionarAdicional(new Adicional("Queijo", 2));
            }
            if (checkOnion.isChecked()) {
                pedido.adicionarAdicional(new Adicional("Onion Rings", 3));
            }
            pedido.finalizarPedido();
            Intent intent = new Intent(MainActivity.this, FinalizarPedidoActivity.class);
            intent.putExtra("textNameCliente", pedido.getNomeCliente());
            intent.putExtra("textBacon", checkBacon.isChecked());
            intent.putExtra("textQueijo", checkQueijo.isChecked());
            intent.putExtra("textOnion", checkOnion.isChecked());
            intent.putExtra("textQuantidade", pedido.getQuantidade());
            intent.putExtra("textValor", pedido.calculaTotal());
            startActivity(intent);
        });
    }
}