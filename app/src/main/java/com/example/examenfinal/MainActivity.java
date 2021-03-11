package com.example.examenfinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.Adapter.Adap_Revista;
import com.example.examenfinal.Modelos.Revista;
import com.example.examenfinal.WebService.Asynchtask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
    RecyclerView recyclerView;
    View vista;

    public ArrayList<Revista> revistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        vista = inflater.inflate(R.layout.item_revista, container, false);
        recyclerView = vista.findViewById(R.id.revista_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos_map = new HashMap<String, String>();

        return vista;
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject json_lista = new JSONObject(result);
        JSONArray json_lista_revistas = json_lista.getJSONArray("");

        revistas = Revista.ObjetoJsonBuild(json_lista_revistas);

        Adap_Revista adatador = new Adap_Revista(getApplicationContext(), revistas);

        recyclerView.setAdapter(adatador);
    }
}