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

import co.diana.proyectofinal.Adapter.AdapterDonacion;
import co.diana.proyectofinal.Adapter.AdapterRecogida;
import co.diana.proyectofinal.Clases.DonacionAceptada;
import co.diana.proyectofinal.Clases.Trabajador;
import co.diana.proyectofinal.Donacion;
import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.Pantalladiferentesdonaciones;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.Ropa;
import co.diana.proyectofinal.pantallausuario;

public class donacionesRecogidas extends AppCompatActivity implements View.OnClickListener {

    private AdapterDonacion adapterDonacion;
    private AdapterRecogida adapterRecogida;
    private ListView listDonacion, listRecoger;
    private FirebaseDatabase db;
    private String idUser;
    private ImageView servicioButton, donacionButton, perfilButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donaciones_recogidas);

        servicioButton = findViewById(R.id.serviciobutton);
        donacionButton = findViewById(R.id.donacionbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);
        listDonacion = findViewById(R.id.listRecogidas);
        listRecoger = findViewById(R.id.listPorRecoger);

        SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
        idUser = pre.getString("idUser","NO_ID_USER");

        db = FirebaseDatabase.getInstance();
        adapterDonacion = new AdapterDonacion();
        adapterRecogida = new AdapterRecogida();
        listDonacion.setAdapter(adapterDonacion);
        listRecoger.setAdapter(adapterRecogida);

        servicioButton.setOnClickListener(this);
        donacionButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        loadData();
    }

    private void loadData() {

        db.getReference().child("donacionesAceptadas").child("ropa").orderByChild("idusuario").equalTo(idUser).addValueEventListener(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                        adapterDonacion.clear();

                        for(DataSnapshot child : data.getChildren()){
                            DonacionAceptada dona = child.getValue(DonacionAceptada.class);
                            adapterDonacion.addDonacion(dona);
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }

        );

        db.getReference().child("donaciones").child("ropa").orderByChild("idusuario").equalTo(idUser).addValueEventListener(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                        adapterRecogida.clear();

                        for(DataSnapshot child : data.getChildren()){
                            Ropa dona = child.getValue(Ropa.class);
                            adapterRecogida.addDonacion(dona);
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


            case R.id.perfilbutton:

                Intent p = new Intent(this, pantallausuario.class);
                startActivity(p);
                finish();
                break;

        }

    }
}