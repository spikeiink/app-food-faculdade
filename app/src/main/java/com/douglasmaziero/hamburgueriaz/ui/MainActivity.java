package com.douglasmaziero.hamburgueriaz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.douglasmaziero.hamburgueriaz.R;

public class MainActivity extends AppCompatActivity {

    public static int countView = 0;
    public static int valueComplement = 0;
    public TextView textView;
    public static int valueBurguer = 0;


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
    }

    public void addValue(View view)
    {
        textView = findViewById(R.id.textCount);

        countView = Integer.parseInt(textView.getText().toString());
        countView++;
        textView.setText(String.valueOf(countView));

        valueBurguer += 20;
    }

    public void subValue(View view){
        countView--;

        if(countView < 0)
           return;

        textView.setText(String.valueOf(countView));

        valueBurguer -= 20;
    }

    public void calculateValue(View view) {
        CheckBox checkBox = (CheckBox) view;

        if (checkBox.isChecked()) {
            valueComplement += Integer.parseInt(view.getTag().toString());

        } else {
            valueComplement -= Integer.parseInt(view.getTag().toString());

        }
    }

    public void sendRequest(View view){
        EditText name = findViewById(R.id.inputName);
        int i = 0;

        if(valueComplement != 0){
            i = countView * valueComplement;
        }

        int finalOrder = valueBurguer + i;

        if(name.getText().toString().isEmpty()){
            name.setError("Digite seu nome");
            return;
        } else
            name.setError(null);

        TextView textValue = findViewById(R.id.textValue);
        textValue.setText("R$ " + finalOrder);

        Intent intent = new Intent(this, FinalizarPedidoActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("value", finalOrder);
        intent.putExtra("count", countView);

        startActivity(intent);

    }
}