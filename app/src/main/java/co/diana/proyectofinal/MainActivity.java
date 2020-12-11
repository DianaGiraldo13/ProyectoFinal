package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.diana.proyectofinal.Clases.User;
import co.diana.proyectofinal.pantallas.Inicio;
import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;
import co.diana.proyectofinal.pantallas.intro;
import co.diana.proyectofinal.pantallas.notificaciones;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout Donaciones, servicio;
    private ImageView servicioButton, donacionButton, recogerButton, perfilButton;
    private ImageButton notificacionButton;
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private String id;
    private ImageView imageViewbarra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewbarra=findViewById(R.id.imageViewbarra);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        imageViewbarra.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantallausuario.class);
                    startActivity(intent);
                }
        );

        if(auth.getCurrentUser()== null){

            goToLgin();

        } else {

            Donaciones=findViewById(R.id.Donaciones);
            servicio = findViewById(R.id.Servicios);
            servicioButton = findViewById(R.id.serviciobutton);
            donacionButton = findViewById(R.id.donacionbutton);
            recogerButton = findViewById(R.id.recolectarbutton);
            perfilButton = findViewById(R.id.perfilbutton);
            notificacionButton = findViewById(R.id.notificacionButton);

            servicioButton.setOnClickListener(this);
            donacionButton.setOnClickListener(this);
            recogerButton.setOnClickListener(this);
            perfilButton.setOnClickListener(this);

            id = auth.getCurrentUser().getUid();

            Donaciones.setOnClickListener(
                    (v)->{
                        Intent intent= new Intent(this,Pantalladiferentesdonaciones.class);
                        startActivity(intent);

                    }
            );

            servicio.setOnClickListener(
                    (v)->{
                        Intent i= new Intent(this, Servicios.class);
                        startActivity(i);

                    }
            );

            notificacionButton.setOnClickListener(
                    (v)->{

                        Intent n= new Intent(this, notificaciones.class);
                        startActivity(n);

                    }
            );

            loadDataUser();


        }


    }

    private void goToLgin() {

        Intent i = new Intent(this, intro.class);
        startActivity(i);
        finish();
    }

    public void loadDataUser() {

        if (auth.getCurrentUser() != null) {
            id = auth.getCurrentUser().getUid();

            db.getReference().child("users").child(id).addListenerForSingleValueEvent(

                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {

                            User user = snapshot.getValue(User.class);
                            String name = user.getNombre();
                            String correo = user.getCorreo();
                            SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
                            pre.edit().putString("idUser",id).apply();
                            pre.edit().putString("nameUser",name).apply();
                            pre.edit().putString("correo",correo).apply();

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    }
            );

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

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