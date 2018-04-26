package com.bernard_gu.sistemaseleccionadordeproyectos;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This is the adapter for the CustomListView
 * These code was based on the answer of Talha in https://stackoverflow.com/questions/15297840/populate-listview-from-arraylist-of-objects
 */

public class CustomListView extends ArrayAdapter<Criterio>{

    private Activity activity;
    private ArrayList<Criterio> criterios;
    private static LayoutInflater inflater = null;

    public CustomListView(Activity activity, int textViewResourceId, ArrayList<Criterio> _criterios) {
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
        public TextView txtViewCriterio;
        public TextView txtViewTipo;
        public EditText edtTxtPonderacion;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview_layout, null);
                holder = new ViewHolder();

                holder.txtViewCriterio = (TextView) vi.findViewById(R.id.txtViewCriterio);
                holder.txtViewTipo = (TextView) vi.findViewById(R.id.txtViewTipo);
                //holder.edtTxtPonderacion = (EditText) vi.findViewById(R.id.edtTxtPonderacion);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.txtViewCriterio.setText(criterios.get(position).getNombre());
            if(criterios.get(position).getCuantitativo())
                holder.txtViewTipo.setText("Cuantitativo");
            else
                holder.txtViewTipo.setText("Cualitativo");
            holder.edtTxtPonderacion.setText(Integer.toString(criterios.get(position).getPonderacion()));


        } catch (Exception e) {


        }
        return vi;
    }
}
