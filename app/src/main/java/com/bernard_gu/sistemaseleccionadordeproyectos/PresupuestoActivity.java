package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PresupuestoActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtTxtPresupuesto;
    TextView txtResultado;

    ListView lstView;
    ImageButton imgBtnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto);

        //Vincular views pertinentes
        edtTxtPresupuesto = (EditText) findViewById(R.id.edtTxtPResupuesto);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        lstView = (ListView) findViewById(R.id.lstViewProyectos);
        imgBtnRefresh = (ImageButton) findViewById(R.id.imgBtnRefresh);

        //Set onClickListener
        imgBtnRefresh.setOnClickListener(this);

        if(Proyecto.listaProyectos.size() > 0) fillListView();
    }

    //This method fills the list view with the proyect names and costs
    void fillListView() {
        ArrayList<String> lista = new ArrayList<String>();

        for(int i = 0; i < Proyecto.listaProyectos.size(); i++) {
            lista.add(Integer.toString(i+1)+" > Proyecto " + Proyecto.listaProyectos.get(i).getIdentificador()
                    + " | $" + Integer.toString(Proyecto.listaProyectos.get(i).getCosto()));
        }

        //Set listView adapter
        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
    }


    void refresh() {
        //Get presupuesto
        int pres = Integer.valueOf(edtTxtPresupuesto.getText().toString());
        String str = "";
        pres -= Proyecto.listaProyectos.get(0).getCosto();
        //Calculate
        for(int i = 0; i < Proyecto.listaProyectos.size() && pres > 0; i++) {
            str += Proyecto.listaProyectos.get(i).getIdentificador() + ", ";
            if(i+1 < Proyecto.listaProyectos.size())
               pres -= Proyecto.listaProyectos.get(i+1).getCosto();
        }
        txtResultado.setText(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnRefresh:
                refresh();
                break;
        }
    }
}
