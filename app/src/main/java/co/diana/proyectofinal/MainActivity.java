package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.diana.proyectofinal.Clases.User;
import co.diana.proyectofinal.pantallas.Inicio;
import co.diana.proyectofinal.pantallas.Servicios;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout Donaciones, servicio;
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

            loadDataUser();


        }


    }

    private void goToLgin() {

        Intent i = new Intent(this, Inicio.class);
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
                            SharedPreferences pre = getSharedPreferences("Casillero", Context.MODE_PRIVATE);
                            pre.edit().putString("idUser",id).apply();
                            pre.edit().putString("nameUser",name).apply();

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    }
            );

        }
    }

}