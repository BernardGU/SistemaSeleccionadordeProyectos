package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        adbValores = new ValoresListView(AsignacionValoresActivity.this, 0, Criterio.listaCriterios);
        lstView.setAdapter(adbValores);
        //refreshPonderaciones();
        //Toast.makeText(this, "ListView: " + Integer.toString(adbValores.getCount()), Toast.LENGTH_SHORT).show();

        //Set titles
        for(int i = 0; i < 8; i++) {
            if(i < Proyecto.listaProyectos.size()) {
                txt[i].setVisibility(View.VISIBLE);
                txt[i].setText(Proyecto.listaProyectos.get(i).getIdentificador().toString());
            } else {
                txt[i].setVisibility(View.GONE);
            }
        }
    }

    void getValuesFromList() {

    }

    //This function is called when Next Button is pressed
    void nextScreen() {
        Intent myIntent = new Intent(AsignacionValoresActivity.this, CriteriosActivity.class);
        AsignacionValoresActivity.this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnNext:
                break;
        }
    }
}
