package com.example.mercatec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrar extends AppCompatActivity {

    EditText nome, email, senha, resenha;
    //Button signup, signin;
    Button cadastrar, acessar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.editTextTextPersonName5);
        email = (EditText) findViewById(R.id.editTextTextPersonName4);
        senha = (EditText) findViewById(R.id.editTextTextPersonName2);
        resenha = (EditText) findViewById(R.id.editTextTextPersonName);
        cadastrar = (Button) findViewById(R.id.button4);
        //acessar = (Button) findViewById(R.id.button);
        DB = new DBHelper(this);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = nome.getText().toString();
                String pass = senha.getText().toString();
                String repass = resenha.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(cadastrar.this, "Por favor, digite os dados!", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.verificaNome(user);
                        if(checkuser==false){
                            Boolean insert = DB.cadastra(user, pass);
                            if(insert==true){
                                Toast.makeText(cadastrar.this, "Dados armazenados com sucesso!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(cadastrar.this, "Falha durante a operação de registro!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(cadastrar.this, "Usuário existente! Favor Logar",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(cadastrar.this, "Senhas são diferentes!", Toast.LENGTH_SHORT).show();
                    }
                } }
        });}}