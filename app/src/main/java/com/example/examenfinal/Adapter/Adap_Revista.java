package com.example.examenfinal.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.Modelos.Revista;

import java.util.List;

public class Adap_Revista extends {
    private Context ctx;
    private List<Revista> lista_revistas;

    public  Adap_Revista(Context mContext, List<Revista> revistas){
        this.lista_revistas = revistas;
        ctx = mContext;
    }


}
