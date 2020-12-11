package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class Pantalladonar extends AppCompatActivity implements View.OnClickListener{


    private EditText editTextmonto;
    private Button Donar;
    private ImageView servicioButton, recogerButton, perfilButton, homeButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladonar);

        Donar=findViewById(R.id.Donar);
        editTextmonto=findViewById(R.id.editTextmonto);

        servicioButton = findViewById(R.id.serviciobutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        intent=getIntent();
        String tipo=intent.getStringExtra("tipo");
        Log.e("TAG", tipo );


        Donar.setOnClickListener(
                (v)->{
                    if (editTextmonto.getText().toString().isEmpty()){
                        Toast.makeText(this, "Escriba el monto de su donacion", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(this, Pantalladinero.class);
                        int monto=Integer.parseInt(editTextmonto.getText().toString());
                       // Log.e("TAG", String.valueOf(monto));
                       intent.putExtra("monto", monto);
                       intent.putExtra("tipo",tipo);
                       // Log.e("TAG", String.valueOf(Integer.parseInt(editTextmonto.getText().toString())));
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