package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examenfinal.WebService.Asynchtask;
import com.example.examenfinal.WebService.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class VolumenesActivity extends AppCompatActivity implements Asynchtask {

    String URL = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=";
    PlaceHolderView placeHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        Bundle recibir_datos = this.getIntent().getExtras();
        Map<String, String> datos_map = new HashMap<String, String>();
        WebService web = new WebService(URL + recibir_datos.getString("journal_id"), datos_map, VolumenesActivity.this, VolumenesActivity.this);
        web.execute("GET");

        // Instanciar el placeHolder con el componente del layout activity_main.xml
        placeHolderView = findViewById(R.id.place_revista);

    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}