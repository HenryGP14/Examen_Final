package com.example.examenfinal.Modelos;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Click;
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

    @View(R.id.img_revista)
    ImageView img_revista;

    @Click(R.id.btnVerRevista)
    public void onRevistaViewClick() {
        try {
            System.out.println(obj_revista_json.getString("journal_id"));
            Bundle cambio_app = new Bundle();
        } catch (JSONException ex) {
        }
    }

    Context ctx;
    JSONObject obj_revista_json;

    // Constructor que recibira el context de la aplicación y un JSONObjet
    public Revista(Context context, JSONObject item_obj_revista) {
        ctx = context;
        obj_revista_json = item_obj_revista;
    }

    // Lectura de la API y cambiandolo al layout creado
    @Resolve
    protected void onResolved() {
        try {
            // Html.fromHtml() "Sirve para convertir HTML en texto normal"
            this.txtTitulo.setText(Html.fromHtml(obj_revista_json.getString("name")));
            this.txtDescripcion.setText(Html.fromHtml(obj_revista_json.getString("description")));
            Glide.with(ctx).load(obj_revista_json.getString("portada"))
                    .into(img_revista);
        } catch (JSONException ex) {
        }

    }
}

