package co.diana.proyectofinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import co.diana.proyectofinal.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.diana.proyectofinal.Clases.Trabajador;
import co.diana.proyectofinal.pantallas.InfoEmployee;

public class AdapterEmployee extends BaseAdapter {

    private ArrayList<Trabajador> trabajador;

    public AdapterEmployee(){

        trabajador= new ArrayList<>();

    }

    public void addEmployee(Trabajador employee){

        trabajador.add(employee);
        notifyDataSetChanged();

    }

    public void clear(){
        trabajador.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return trabajador.size();
    }

    @Override
    public Object getItem(int i) {
        return trabajador.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup list) {
        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View RowView = inflater.inflate(R.layout.row,null);

       Trabajador em = trabajador.get(i);

        TextView name = RowView.findViewById(R.id.nameEmployee);
        TextView year = RowView.findViewById(R.id.yearsEmployee);
        Button button = RowView.findViewById(R.id.buttonEmployee);

        name.setText(em.getNombre());
        year.setText(em.getEstado());

        String nameEmployee = em.getNombre();
        String id = em.getId();
        int price = em.getCobro();
        String servicio = em.getCategoria();


        button.setOnClickListener(

                (v)->{
                    SharedPreferences pre = list.getContext().getSharedPreferences("Casillero", Context.MODE_PRIVATE);
                    pre.edit().putString("name",nameEmployee).apply();
                    pre.edit().putInt("price",price).apply();
                    pre.edit().putString("idEmployee",id).apply();
                    pre.edit().putString("servicio", servicio).apply();


                    Intent info = new Intent(list.getContext(),InfoEmployee.class);
                    list.getContext().startActivity(info);

                }
        );



        return RowView;
    }
}
