package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class AddCriterioActivity extends AppCompatActivity {

    EditText edtTxtCriterioNombre;
    RadioButton rdBtnCuanti;
    RadioButton rdBtnCuali;
    Spinner spnMejor;
    Button btnAddCriterio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_criterio);

        //Attach relevant views
        edtTxtCriterioNombre = (EditText) findViewById(R.id.edtTxtCriterioNombre);
        rdBtnCuanti = (RadioButton) findViewById(R.id.rdBtnCuanti);
        rdBtnCuali = (RadioButton) findViewById(R.id.rdBtnCuali);
        spnMejor = (Spinner) findViewById(R.id.spnMejor);
        btnAddCriterio = (Button) findViewById(R.id.btnAddCriterio);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.mejor_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
            spnMejor.setAdapter(adapter);

        //Set Button onClickListener
        btnAddCriterio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Agrega el nuevo criterio
                Criterio.addCriterio( new Criterio( edtTxtCriterioNombre.getText().toString(), rdBtnCuanti.isChecked(),
                                spnMejor.getSelectedItem().toString().equalsIgnoreCase("Mayor"), 0));
                //Regresa a la pantalla anterior
                Intent myIntent = new Intent(AddCriterioActivity.this, CriteriosActivity.class);
                AddCriterioActivity.this.startActivity(myIntent);
            }
        });
    }
}
