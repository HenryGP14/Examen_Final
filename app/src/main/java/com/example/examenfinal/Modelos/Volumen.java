package com.example.examenfinal.Modelos;

import android.content.Context;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONException;
import org.json.JSONObject;

public class Volumen {

    // Acciones para cambiar los valores por la API
    @View(R.id.txt_R_tvolumen)
    TextView txtTitulo;

    @View(R.id.txt_fech_volumen)
    TextView txtFecha;

    @View(R.id.txt_V_doi)
    TextView txtDOI;

    @View(R.id.img_revista)
    ImageView img_revista;

    Context ctx;
    JSONObject obj_volumen_json;

    // Constructor que recibira el context de la aplicación y un JSONObjet
    public Volumen(Context context, JSONObject item_obj_revista) {
        ctx = context;
        obj_volumen_json = item_obj_revista;
    }

    // Lectura de la API y cambiandolo al layout creado
    @Resolve
    protected void onResolved() {
        try {
            // Html.fromHtml() "Sirve para convertir HTML en texto normal"
            this.txtTitulo.setText(Html.fromHtml(obj_volumen_json.getString("title")));
            this.txtFecha.setText(Html.fromHtml(obj_volumen_json.getString("date_published")));
            this.txtDOI.setText(Html.fromHtml(obj_volumen_json.getString("doi")));
            Glide.with(ctx).load(obj_volumen_json.getString("cover"))
                    .into(img_revista);
        } catch (JSONException ex) {
        }
    }
}
