package com.example.examenfinal.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    String journal_id;
    String  name;
    String portada;
    String description;

    public Revista(JSONObject obj_revista) throws JSONException {
        journal_id = obj_revista.getString("journal_id");
        name = obj_revista.getString("name");
        portada = obj_revista.getString("portada");
        description = obj_revista.getString("description");
    }

    public  static ArrayList<Revista> ObjetoJsonBuild(JSONArray array_datos) throws JSONException{
        ArrayList<Revista> revistas = new ArrayList<>();
        for(int i = 0; i < array_datos.length(); i++){
            revistas.add(new Revista(array_datos.getJSONObject(i)));
        }
        return revistas;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
