package com.example.mercatec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telacliente extends AppCompatActivity {
    private Button butao;
    private Button produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacliente);
        // CÓDIGO LOGIN
        butao = findViewById(R.id.button2);
        butao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista = new Intent(telacliente.this, telainsert.class);
                startActivity(lista);
            }
        });
        // CÓDIGO SIGNUP
        produtos = findViewById(R.id.button);
        produtos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busca = new Intent (telacliente.this, ListaProdutos.class);
                startActivity(busca);
            }
        });

    }
}
