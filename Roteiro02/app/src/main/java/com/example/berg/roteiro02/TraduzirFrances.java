package com.example.berg.roteiro02;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TraduzirFrances extends AppCompatActivity {

    private TextView mCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduzir_frances);
        mCor = (TextView)findViewById(R.id.cor);
        Bundle bundle = getIntent().getExtras();
        String cor = bundle.getString("texto");
        if(cor.equalsIgnoreCase("azul")){
            mCor.setText("Tradução da cor " + cor + " em francês: Bleu");
        }else if(cor.equalsIgnoreCase("amarelo")){
            mCor.setText("Tradução da cor " + cor + " em francês: Jaune");
        }else{
            mCor.setText("Tradução da cor " + cor + " em francês: Rouge");
        }
        ((Button)findViewById(R.id.btn4)).setOnClickListener(new onClick());
    }

    private class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
