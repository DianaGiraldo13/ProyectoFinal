package co.diana.proyectofinal.Adapter;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.diana.proyectofinal.Clases.DonacionAceptada;
import co.diana.proyectofinal.Donacion;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.Ropa;

public class AdapterRecogida extends BaseAdapter {

    private ArrayList<Ropa> dona;

    public AdapterRecogida() {

        dona = new ArrayList<>();

    }

    public void addDonacion(Ropa donacion) {

        dona.add(donacion);
        notifyDataSetChanged();

    }

    public void clear() {
        dona.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dona.size();
    }

    @Override
    public Object getItem(int i) {
        return dona.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup list) {

        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.rowrecoletar,null);

        Ropa donar = dona.get(i);

        TextView tipo = rowView.findViewById(R.id.tipo2);
        TextView cantidad2 = rowView.findViewById(R.id.cantidad2);
        TextView estado = rowView.findViewById(R.id.estado);
        TextView hora = rowView.findViewById(R.id.hora);
        TextView fecha = rowView.findViewById(R.id.fecha);

        cantidad2.setText("Cantidad: "+donar.getInforopa()+"");
        estado.setText("Estado: "+donar.getEstado());
        hora.setText("Fecha: "+donar.getFechaderecogida());
        fecha.setText("Hora: "+donar.getHoraderecogida());
        tipo.setText("Ropa");

        return rowView;
    }
}
