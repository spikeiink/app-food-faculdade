package com.douglasmaziero.hamburgueriaz.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.douglasmaziero.hamburgueriaz.R;
import com.douglasmaziero.hamburgueriaz.model.Adicional;
import com.douglasmaziero.hamburgueriaz.model.Pedido;

public class FinalizarPedidoActivity extends AppCompatActivity {

    TextView textNome, textQuantidade, textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        textNome = findViewById(R.id.textNome);
        textQuantidade = findViewById(R.id.textQuantidade);
        textTotal = findViewById(R.id.textValor);


       
    }


}