package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RegistroProyectosActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtTxtId;
    EditText edtTxtDescripcion;
    EditText edtTxtCosto;

    ListView lstView;
    Button btnAddProyecto;
    ImageButton imgBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_proyectos);

        //Vincular views pertinentes
        edtTxtId = (EditText) findViewById(R.id.edtTxtId);
        edtTxtDescripcion = (EditText) findViewById(R.id.edtTxtDescripcion);
        edtTxtCosto = (EditText) findViewById(R.id.edtTxtCosto);
        lstView = (ListView) findViewById(R.id.lstViewProyectos);
        btnAddProyecto = (Button) findViewById(R.id.btnAddProyecto);
        imgBtnNext = (ImageButton) findViewById(R.id.imgBtnNext);

        //Set onClickListener
        btnAddProyecto.setOnClickListener(this);
        imgBtnNext.setOnClickListener(this);

        if(Proyecto.listaProyectos.size() > 0) fillListView();
    }

    //This method fills the list view with the proyect names and costs
    void fillListView() {
        ArrayList<String> lista = new ArrayList<String>();

        for(int i = 0; i < Proyecto.listaProyectos.size(); i++) {
            lista.add("Proyecto " + Proyecto.listaProyectos.get(i).getIdentificador()
                    + " | $" + Integer.toString(Proyecto.listaProyectos.get(i).getCosto()));
        }

        //Set listView adapter
        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
    }

    void addProyecto() {
        //Get information of the proyect
        String id = edtTxtId.getText().toString();
        String desc = edtTxtDescripcion.getText().toString();
        int costo = Integer.parseInt(edtTxtCosto.getText().toString());
        //Save the new proyect information
        Proyecto.listaProyectos.add(new Proyecto(id, desc, costo, Criterio.listaCriterios));
    }

    //This method is called when Next Button is pressed
    void nextScreen() {
        Intent myIntent = new Intent(RegistroProyectosActivity.this, AsignacionValoresActivity.class);
        RegistroProyectosActivity.this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddProyecto:
                addProyecto();
                fillListView();
                break;
            case R.id.imgBtnNext:
                nextScreen();
                break;
        }
    }
}
