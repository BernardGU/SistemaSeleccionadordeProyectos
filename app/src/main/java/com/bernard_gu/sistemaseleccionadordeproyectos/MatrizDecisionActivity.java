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

import java.util.ArrayList;

public class MatrizDecisionActivity extends AppCompatActivity implements View.OnClickListener{

    ListView lstView;
    PesosListView adbPesos;
    ImageButton imgBtnNext;
    TextView[] txt = new TextView[8];
    TextView[] txt_2 = new TextView[8];
    TextView[] txt_3 = new TextView[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz_decision);

        //Declare Important Views
        txt[0] = (TextView) findViewById(R.id.txt1);
        txt[1] = (TextView) findViewById(R.id.txt2);
        txt[2] = (TextView) findViewById(R.id.txt3);
        txt[3] = (TextView) findViewById(R.id.txt4);
        txt[4] = (TextView) findViewById(R.id.txt5);
        txt[5] = (TextView) findViewById(R.id.txt6);
        txt[6] = (TextView) findViewById(R.id.txt7);
        txt[7] = (TextView) findViewById(R.id.txt8);
        //Declare Important Views
        txt_2[0] = (TextView) findViewById(R.id.txt1_2);
        txt_2[1] = (TextView) findViewById(R.id.txt2_2);
        txt_2[2] = (TextView) findViewById(R.id.txt3_2);
        txt_2[3] = (TextView) findViewById(R.id.txt4_2);
        txt_2[4] = (TextView) findViewById(R.id.txt5_2);
        txt_2[5] = (TextView) findViewById(R.id.txt6_2);
        txt_2[6] = (TextView) findViewById(R.id.txt7_2);
        txt_2[7] = (TextView) findViewById(R.id.txt8_2);
        //Declare Important Views
        txt_3[0] = (TextView) findViewById(R.id.txt1_3);
        txt_3[1] = (TextView) findViewById(R.id.txt2_3);
        txt_3[2] = (TextView) findViewById(R.id.txt3_3);
        txt_3[3] = (TextView) findViewById(R.id.txt4_3);
        txt_3[4] = (TextView) findViewById(R.id.txt5_3);
        txt_3[5] = (TextView) findViewById(R.id.txt6_3);
        txt_3[6] = (TextView) findViewById(R.id.txt7_3);
        txt_3[7] = (TextView) findViewById(R.id.txt8_3);

        //Set OnClickListeners
        imgBtnNext = (ImageButton) findViewById(R.id.imgBtnNext);
        imgBtnNext.setOnClickListener(this);


        //Toast.makeText(this, "Proyectos: " + Integer.toString(Proyecto.listaProyectos.size()), Toast.LENGTH_SHORT).show();

        //Create adapter and populate ListView
        lstView = (ListView) findViewById(R.id.listview);
        adbPesos = new PesosListView(MatrizDecisionActivity.this, 0,new ArrayList<Criterio>(Criterio.listaCriterios));
        lstView.setAdapter(adbPesos);
        //refreshPonderaciones();
        //Toast.makeText(this, "ListView: " + Integer.toString(adbPesos.getCount()), Toast.LENGTH_SHORT).show();

        //Set titles
        for(int i = 0; i < 8; i++) {
            if(i < Proyecto.listaProyectos.size()) {
                txt[i].setVisibility(View.VISIBLE);
                txt[i].setText(Proyecto.listaProyectos.get(i).getIdentificador());
            } else {
                txt[i].setVisibility(View.GONE);
            }
        }
        //Set totales
        for(int i = 0; i < 8; i++) {
            if(i < Proyecto.listaProyectos.size()) {
                txt_2[i].setVisibility(View.VISIBLE);
                txt_2[i].setText(Double.toString( adbPesos.getTotales(i)));
            } else {
                txt_2[i].setVisibility(View.GONE);
            }
        }

        //Set prioridades
        for(int i = 0; i < 8; i++) {
            if(i < Proyecto.listaProyectos.size()) {
                txt_3[i].setVisibility(View.VISIBLE);
                txt_3[i].setText(Integer.toString(i+1));
            } else {
                txt_3[i].setVisibility(View.GONE);
            }
        }
    }

    //This function is called when Next Button is pressed
    void nextScreen() {
        Intent myIntent = new Intent(MatrizDecisionActivity.this, PresupuestoActivity.class);
        MatrizDecisionActivity.this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnNext:
                nextScreen();
                break;
        }
    }
}
