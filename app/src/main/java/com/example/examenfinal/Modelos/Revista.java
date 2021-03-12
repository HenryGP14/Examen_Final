package com.example.examenfinal.Modelos;

import android.content.Context;
import android.widget.TextView;

import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@NonReusable
@Layout(R.layout.item_revista)

public class Revista {
    // Acciones para cambiar los valores por la API
    @View(R.id.txtTitulo)
    TextView txtTitulo;

    @View(R.id.txtDescripcion)
    TextView txtDescripcion;

    Context ctx;
    JSONObject obj_revista_json;

    // Constructor que recibira el context de la aplicación y un JSONObjet
    public Revista(Context context, JSONObject item_obj_revista){
        ctx = context;
        obj_revista_json = item_obj_revista;
    }

    // Lectura de la API y cambiandolo al layout creado
    @Resolve
    protected void onResolved(){
        try{
            this.txtTitulo.setText(obj_revista_json.getString("name"));
            this.txtDescripcion.setText(obj_revista_json.getString("description"));
        }catch (JSONException ex){}

    }
}

