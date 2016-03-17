package com.example.berg.projetocarros_berg;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Berg on 15/03/16.
 */
public class CarrosApplication extends Application {

    private List<Carros> carrosList;
    @Override
    public void onCreate() {
        super.onCreate();
        carrosList = new ArrayList<>();
        criarCarrosPadrao();
    }
    private void criarCarrosPadrao(){
        carrosList.add(new Carros("BMW", R.drawable.bmw_720));
        carrosList.add(new Carros("Camaro", R.drawable.camaro));
        carrosList.add(new Carros("Corvette", R.drawable.corvette));
        carrosList.add(new Carros("ct6", R.drawable.ct6));
        carrosList.add(new Carros("Db77", R.drawable.db77));
        carrosList.add(new Carros("Gallardo", R.drawable.gallardo));
        carrosList.add(new Carros("Mustang", R.drawable.mustang));
        carrosList.add(new Carros("Paganni Zonda", R.drawable.paganni_zonda));
        carrosList.add(new Carros("Porsche", R.drawable.porsche_911));
        carrosList.add(new Carros("Vyron", R.drawable.vyron));
    }
    public List<Carros> getCarrosList(){
        return carrosList;
    }
    public void adicionarCarro(){
        Log.i("TAG","adicionarCarro()");
        Random random = new Random();
        carrosList.add(carrosList.get(random.nextInt(carrosList.size() - 1)));

    }
    public void removerCarros(int pos){
        carrosList.remove(pos);
        String item = Integer.toString(pos + 1);
        Toast.makeText(this,"Item Removido: " + item,Toast.LENGTH_SHORT).show();
    }
}
