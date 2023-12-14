package com.example.mercatec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class telainsert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainsert);
    }
    public void minserir(View view){
        EditText etNome =  findViewById(R.id.etNome);
        EditText etquantidade = findViewById(R.id.etquantidade);
        EditText estquantidade=  findViewById(R.id.etquantidadeEs);
        produto produto = new produto(etNome.getText().toString(), Integer.parseInt(etquantidade.getText().toString()),Integer.parseInt(estquantidade.getText().toString()));

        produtoDAO produtoDAO = new produtoDAO(this);
        long id = produtoDAO.inserir(produto);

        Toast.makeText(this, "Produto salvo, " + id, Toast.LENGTH_LONG).show();
    }

    public  void  mListar(View view){

        Intent ListaProdutos = new Intent(this , ListaProdutos.class);
        startActivity(ListaProdutos);

    }
}