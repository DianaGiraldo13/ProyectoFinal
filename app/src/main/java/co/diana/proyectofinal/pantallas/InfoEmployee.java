package co.diana.proyectofinal.pantallas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.R;

public class InfoEmployee extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView name, description, total, precio;
    private EditText address, diaText;
    private Button solicitar, button1,button2,button3,button4,button5,button6;
    private Spinner listHours,spinnerMeses;
    private int valorTotal, priceE;
    private String idEmployee, numberHours,nombreEmployee,telEmployee;
    private String idUser, nameUser,direccion, servicio;
    private String fecha, mes, dia,hora;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_employee);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        precio = findViewById(R.id.precio);
        total = findViewById(R.id.total);
        diaText = findViewById(R.id.editdia);
        address = findViewById(R.id.address);
        listHours = findViewById(R.id.spinnerList);
        spinnerMeses = findViewById(R.id.spinnerMeses);
        solicitar = findViewById(R.id.buttonSolicitar);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        db = FirebaseDatabase.getInstance();


        solicitar.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista, android.R.layout.simple_list_item_1);
        listHours.setAdapter(adapter);
        listHours.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.meses, android.R.layout.simple_list_item_1);
        spinnerMeses.setAdapter(adapter2);
        spinnerMeses.setOnItemSelectedListener(this);


        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        nombreEmployee = pre.getString("name", "NO_EMPLOYEE");
        priceE = pre.getInt("price", 0);
        idEmployee = pre.getString("idEmployee","NO_ID");
        idUser = pre.getString("idUser","NO_ID_USER");
        nameUser = pre.getString("nameUser","NO_USER");
        servicio = pre.getString("servicio","NO_SERVICIO");
        telEmployee = pre.getString("telEmployee","NO_TEL");


        precio.setText("X $ "+priceE);
        name.setText(nombreEmployee);
        description.setText(servicio);


    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.buttonSolicitar:

                direccion = address.getText().toString();
                dia = diaText.getText().toString();

                if(direccion.equals("")|| dia.equals("")|| mes.equals("") || numberHours.equals(0) || valorTotal <=0 ){

                    Toast.makeText(this,"Verifique que todos los campos sean correctos",Toast.LENGTH_LONG).show();

                } else {

                    fecha = dia+"/"+mes;

                    String id = db.getReference().child("solicitudes").child(idUser).push().getKey();
                    DatabaseReference ref = db.getReference().child("solicitudes").child(idUser).child("EnEspera").child(id);
                    Solicitud sol = new Solicitud(
                            nombreEmployee,
                            telEmployee,
                            idEmployee,
                            servicio,
                            idUser,
                            nameUser,
                            direccion,
                            fecha,
                            hora,
                            numberHours,
                            valorTotal
                    );

                    ref.setValue(sol);

                    Intent i = new Intent(this, solicitudRealizada.class);
                    startActivity(i);


                }

                break;

            case R.id.button1:
                hora = "7:00Am";
                button1.setBackgroundColor(Color.parseColor("#08596C"));

                button2.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button3.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button4.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button5.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button6.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;

            case R.id.button2:
                hora = "8:00Am";
                button2.setBackgroundColor(Color.parseColor("#08596C"));

                button1.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button3.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button4.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button5.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button6.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;

            case R.id.button3:
                hora = "9:00Am";
                button3.setBackgroundColor(Color.parseColor("#08596C"));

                button1.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button2.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button4.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button5.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button6.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;

            case R.id.button4:
                hora = "10:00Am";
                button4.setBackgroundColor(Color.parseColor("#08596C"));

                button1.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button2.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button3.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button5.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button6.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;

            case R.id.button5:
                hora = "11:00Am";
                button5.setBackgroundColor(Color.parseColor("#08596C"));

                button1.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button2.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button3.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button4.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button6.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;

            case R.id.button6:
                hora = "12:00Am";
                button6.setBackgroundColor(Color.parseColor("#08596C"));

                button1.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button2.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button3.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button4.setBackgroundColor(Color.parseColor("#F7F7F7"));
                button5.setBackgroundColor(Color.parseColor("#F7F7F7"));

                break;
        }




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()){

            case R.id.spinnerList:

                switch (i) {

                    case 0:

                        valorTotal = 0;
                        numberHours= 0+"";

                        break;

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

                break;

            case R.id.spinnerMeses:

                switch (i) {

                    case 0:
                        mes = "";
                     break;

                    case 1:
                        mes = "Diciembre";
                        break;

                    case 2:
                        mes = "Enero";
                        break;

                    case 3:
                        mes = "Febrero";
                        break;

                }
                break;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}