package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.diana.proyectofinal.Adapter.AdapterAceptados;
import co.diana.proyectofinal.Adapter.AdapterSolicitud;
import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.Clases.Trabajador;
import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.Pantalladiferentesdonaciones;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.pantallausuario;

public class notificaciones extends AppCompatActivity implements View.OnClickListener {

    private ImageView servicioButton, donacionButton, recogerButton, perfilButton, homeButton;
    private FirebaseDatabase db;
    private AdapterSolicitud adapter;
    private AdapterAceptados adapterAceptados;
    private ListView listEspera, listAceptados;
    private String idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);
        listEspera = findViewById(R.id.listEspera);
        listAceptados = findViewById(R.id.listAceptados);


        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        idUser = pre.getString("idUser","NO_ID_USER");

        db = FirebaseDatabase.getInstance();
        adapter = new AdapterSolicitud();
        listEspera.setAdapter(adapter);
        adapterAceptados = new AdapterAceptados();
        listAceptados.setAdapter(adapterAceptados);

        loadData();

    }

    private void loadData() {

        db.getReference().child("solicitudes").child(idUser).child("aceptada").addValueEventListener(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                        adapterAceptados.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Solicitud sol = child.getValue(Solicitud.class);
                            adapterAceptados.addEmployee(sol);
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );

        db.getReference().child("solicitudes").child(idUser).child("EnEspera").addValueEventListener(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                        adapter.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Solicitud sol = child.getValue(Solicitud.class);
                            adapter.addEmployee(sol);
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.homeButton:

                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                finish();

                break;

            case R.id.serviciobutton:

                Intent s = new Intent(this,Servicios.class);
                startActivity(s);
                finish();

                break;

            case R.id.donacionbutton:

                Intent d = new Intent(this, Pantalladiferentesdonaciones.class);
                startActivity(d);
                finish();
                break;

            case R.id.recolectarbutton:

                Intent r = new Intent(this, donacionesRecogidas.class);
                startActivity(r);
                finish();
                break;

            case R.id.perfilbutton:

                Intent p = new Intent(this, pantallausuario.class);
                startActivity(p);
                finish();
                break;

        }
    }
}