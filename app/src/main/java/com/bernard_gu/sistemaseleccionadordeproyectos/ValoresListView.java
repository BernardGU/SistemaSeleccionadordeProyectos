package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by berna on 25/04/2018.
 */

public class ValoresListView  extends ArrayAdapter<Criterio>{

    private Activity activity;
    private ArrayList<Criterio> criterios;
    private static LayoutInflater inflater = null;

    public ValoresListView(Activity activity, int textViewResourceId, ArrayList<Criterio> _criterios) {
        super(activity, textViewResourceId, _criterios);
        try {
            this.activity = activity;
            this.criterios = _criterios;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {

        }
    }

    public int getCount() {
        return criterios.size();
    }

    public Criterio getItem(Criterio position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView txtCriterio;
        public EditText[] edtTxt = new EditText[8];
        public Spinner[] spn = new Spinner[8];
        public LinearLayout linlayCuali;
        public LinearLayout linlayCuanti;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview_layout_valores, null);
                holder = new ViewHolder();

                holder.txtCriterio = (TextView) vi.findViewById(R.id.txtCriterio);
                holder.edtTxt[0] = (EditText) vi.findViewById(R.id.edtTxt1);
                holder.edtTxt[1] = (EditText) vi.findViewById(R.id.edtTxt2);
                holder.edtTxt[2] = (EditText) vi.findViewById(R.id.edtTxt3);
                holder.edtTxt[3] = (EditText) vi.findViewById(R.id.edtTxt4);
                holder.edtTxt[4] = (EditText) vi.findViewById(R.id.edtTxt5);
                holder.edtTxt[5] = (EditText) vi.findViewById(R.id.edtTxt6);
                holder.edtTxt[6] = (EditText) vi.findViewById(R.id.edtTxt7);
                holder.edtTxt[7] = (EditText) vi.findViewById(R.id.edtTxt8);
                holder.spn[0] = (Spinner) vi.findViewById(R.id.spn1);
                holder.spn[1] = (Spinner) vi.findViewById(R.id.spn2);
                holder.spn[2] = (Spinner) vi.findViewById(R.id.spn3);
                holder.spn[3] = (Spinner) vi.findViewById(R.id.spn4);
                holder.spn[4] = (Spinner) vi.findViewById(R.id.spn5);
                holder.spn[5] = (Spinner) vi.findViewById(R.id.spn6);
                holder.spn[6] = (Spinner) vi.findViewById(R.id.spn7);
                holder.spn[7] = (Spinner) vi.findViewById(R.id.spn8);
                holder.linlayCuali = (LinearLayout) vi.findViewById(R.id.layoutCuali);
                holder.linlayCuanti = (LinearLayout) vi.findViewById(R.id.layoutCuanti);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            //Rellenar la fila del ListView
            holder.txtCriterio.setText((CharSequence) criterios.get(position).getNombre());
            if(criterios.get(position).getCuantitativo()) {
                Toast.makeText(activity, Integer.toString(position)+" es cuanti", Toast.LENGTH_SHORT).show();
                holder.linlayCuali.setVisibility(GONE);
                holder.linlayCuanti.setVisibility(VISIBLE);
                for(int i = 0; i < 8; i++) {
                    if(i < Proyecto.listaProyectos.size()) {
                        holder.edtTxt[i].setVisibility(VISIBLE);
                    } else {
                        holder.edtTxt[i].setVisibility(GONE);
                    }

                }
            } else {
                Toast.makeText(activity, Integer.toString(position)+" es cuali", Toast.LENGTH_SHORT).show();
                holder.linlayCuali.setVisibility(VISIBLE);
                holder.linlayCuanti.setVisibility(GONE);
                for(int i = 0; i < 8; i++) {
                    if(i < Proyecto.listaProyectos.size()) {
                        holder.spn[i].setVisibility(VISIBLE);

                        // Create an ArrayAdapter using the string array and a default spinner layout
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                                R.array.cualitativos_array, android.R.layout.simple_spinner_item);
                        // Specify the layout to use when the list of choices appears
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        // Apply the adapter to the spinner
                        holder.spn[i].setAdapter(adapter);
                    } else {
                        holder.spn[i].setVisibility(GONE);
                    }

                }
            }


        } catch (Exception e) {

            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return vi;
    }
}
