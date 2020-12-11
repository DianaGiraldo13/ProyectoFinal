package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import co.diana.proyectofinal.R;
import co.diana.proyectofinal.pantallas.Inicio;

public class intro extends AppCompatActivity {

    private int contador;
    private boolean start = true;
    boolean cambiar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        contador = 4;

        tryAgain();
    }

    public void tryAgain() {


        new Thread(
                () ->{

                    while(start){

                        contador--;

                        if(contador <= 0){
                            start = false;
                            cambiar = true;

                            if(cambiar == true){
                                Intent i = new Intent(this, Inicio.class);
                                startActivity(i);
                                finish();
                            }
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
        ).start();




    }


}