package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class Pantalladiferentesdonaciones extends AppCompatActivity {

    private ConstraintLayout Dinero;
    private ConstraintLayout Ropa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladiferentesdonaciones);

        Dinero= findViewById(R.id.Dinero);
        Ropa= findViewById(R.id.Ropa);

        Dinero.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this,PantalladeContribuir.class);
                    startActivity(intent);

                }
        );

        Ropa.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this, Pantallaropa.class);
                    startActivity(intent);

                }
        );
    }

}