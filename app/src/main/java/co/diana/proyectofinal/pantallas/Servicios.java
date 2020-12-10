package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.diana.proyectofinal.R;

public class Servicios extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2,button3,button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this,List.class);


        switch (view.getId()){

            case R.id.button1:

                i.putExtra("service","reparacion");



                break;

            case R.id.button2:

                i.putExtra("service","varios");


                break;

            case  R.id.button3:

                i.putExtra("service","limpieza");


                break;

            case R.id.button4:

                i.putExtra("service","exteriores");


                break;
        }

        startActivity(i);

    }
}