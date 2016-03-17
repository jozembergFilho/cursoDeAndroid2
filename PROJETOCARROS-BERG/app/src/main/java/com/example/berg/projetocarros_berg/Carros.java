package com.example.berg.projetocarros_berg;

/**
 * Created by Berg on 15/03/16.
 */
public class Carros {

    private String nomeCarro;
    private int idImageCarro;

    public Carros(String nomeCarro, int idImageCarro) {
        this.nomeCarro = nomeCarro;
        this.idImageCarro = idImageCarro;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public int getIdImageCarro() {
        return idImageCarro;
    }

    public void setIdImageCarro(int idImageCarro) {
        this.idImageCarro = idImageCarro;
    }
}
