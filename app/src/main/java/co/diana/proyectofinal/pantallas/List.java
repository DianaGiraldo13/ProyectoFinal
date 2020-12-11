package co.diana.proyectofinal.pantallas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import co.diana.proyectofinal.Adapter.AdapterEmployee;
import co.diana.proyectofinal.Clases.Trabajador;
import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.Pantalladiferentesdonaciones;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.pantallausuario;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class List extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private AdapterEmployee adapter;
    private ListView ListEmployee;
    private String service;
    private TextView nameService;
    private ImageView donacionButton, recogerButton, perfilButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_service);

        ListEmployee = findViewById(R.id.ListEmployee);
        nameService = findViewById(R.id.nameService);

        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);


        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        db = FirebaseDatabase.getInstance();
        adapter = new AdapterEmployee();
        ListEmployee.setAdapter(adapter);

        service = getIntent().getExtras().getString("service");

        nameService.setText(service);


        loadData();

    }

    public void loadData() {


        db.getReference().child("trabajadores").child(service).addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                       adapter.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Trabajador tr = child.getValue(Trabajador.class);
                            adapter.addEmployee(tr);

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