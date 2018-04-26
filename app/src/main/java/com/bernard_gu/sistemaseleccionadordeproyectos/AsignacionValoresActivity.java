package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AsignacionValoresActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lstView;
    ValoresListView adbValores;
    ImageButton imgBtnNext;
    TextView[] txt = new TextView[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_valores);

        //Declare Important Views
        txt[0] = (TextView) findViewById(R.id.txt1);
        txt[1] = (TextView) findViewById(R.id.txt2);
        txt[2] = (TextView) findViewById(R.id.txt3);
        txt[3] = (TextView) findViewById(R.id.txt4);
        txt[4] = (TextView) findViewById(R.id.txt5);
        txt[5] = (TextView) findViewById(R.id.txt6);
        txt[6] = (TextView) findViewById(R.id.txt7);
        txt[7] = (TextView) findViewById(R.id.txt8);

        //Set OnClickListeners
        imgBtnNext = (ImageButton) findViewById(R.id.imgBtnNext);
        imgBtnNext.setOnClickListener(this);


        //Toast.makeText(this, "Proyectos: " + Integer.toString(Proyecto.listaProyectos.size()), Toast.LENGTH_SHORT).show();

        //Create adapter and populate ListView
        lstView = (ListView) findViewById(R.id.listview);
        adbValores = new ValoresListView(AsignacionValoresActivity.this, 0, new ArrayList<Criterio>(Criterio.listaCriterios));
        lstView.setAdapter(adbValores);
        //refreshPonderaciones();
        //Toast.makeText(this, "ListView: " + Integer.toString(adbValores.getCount()), Toast.LENGTH_SHORT).show();

        //Set titles
        for(int i = 0; i < 8; i++) {
            if(i < Proyecto.listaProyectos.size()) {
                txt[i].setVisibility(View.VISIBLE);
                txt[i].setText(Proyecto.listaProyectos.get(i).getIdentificador());
            } else {
                txt[i].setVisibility(View.GONE);
            }
        }
    }

    void getValuesFromList() {
        for(int i = 0; i < adbValores.getCount(); i++) {
            //Get relevant Views
            EditText[] edtTxt = new EditText[8];
            Spinner[] spn = new Spinner[8];
            View vi = lstView.getChildAt(i);

            edtTxt[0] = (EditText) vi.findViewById(R.id.edtTxt1);
            edtTxt[1] = (EditText) vi.findViewById(R.id.edtTxt2);
            edtTxt[2] = (EditText) vi.findViewById(R.id.edtTxt3);
            edtTxt[3] = (EditText) vi.findViewById(R.id.edtTxt4);
            edtTxt[4] = (EditText) vi.findViewById(R.id.edtTxt5);
            edtTxt[5] = (EditText) vi.findViewById(R.id.edtTxt6);
            edtTxt[6] = (EditText) vi.findViewById(R.id.edtTxt7);
            edtTxt[7] = (EditText) vi.findViewById(R.id.edtTxt8);
            spn[0] = (Spinner) vi.findViewById(R.id.spn1);
            spn[1] = (Spinner) vi.findViewById(R.id.spn2);
            spn[2] = (Spinner) vi.findViewById(R.id.spn3);
            spn[3] = (Spinner) vi.findViewById(R.id.spn4);
            spn[4] = (Spinner) vi.findViewById(R.id.spn5);
            spn[5] = (Spinner) vi.findViewById(R.id.spn6);
            spn[6] = (Spinner) vi.findViewById(R.id.spn7);
            spn[7] = (Spinner) vi.findViewById(R.id.spn8);
            for(int j = 0; j < Proyecto.listaProyectos.size(); j++) {
                if(Proyecto.listaProyectos.get(j).criterios.get(i).getCuantitativo()) {
                    Proyecto.listaProyectos.get(j).criterios.get(i).setValor(Integer.valueOf(edtTxt[j].getText().toString()));
                    //Toast.makeText(this, "Cuanti", Toast.LENGTH_SHORT).show();
                } else {
                    switch(spn[j].getSelectedItem().toString()) {
                        case "Muy Alto":
                            Proyecto.listaProyectos.get(j).criterios.get(i).setValor(4);
                            break;
                        case "Alto:":
                            Proyecto.listaProyectos.get(j).criterios.get(i).setValor(3);
                            break;
                        case "Moderado":
                            Proyecto.listaProyectos.get(j).criterios.get(i).setValor(2);
                            break;
                        case "Bajo":
                            Proyecto.listaProyectos.get(j).criterios.get(i).setValor(1);
                            break;
                        case "Muy bajo":
                            Proyecto.listaProyectos.get(j).criterios.get(i).setValor(0);
                            break;
                    }
                    //Toast.makeText(activity, Integer.toString(v), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this, "No Cuanti", Toast.LENGTH_SHORT).show();
                }
                int x = Proyecto.listaProyectos.get(j).criterios.get(i).getValor();
                Toast.makeText(this, Integer.toString(x), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This function is called when Next Button is pressed
    void nextScreen() {
        Intent myIntent = new Intent(AsignacionValoresActivity.this, MatrizDecisionActivity.class);
        AsignacionValoresActivity.this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnNext:
                getValuesFromList();
                nextScreen();
                break;
        }
    }
}
