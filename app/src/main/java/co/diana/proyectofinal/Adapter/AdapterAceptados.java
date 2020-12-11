package co.diana.proyectofinal.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.R;

public class AdapterAceptados extends BaseAdapter {


    private ArrayList<Solicitud> solicitud;

    public AdapterAceptados() {

        solicitud = new ArrayList<>();

    }

    public void addEmployee(Solicitud soli) {

        solicitud.add(soli);
        notifyDataSetChanged();

    }

    public void clear() {
        solicitud.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return solicitud.size();
    }

    @Override
    public Object getItem(int i) {
        return solicitud.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup list) {

        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.rowsolicitud,null);

        Solicitud sol = solicitud.get(i);

        TextView name = rowView.findViewById(R.id.nameEmployee3);
        TextView servicio = rowView.findViewById(R.id.tipo);
        Button llamar = rowView.findViewById(R.id.llamar);

        name.setText(sol.getNombreTrabajador());
        servicio.setText(sol.getTipoServicio());

        ActivityCompat.requestPermissions((Activity) list.getContext(), new  String[]{

                Manifest.permission.CALL_PHONE
        },1);

        llamar.setOnClickListener(


                (v)->{

                   String tel = "tel:"+sol.getTelefono();
                    Intent o = new Intent(Intent.ACTION_CALL);
                    o.setData(Uri.parse(tel));

                    list.getContext().startActivity(o);


                }
        );


        return rowView;
    }
}
