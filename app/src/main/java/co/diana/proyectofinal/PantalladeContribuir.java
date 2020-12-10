package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class PantalladeContribuir extends AppCompatActivity {

    private ConstraintLayout Educacion;
    private ConstraintLayout Alimentacion;
    private ConstraintLayout Medicamentos;
    private ConstraintLayout Infraestructura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallade_contribuir);

        Educacion=findViewById(R.id.Donaciones);
        Alimentacion=findViewById(R.id.Servicios);
        Medicamentos=findViewById(R.id.Medicamentos);
        Infraestructura=findViewById(R.id.Infraestructura);


        Educacion.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladonar.class);
                    intent.putExtra("tipo","Educacion");
                    startActivity(intent);

                }
        );

        Alimentacion.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladonar.class);
                    intent.putExtra("tipo","Alimentacion");
                    startActivity(intent);

                }
        );

        Medicamentos.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladonar.class);
                    intent.putExtra("tipo","Medicamentos");
                    startActivity(intent);

                }
        );

        Infraestructura.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,Pantalladonar.class);
                    intent.putExtra("tipo","Infraestructura");
                    startActivity(intent);

                }
        );

    }
}