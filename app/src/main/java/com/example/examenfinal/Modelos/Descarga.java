package com.example.examenfinal.Modelos;


import android.content.Context;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NonReusable
@Layout(R.layout.item_descarga)
public class Descarga {

    // Acciones para cambiar los valores por la API
    @View(R.id.txtEdicion)
    TextView txtTitulo;

    @View(R.id.txtAutores)
    TextView txtAutores;

    Context ctx;
    JSONObject obj_volumen_json;

    public Descarga(Context context, JSONObject item_obj_revista) {
        ctx = context;
        obj_volumen_json = item_obj_revista;
    }

    // Lectura de la API y cambiandolo al layout creado
    @Resolve
    protected void onResolved() {
        try {
            // Html.fromHtml() "Sirve para convertir HTML en texto normal"
            this.txtTitulo.setText(Html.fromHtml(obj_volumen_json.getString("title")));
            JSONArray array_authors = obj_volumen_json.getJSONArray("authors");
            for (int i = 0; i < array_authors.length(); i++){
                JSONObject object_author = array_authors.getJSONObject(i);
//                txtAutores.
            }
        } catch (JSONException ex) {
        }
    }

}
