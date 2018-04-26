package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CriteriosActivity extends AppCompatActivity implements View.OnClickListener{

    ListView lstView;
    CustomListView adbCriterio;
    ImageButton imgBtnAddCriterio;
    ImageButton imgBtnRefresh;
    ImageButton imgBtnNext;
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criterios);

        //Declare Important Views

        txtTotal = (TextView) findViewById(R.id.txtTotal);

        //Set OnClickListeners
        imgBtnAddCriterio = (ImageButton) findViewById(R.id.imgBtnAddCriterio);
        imgBtnRefresh = (ImageButton) findViewById(R.id.imgBtnRefresh);
        imgBtnNext = (ImageButton) findViewById(R.id.imgBtnNext);
        imgBtnAddCriterio.setOnClickListener(this);
        imgBtnRefresh.setOnClickListener(this);
        imgBtnNext.setOnClickListener(this);

        //Añadir los criterios iniciales
        if(Criterio.listaCriterios.size() == 0) {
            Criterio.addCriterio(new Criterio("Duración (en meses)", true, false, 0));
            Criterio.addCriterio(new Criterio("Valor presente neto", true, true, 0));
            Criterio.addCriterio(new Criterio("Periodo de recuperación", true, false, 0));
            Criterio.addCriterio(new Criterio("Riesgo", false, false, 0));
            Criterio.addCriterio(new Criterio("Generación de tecnología", false, true, 0));
        }

        //Toast.makeText(this, "Criterios: " + Integer.toString(Criterio.listaCriterios.size()), Toast.LENGTH_SHORT).show();

        //Create adapter and populate ListView
        lstView = (ListView) findViewById(R.id.listview);
        adbCriterio = new CustomListView(CriteriosActivity.this, 0, Criterio.listaCriterios);
        lstView.setAdapter(adbCriterio);
        //refreshPonderaciones();
        //Toast.makeText(this, "ListView: " + Integer.toString(adbCriterio.getCount()), Toast.LENGTH_SHORT).show();
    }

    //This funciton is called when AddCriterio Button is pressed
    void addCriterio() {
        Intent myIntent = new Intent(CriteriosActivity.this, AddCriterioActivity.class);
        CriteriosActivity.this.startActivity(myIntent);
    }

    //This function is called when Refresh Button is pressed
    void refreshPonderaciones() {
        //Initialize an acumulator for ponderaciones
        int acum = 0;

        for(int i = 0; i < adbCriterio.getCount(); i++) {
            //Get the editText at position i
            EditText et = (EditText) lstView.getChildAt(i).findViewById(R.id.edtTxtPonderacion);

            //Get new ponderacion
            int ponder = Integer.valueOf(et.getText().toString());

            //Update criterios
            Criterio.listaCriterios.get(i).setPonderacion(ponder);
            adbCriterio.getItem(i).setPonderacion(ponder);

            //Get the ponderación and add it to acumulator
            acum += ponder;
        }

        //Set the new ponderación
        String var = String.valueOf(acum) + "%";
        txtTotal.setText(var);
    }
    //This function is called when Next Button is pressed
    void nextScreen() {
        Intent myIntent = new Intent(CriteriosActivity.this, RegistroProyectosActivity.class);
        CriteriosActivity.this.startActivity(myIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnAddCriterio:
                addCriterio();
                break;
            case R.id.imgBtnRefresh:
                refreshPonderaciones();
                break;
            case R.id.imgBtnNext:
                nextScreen();
                break;
        }
    }
}
