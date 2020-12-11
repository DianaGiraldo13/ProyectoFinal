package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.Pantalladiferentesdonaciones;
import co.diana.proyectofinal.R;
import co.diana.proyectofinal.pantallausuario;

public class Servicios extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout reparacion, limpieza, varios, exterior;
    private ImageView donacionButton, recogerButton, perfilButton, homeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        reparacion = findViewById(R.id.reparacion);
        limpieza = findViewById(R.id.limpieza);
        varios = findViewById(R.id.varios);
        exterior = findViewById(R.id.exterior);

        donacionButton = findViewById(R.id.donacionbutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);


        donacionButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        reparacion.setOnClickListener(this);
        limpieza.setOnClickListener(this);
        varios.setOnClickListener(this);
        exterior.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,List.class);


        switch (view.getId()){

            case R.id.reparacion:

                i.putExtra("service","reparacion");
                startActivity(i);
                finish();
                break;

            case R.id.varios:

                i.putExtra("service","oficiosVarios");
                startActivity(i);
                finish();

                break;

            case  R.id.limpieza:

                i.putExtra("service","limpieza");
                startActivity(i);
                finish();
                break;

            case R.id.exterior:

                i.putExtra("service","exteriores");
                startActivity(i);
                finish();

                break;

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