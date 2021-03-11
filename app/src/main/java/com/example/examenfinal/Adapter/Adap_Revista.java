package com.example.examenfinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.Modelos.Revista;
import com.example.examenfinal.R;

import java.util.List;

public class Adap_Revista extends RecyclerView.Adapter<Adap_Revista.RevistaViewHolder> {
    private Context ctx;
    private List<Revista> lista_revistas;

    public Adap_Revista(Context mContext, List<Revista> revistas) {
        this.lista_revistas = revistas;
        ctx = mContext;
    }

    @Override
    public RevistaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(ctx);
        view = inflater.inflate(R.layout.item_revista, null);
        return new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {
        Revista revista = lista_revistas.get(position);

        holder.txtTitulo.setText(revista.getName());
        holder.txtDescripcion.setText(revista.getDescription());
    }

    @Override
    public int getItemCount() {
        return lista_revistas.size();
    }

    class RevistaViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo;
        TextView txtDescripcion;

        public RevistaViewHolder(View item_vista) {
            super(item_vista);
            txtTitulo = item_vista.findViewById(R.id.txtTitulo);
            txtDescripcion = item_vista.findViewById(R.id.txtDescripcion);
        }

    }
}
