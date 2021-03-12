package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examenfinal.Modelos.Descarga;
import com.example.examenfinal.Modelos.Volumen;
import com.example.examenfinal.WebService.Asynchtask;
import com.example.examenfinal.WebService.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DescargaActivity extends AppCompatActivity implements Asynchtask {


    String URL = "https://revistas.uteq.edu.ec/ws/pubs.php?i_id=";
    PlaceHolderView placeHolderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descarga);

        Bundle recibir_datos = this.getIntent().getExtras();
        Map<String, String> datos_map = new HashMap<String, String>();
        WebService web = new WebService(URL + recibir_datos.getString("issue_id"), datos_map, DescargaActivity.this, DescargaActivity.this);
        web.execute("GET");

        // Instanciar el placeHolder con el componente del layout activity_volumen.xml
        placeHolderView = findViewById(R.id.place_d_volumen);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        // Obtencción de datos del web service
        JSONArray json_array = new JSONArray(result);
        for (int i = 0; i < json_array.length(); i++){
            JSONObject json_obj_descarga = json_array.getJSONObject(i);
            // Añado el context de la aplicacion y el objeto json para enviarselo al modelo Descarga
            placeHolderView.addView(new Descarga(getApplicationContext(), json_obj_descarga));
        }
    }
}