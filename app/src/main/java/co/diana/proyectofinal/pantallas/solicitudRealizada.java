package co.diana.proyectofinal.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.R;

public class solicitudRealizada extends AppCompatActivity {

    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_realizada);

        aceptar = findViewById(R.id.aceptar);
        aceptar.setOnClickListener(

                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );
    }
}