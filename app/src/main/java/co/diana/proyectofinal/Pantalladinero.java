package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Pantalladinero extends AppCompatActivity {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladinero);


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
                        String id= UUID.randomUUID().toString();
                        Dinero dinero= new Dinero(auth.getCurrentUser().getUid(),editTextNombre.getText().toString(),id, tipo,monto,"","pendiente");
                        database.getReference().child("donaciones").child("dinero").child(tipo+"/"+id).setValue(dinero);
                        Intent intent= new Intent(this,Pantalladonacionrealizada.class);
                        startActivity(intent);
                    }


                }
        );
    }
}