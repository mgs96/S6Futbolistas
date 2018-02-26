package com.uninorte.s6futbolistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Visitante on 26/02/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Jugador> data;

    public CustomAdapter(Context context, ArrayList<Jugador> values) {
        this.context = context;
        this.data = values;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jugador j = data.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, null);
        }

        TextView tvNombre = convertView.findViewById(R.id.nombre);
        TextView tvApellido = convertView.findViewById(R.id.apellido);
        TextView tvPosicion = convertView.findViewById(R.id.posicion);
        TextView tvOnof = convertView.findViewById(R.id.onof);

        Button editar = convertView.findViewById(R.id.editar);
        editar.setFocusable(false);
        editar.setFocusableInTouchMode(false);
        editar.setTag(position);

        tvNombre.setText(j.getNombre());
        tvApellido.setText(j.getApellido());
        tvPosicion.setText(j.getPosicion());
        if(j.isComvocado()) {
            tvOnof.setText("ON");
        } else {
            tvOnof.setText("OFF");
        }

        return convertView;
    }

    public void setData(ArrayList<Jugador> jugadores) {
        this.data = jugadores;
    }
}
