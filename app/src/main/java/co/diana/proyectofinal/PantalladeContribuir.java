package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class PantalladeContribuir extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout Educacion;
    private ConstraintLayout Alimentacion;
    private ConstraintLayout Medicamentos;
    private ConstraintLayout Infraestructura;
    private ImageView servicioButton, recogerButton, perfilButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallade_contribuir);

        Educacion=findViewById(R.id.Donaciones);
        Alimentacion=findViewById(R.id.Servicios);
        Medicamentos=findViewById(R.id.Medicamentos);
        Infraestructura=findViewById(R.id.Infraestructura);

        servicioButton = findViewById(R.id.serviciobutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);


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