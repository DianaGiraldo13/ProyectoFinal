package co.diana.proyectofinal.pantallas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.R;

public class InfoEmployee extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView name, description, total, price;
    private EditText address, hours;
    private Button solicitar;
    private Spinner listHours;
    private int valorTotal, priceE;
    private String idEmployee, numberHours,nombreEmployee;
    private String idUser, nameUser,direccion, servicio;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_employee);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        total = findViewById(R.id.total);
        price = findViewById(R.id.price);
        address = findViewById(R.id.address);
        hours = findViewById(R.id.hours);
        listHours = findViewById(R.id.spinnerList);
        solicitar = findViewById(R.id.buttonSolicitar);

        db = FirebaseDatabase.getInstance();


        solicitar.setOnClickListener(this);





        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista, android.R.layout.simple_list_item_1);
        listHours.setAdapter(adapter);
        listHours.setOnItemSelectedListener(this);


        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        nombreEmployee = pre.getString("name", "NO_EMPLOYEE");
        priceE = pre.getInt("price", 0);
        idEmployee = pre.getString("idEmployee","NO_ID");
        idUser = pre.getString("idUser","NO_ID_USER");
        nameUser = pre.getString("nameUser","NO_USER");
        servicio = pre.getString("servicio","NO_SERVICIO");





        name.setText(nombreEmployee);
        //description.setText(price);
        price.setText(priceE + "");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        String fecha = sdf.format(date);

        Log.e("fecha",""+fecha);


    }

    @Override
    public void onClick(View view) {

        direccion = address.getText().toString();

        String id = db.getReference().child("solicitudes").child(idUser).push().getKey();
        DatabaseReference ref = db.getReference().child("solicitudes").child(idUser).child("EnEspera").child(id);
        Solicitud sol = new Solicitud(
                nombreEmployee,
                idEmployee,
                servicio,
                idUser,
                nameUser,
                direccion,
                "Mie/09/Dic/2020",
                "8:00Am",
                numberHours,
                valorTotal




        );

        ref.setValue(sol);

        Intent i = new Intent(this, solicitudRealizada.class);
        startActivity(i);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (i) {

            case 1:
                valorTotal = priceE;
                numberHours = 1+"";
                total.setText(valorTotal + "");
                break;

            case 2:

                valorTotal = priceE * 2;
                numberHours = 2+"";
                total.setText(valorTotal + "");
                break;

            case 3:

                valorTotal = priceE * 3;
                numberHours = 3+"";
                total.setText(valorTotal + "");


                break;

            case 4:

                valorTotal = priceE * 4;
                numberHours = 4+"";
                total.setText(valorTotal + "");


                break;

            case 5:
                valorTotal = priceE * 5;
                numberHours = 5+"";
                total.setText(valorTotal + "");

                break;

            case 6:
                valorTotal = priceE * 6;
                numberHours = 6+"";
                total.setText(valorTotal + "");


                break;

            case 7:
                valorTotal = priceE * 7;
                numberHours = 7+"";
                total.setText(valorTotal + "");


                break;

            case 8:
                valorTotal = priceE * 8;
                numberHours = 8+"";
                total.setText(valorTotal + "");


                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}