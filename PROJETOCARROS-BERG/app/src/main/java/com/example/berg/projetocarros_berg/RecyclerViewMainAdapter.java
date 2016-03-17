package com.example.berg.projetocarros_berg;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Berg on 16/03/16.
 */
public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.RecyclerViewHolder> {

    private CarrosApplication carrosApplication;
    private Context contex;
    private List<Carros> carros;

    public RecyclerViewMainAdapter(Context contex, List<Carros> list ) {
        this.contex = contex;
        this.carros = list;
        carrosApplication = (CarrosApplication)contex.getApplicationContext();
        carros = carrosApplication.getCarrosList();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//inflar Layout
        Log.i("LOG","onCreateViewHolder() ");
        View view = LayoutInflater.from(contex).inflate(R.layout.content_list_main, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {//set imagem e text
        Log.i("LOG","onBindViewHolder() ");
        holder.imageView.setImageResource(carros.get(position).getIdImageCarro());
        holder.textView.setText((CharSequence) carros.get(position).getNomeCarro());
        //Carros carros1 = carros.get(position);
        //holder.textView.setText(carros1.getNomeCarro());
        //holder.imageView.setImageResource(carros1.getIdImageCarro());
    }

    @Override
    public int getItemCount() {//Tamanho da Lista
        return carros.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private View view;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.texto);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            view = itemView.findViewById(R.id.content_list_main);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carrosApplication.removerCarros(getPosition());
                    notifyDataSetChanged();


                }
            });


        }


    }
}
