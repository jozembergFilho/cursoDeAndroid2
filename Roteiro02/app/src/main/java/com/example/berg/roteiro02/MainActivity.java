package com.example.berg.roteiro02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mCor;
    private Button mBtn;
    private Button mBtn2;
    private Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCor = (EditText)findViewById(R.id.cor);
        mBtn = (Button)findViewById(R.id.btn);
        mBtn2 = (Button)findViewById(R.id.btn2);
        mBtn3 = (Button)findViewById(R.id.btn3);



        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cor = mCor.getText().toString();
                if(cor.equalsIgnoreCase("AZUL")|| cor.equalsIgnoreCase("AMARELO") || cor.equalsIgnoreCase("VERMELHO")){
                    Bundle bundle = new Bundle();
                    bundle.putString("texto",cor);
                    Intent intent = new Intent("TRADUZIR");
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else{
                    View focus = null;
                    mCor.setError("Cor inválida!");
                    focus = mCor;
                    focus.requestFocus();
                }

            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cor = mCor.getText().toString();
                if(cor.equalsIgnoreCase("AZUL")|| cor.equalsIgnoreCase("AMARELO") || cor.equalsIgnoreCase("VERMELHO")){
                    Intent intent = new Intent("TRADUZIR").addCategory("TRADUZIRINGLES");
                    Bundle bundle = new Bundle();
                    bundle.putString("texto",cor);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }else{
                    View focus = null;
                    mCor.setError("Cor inválida!");
                    focus = mCor;
                    focus.requestFocus();
                }
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cor = mCor.getText().toString();
                if (cor.equalsIgnoreCase("AZUL") || cor.equalsIgnoreCase("AMARELO") || cor.equalsIgnoreCase("VERMELHO")) {
                    Intent intent = new Intent("TRADUZIR").addCategory("TRADUZIRFRANCES");
                    Bundle bundle = new Bundle();
                    bundle.putString("texto", cor);
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    View focus = null;
                    mCor.setError("Cor inválida!");
                    focus = mCor;
                    focus.requestFocus();
                }

            }
        });


    }


}
