package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class Pantalladinero extends AppCompatActivity implements View.OnClickListener {

    private Button Donar;
    private EditText editTextNombre;
    private EditText editTextNumero;
    private EditText editTextfecha1;
    private EditText editTextfecha2;
    private EditText editTextcvc;
    private TextView Dineromonto;
    private String tipo;
    private Intent intent;
    private int monto;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private ImageView servicioButton, recogerButton, perfilButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladinero);

        servicioButton = findViewById(R.id.serviciobutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        intent=getIntent();
        Donar=findViewById(R.id.Donar);
        editTextNombre=findViewById(R.id.editTextNombre);
        editTextNumero=findViewById(R.id.editTextNumero);
        editTextfecha1=findViewById(R.id.editTextfecha1);
        editTextfecha2=findViewById(R.id.editTextfecha2);
        editTextcvc=findViewById(R.id.editTextcvc);
        Dineromonto=findViewById(R.id.Dineromonto);
        monto=intent.getIntExtra("monto",0);
        Dineromonto.setText(String.valueOf(monto));
        Log.e("TAG", String.valueOf(monto));
        tipo=intent.getStringExtra("tipo");


        Donar.setOnClickListener(
                (v)->{
                    if (editTextcvc.getText().toString().isEmpty()||editTextfecha1.getText().toString().isEmpty()||editTextfecha2.getText().toString().isEmpty()||editTextNombre.getText().toString().isEmpty()||editTextNumero.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                        SimpleDateFormat fe = new SimpleDateFormat("dd-mm-yyyy");
                        String hora = sdf.format(date);
                        String fecha = fe.format(date);


                        String id= UUID.randomUUID().toString();
                        Donacion donacion= new Donacion(
                                auth.getCurrentUser().getUid(),
                                id,
                                tipo,
                                monto,
                                "pendiente",
                                editTextNombre.getText().toString(),
                                fecha,
                                hora);

                        database.getReference().child("donaciones").child("dinero").child(tipo+"/"+id).setValue(donacion);
                        Dinero dinero= new Dinero(auth.getCurrentUser().getUid(),editTextNombre.getText().toString(),id, tipo,monto,"","pendiente");
                        database.getReference().child("donaciones").child("dinero").child(tipo+"/"+id).setValue(dinero);
                        Intent intent= new Intent(this,Pantalladonacionrealizada.class);
                        startActivity(intent);
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

                Intent s = new Intent(this, Servicios.class);
                startActivity(s);
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