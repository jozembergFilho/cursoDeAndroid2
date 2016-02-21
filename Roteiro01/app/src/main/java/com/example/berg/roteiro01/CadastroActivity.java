package com.example.berg.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    //declaração das variáveis
    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfirmarsenha;
    private Button mBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        //recuperar Id's que foram atribuidas na view
        mNome = (EditText)findViewById(R.id.nome);
        mSobrenome = (EditText)findViewById(R.id.sobrenome);
        mUsuario = (EditText)findViewById(R.id.usuario);
        mSenha = (EditText)findViewById(R.id.senha);
        mConfirmarsenha = (EditText)findViewById(R.id.confirmarsenha);
        mBotao = (Button)findViewById(R.id.btn);

        //Método responsável pelo evento do click de botão
        mBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }
    //Método responsável por os dados fornecidos na tela (nome,sobrenome,usuario,senha e confirmarsenha)
    private void cadastrar(){
        String nome = mNome.getText().toString();
        String sobrenome = mSobrenome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confirmarSenha = mConfirmarsenha.getText().toString();

        View focus = null; // objeto encarregado de lançar a mensagem de tratamento de eventos
        boolean exibir = false;//variável para auxiliar na exibição do focus

        if(TextUtils.isEmpty(nome)){// verificar se o campo nome está vazio
            mNome.setError("Campo vazio!"); // menssagem de tratamento para View mNome
            focus = mNome; //atribuição de mensagem ao focus
            exibir = true;
        }
        if(TextUtils.isEmpty(sobrenome)){// verificar se o campo sobrenome está vazio
            mSobrenome.setError("Campo vazio!");// menssagem de tratamento para View mSobrenome
            focus = mSobrenome; //atribuição de mensagem ao focus
            exibir = true;

        }
        if(TextUtils.isEmpty(usuario)){// verificar se o campo usuario está vazio
            mUsuario.setError("Campo vazio!");// menssagem de tratamento para View mUsuario
            focus = mUsuario;//atribuição de mensagem ao focus
            exibir = true;

        }
        if(TextUtils.isEmpty(senha)){// verificar se o campo senha está vazio
            mSenha.setError("Campo vazio!");// menssagem de tratamento para View mSenha
            focus = mSenha;//atribuição de mensagem ao focus
            exibir = true;

        }
        if(TextUtils.isEmpty(confirmarSenha)){// verificar se o campo confirmarsenha está vazio
            mConfirmarsenha.setError("Campo vazio!");// menssagem de tratamento para View mConfirmarsenha
            focus = mConfirmarsenha;//atribuição de mensagem ao focus
            exibir = true;

        }
        if(exibir){
            focus.requestFocus(); //retorna um boolean true para exibir a mensagem de erro
        }

        else{
            if(senha.equals(confirmarSenha)){
                Intent intent = new Intent(this, MainActivity.class);//Intenção de mudança de tela, caso o cadastro seja válido, passando como parâmetro a Acitviy atual e a futura
                Bundle bundle = new Bundle(); //Instância do Objeto necessário para enviar parametros para minha nova Activity
                bundle.putString("nome", nome); //guardar o nome do usuario no Bundle, e uma chave para sua futura busca
                intent.putExtras(bundle);//guardar na sua Intent o Bundle
                startActivity(intent);//Chamada da minha nova Activity
                finish();// encerrar a execursão da activty atual, para que depois de efetuar o cadastro o usuario não consiga mais voltar.
            }
            else{
                mConfirmarsenha.setError("A senha e a confirmação de senha não conferem!");// menssagem de tratamento para View mConfirmarsenha
                focus = mConfirmarsenha;//atribuição de mensagem ao focus
                focus.requestFocus();

            }
        }
    }


}

