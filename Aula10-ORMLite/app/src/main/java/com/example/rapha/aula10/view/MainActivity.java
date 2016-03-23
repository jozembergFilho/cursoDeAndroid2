package com.example.rapha.aula10.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rapha.aula10.R;
import com.example.rapha.aula10.persistencia.DB;
import com.example.rapha.aula10.util.Aluno;
import com.example.rapha.aula10.util.Disciplina;
import com.example.rapha.aula10.util.Professor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Disciplina disciplina1 = new Disciplina("Persistência de dados",4);
        Disciplina disciplina2 = new Disciplina("Material de design",4);
        Disciplina disciplina3 = new Disciplina("Android básico", 6);


        Aluno aluno1 = new Aluno("123", "zezé");
        Aluno aluno2 = new Aluno("456", "dicamargo");
        Aluno aluno3 = new Aluno("789", "luciano");

        Professor professor1 = new Professor(disciplina1,"Luan Luna");
        Professor professor2 = new Professor(disciplina2,"Raphael Salviano");
        Professor professor3 = new Professor(disciplina3,"Ittalo Pessoa");


        DB db = new DB(this);

        try {
            db.insertDisciplina(disciplina1);
            db.insertDisciplina(disciplina2);
            db.insertDisciplina(disciplina3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //-------------------------------------------insert de alunos
        try {
            db.insertAluno(aluno1);
            db.insertAluno(aluno2);
            db.insertAluno(aluno3);
        } catch (SQLException e) {
            Log.e("ayty", "Erro ao inserir aluno");
        }
        //-------------------------------------------insert de professores
        try {
            db.insertProfessor(professor1);
            db.insertProfessor(professor2);
            db.insertProfessor(professor3);
        } catch (SQLException e) {
            Log.e("ayty", "Erro ao inserir professor");
        }
        //-----------------------------------------select de alunos
        List<Aluno> alunos = new ArrayList<>();
        try {
            alunos = db.selectAluno();
            for(Aluno aluno : alunos){
                Log.i("ayty", aluno.toString());
            }
        } catch (SQLException e) {
            Log.e("ayty", "Erro ao selecionar todos os alunos");
        }
        //----------------------------------------------------select de professores
        List<Professor> professores = new ArrayList<>();
        try {
            professores = db.selectProfessor();
            for(Professor professor : professores){
                Log.i("ayty", professor.toString());
            }
        } catch (SQLException e) {
            Log.e("ayty", "Erro ao selecionar todos os alunos");
        }
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            disciplinas = db.selectDisciplina();
            for(Disciplina d: disciplinas){
                Log.i("disciplinas", d.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
