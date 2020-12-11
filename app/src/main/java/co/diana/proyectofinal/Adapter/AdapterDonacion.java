package co.diana.proyectofinal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.diana.proyectofinal.Clases.DonacionAceptada;

import co.diana.proyectofinal.R;

public class AdapterDonacion extends BaseAdapter {

    private ArrayList<DonacionAceptada> donacion;

    public AdapterDonacion() {

        donacion = new ArrayList<>();

    }

    public void addDonacion(DonacionAceptada dona) {

        donacion.add(dona);
        notifyDataSetChanged();

    }

    public void clear() {
        donacion.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return donacion.size();
    }

    @Override
    public Object getItem(int i) {
        return  donacion.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup list) {

        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.rowsdonacion,null);

        DonacionAceptada donaci = donacion.get(i);

        TextView cantidad = rowView.findViewById(R.id.cantidad);

        cantidad.setText("Cantidad: "+donaci.getCantidad());



        return rowView;
    }
}
