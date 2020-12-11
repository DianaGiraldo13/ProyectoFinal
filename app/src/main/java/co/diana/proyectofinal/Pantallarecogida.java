package co.diana.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

import co.diana.proyectofinal.Clases.User;
import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class Pantallarecogida extends AppCompatActivity implements View.OnClickListener{

    private Button donar;
    private EditText editTextDireccion;
    private EditText editTexthora;
    private EditText editTexthoramin;
    private EditText editTextMes;
    private EditText editTextDia;
    private ImageView servicioButton, recogerButton, perfilButton, homeButton;

    Intent intent;
    ArrayList<String>Seleccionados;
    FirebaseDatabase database;
    private FirebaseAuth auth;
    private User user;
    ArrayList<Ropa>Ropas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database= FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_pantallarecogida);

        servicioButton = findViewById(R.id.serviciobutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        auth=FirebaseAuth.getInstance();
        database.getReference().child("users").child(auth.getCurrentUser().getUid()).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        user=dataSnapshot.getValue(User.class);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );
        Seleccionados=new ArrayList<>();
        Ropas=new ArrayList<>();
        intent=getIntent();
        donar=findViewById(R.id.donar);
        editTextDireccion=findViewById(R.id.editTextDireccion);
        editTexthora=findViewById(R.id.editTexthora);
        editTexthoramin=findViewById(R.id.editTexthoramin);
        editTextMes=findViewById(R.id.editTextMes);
        editTextDia=findViewById(R.id.editTextDia);
        Seleccionados=intent.getStringArrayListExtra("Seleccionado");
        Log.e("TAG", String.valueOf(intent.getStringArrayListExtra("Seleccionado")));

        donar.setOnClickListener(
                (v)->{
                    if (editTextDia.getText().toString().isEmpty()||editTextDireccion.getText().toString().isEmpty()||editTexthoramin.getText().toString().isEmpty()||editTexthora.getText().toString().isEmpty()||editTextMes.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    }else{
                        String horaentrega=editTexthora.getText().toString()+":"+editTexthoramin.getText().toString();
                        String fechadeentrega=editTextMes.getText().toString()+"/"+editTextDia.getText().toString();
                        String direccion=editTextDireccion.getText().toString();



                        for(int i=0;i<Seleccionados.size();i++){
                            String id= UUID.randomUUID().toString();
                            Ropa ropa= new Ropa(auth.getCurrentUser().getUid(),user.getNombre(),id,"Ropa",direccion,"en espera",horaentrega,fechadeentrega,Seleccionados.get(i));
                            Ropas.add(ropa);
                        }
                      
                        //Log.e("TAG", String.valueOf(Ropas.size()));
                       // Log.e("TAG", String.valueOf(Seleccionados.size()));


                        for (int i=0;i<Ropas.size();i++){
                            database.getReference().child("donaciones").child("ropa").child(Ropas.get(i).getId()).setValue(Ropas.get(i));
                            Log.e("TAG", Ropas.get(i).getId());
                        }
                        //Log.e("TAG", String.valueOf(Ropas.size()));
                        // Log.e("TAG", String.valueOf(Seleccionados.size()));

                        Intent intent= new Intent(this, Pantalladonacionrealizada.class);
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