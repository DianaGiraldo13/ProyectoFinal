package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pantalladonacionrealizada extends AppCompatActivity {

    private Button Aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladonacionrealizada);

        Aceptar=findViewById(R.id.Aceptar);

        Aceptar.setOnClickListener(
                (v)->{
                    Intent intent= new Intent(this, MainActivity.class);
                    startActivity(intent);

                }
        );

    }
}