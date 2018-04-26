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

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by berna on 25/04/2018.
 */

public class PesosListView  extends ArrayAdapter<Criterio> {

    private Activity activity;
    private ArrayList<Criterio> criterios;
    private static LayoutInflater inflater = null;

    private static double[] totales = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

    public PesosListView(Activity activity, int textViewResourceId, ArrayList<Criterio> _criterios) {
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
        public TextView txtPonderacion;
        public TextView[] txt = new TextView[8];
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final PesosListView.ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview_layout_pesos, null);
                holder = new ViewHolder();

                holder.txtCriterio = (TextView) vi.findViewById(R.id.txtCriterio);
                holder.txtPonderacion = (TextView) vi.findViewById(R.id.txtPonderacion);
                holder.txt[0] = (TextView) vi.findViewById(R.id.txt1);
                holder.txt[1] = (TextView) vi.findViewById(R.id.txt2);
                holder.txt[2] = (TextView) vi.findViewById(R.id.txt3);
                holder.txt[3] = (TextView) vi.findViewById(R.id.txt4);
                holder.txt[4] = (TextView) vi.findViewById(R.id.txt5);
                holder.txt[5] = (TextView) vi.findViewById(R.id.txt6);
                holder.txt[6] = (TextView) vi.findViewById(R.id.txt7);
                holder.txt[7] = (TextView) vi.findViewById(R.id.txt8);

                vi.setTag(holder);
            } else {
                holder = (PesosListView.ViewHolder) vi.getTag();
            }

            String s = String.valueOf(Criterio.listaCriterios.get(position).getPonderacion())+"%";
            holder.txtPonderacion.setText(s);

            //Rellenar la fila del ListView
            holder.txtCriterio.setText((CharSequence) criterios.get(position).getNombre());
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < 8; i++) {
                if(i < Proyecto.listaProyectos.size()) {
                    holder.txt[i].setVisibility(VISIBLE);
                    list.add(Proyecto.listaProyectos.get(i).getCriterios().get(position).getValor());

                } else {
                    holder.txt[i].setVisibility(GONE);
                }
            }
            int max = findMax(list);
            int min = findMin(list);
            for(int i = 0; i < Proyecto.listaProyectos.size(); i++) {
                int v = list.get(i);//(int) Math.round((list.get(i)-min)*7.0/(max-min));
                //if(!Criterio.listaCriterios.get(position).getMayorEsMejor())
                    //v = 7-v;

                String temp = Integer.toString(v);
                holder.txt[i].setText(temp);
                totales[i] += v*Criterio.listaCriterios.get(position).getPonderacion()/100.0;
            }

        } catch (Exception e) {

            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return vi;
    }

    private static int findMax(ArrayList<Integer> arr) {
        int max = 0;
        for(int i = 0; i < arr.size(); i++)
            if(arr.get(i) > max)
                max = arr.get(i);

        return max;
    }

    private static int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.size(); i++)
            if(arr.get(i) < min)
                min = arr.get(i);

        return min;
    }

    public static double getTotales(int position) {
        return totales[position];
    }
}
