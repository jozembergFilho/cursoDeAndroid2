package com.example.rapha.aula10.util;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Berg on 23/03/16.
 */
@DatabaseTable
public class Disciplina {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private int quantidadeDeCreditos;
    @ForeignCollectionField
    Collection<Professor> professores = new ArrayList<>();

    public Disciplina(){

    }

    public Disciplina(String nome, int quantidadeDeCreditos) {
        this.nome = nome;
        this.quantidadeDeCreditos = quantidadeDeCreditos;

    }
    public void addProfessor(Professor professor){
        this.professores.add(professor);
    }
    public void removerProfessor(Professor professor){
        this.professores.remove(professor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeCreditos() {
        return quantidadeDeCreditos;
    }

    public void setQuantidadeDeCreditos(int quantidadeDeCreditos) {
        this.quantidadeDeCreditos = quantidadeDeCreditos;
    }
    public String toString(){
        return "id: "+this.id+"\nnome: "+this.nome+"\nQuantidade de créditos: "+this.quantidadeDeCreditos;
    }

}
