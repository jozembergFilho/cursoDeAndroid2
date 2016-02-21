package com.example.berg.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaração de variável
    private TextView mTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTexto = (TextView)findViewById(R.id.texto);
        Bundle bundle = getIntent().getExtras(); //capturar os parâmetros da minha Intent
        String texto = bundle.getString("nome"); //O nome do usuário. Definido através da chave "nome"
        mTexto.setText("Cadastro realizado com sucesso! Bem vindo " + texto +"."); //atribuir a minha View mTexto a menssagem mostrada na tela.

    }
}
