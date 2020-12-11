package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import co.diana.proyectofinal.pantallas.Servicios;
import co.diana.proyectofinal.pantallas.donacionesRecogidas;

public class Pantallaropa extends AppCompatActivity implements View.OnClickListener{

    private Button Donar;
    private CheckBox checkBox1mujer;
    private CheckBox checkBox2niña;
    private CheckBox checkBox3hombre;
    private CheckBox checkBox4niño;
    private EditText editText1mujer;
    private EditText editText2niña;
    private EditText editText3hombre;
    private EditText editText4niño;
    private ImageView servicioButton, recogerButton, perfilButton, homeButton;

    ArrayList<String> Seleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaropa);

        Donar=findViewById(R.id.Donar);
        checkBox1mujer=findViewById(R.id.checkBox1);
        checkBox2niña=findViewById(R.id.checkBox2);
        checkBox3hombre=findViewById(R.id.checkBox3);
        checkBox4niño=findViewById(R.id.checkBox4);
        editText1mujer=findViewById(R.id.editText1);
        editText2niña=findViewById(R.id.editText2);
        editText3hombre=findViewById(R.id.editText3);
        editText4niño=findViewById(R.id.editText4);

        servicioButton = findViewById(R.id.serviciobutton);
        recogerButton = findViewById(R.id.recolectarbutton);
        perfilButton = findViewById(R.id.perfilbutton);
        homeButton = findViewById(R.id.homeButton);

        servicioButton.setOnClickListener(this);
        recogerButton.setOnClickListener(this);
        perfilButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        editText1mujer.setEnabled(false);
        editText2niña.setEnabled(false);
        editText3hombre.setEnabled(false);
        editText4niño.setEnabled(false);

        checkBox1mujer.setOnClickListener(this);
        checkBox2niña.setOnClickListener(this);
        checkBox3hombre.setOnClickListener(this);
        checkBox4niño.setOnClickListener(this);



       Donar.setOnClickListener(

                (v)->{
                    //Verificar si hay checkbox seleccionados
                    if(!(checkBox1mujer.isChecked()||checkBox2niña.isChecked()||checkBox3hombre.isChecked()||checkBox4niño.isChecked())){
                        Toast.makeText(this, "Por favor seleccione alguno", Toast.LENGTH_SHORT).show();
                    }
                    else{
                       Seleccionado=new ArrayList<>();
                        if (checkBox1mujer.isChecked()) {
                            if (editText1mujer.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Por favor seleccione la cantidad", Toast.LENGTH_SHORT).show();
                            }else{
                                String ropa="mujer:"+editText1mujer.getText().toString();
                                Seleccionado.add(ropa);

                            }
                        }
                        if (checkBox2niña.isChecked()) {
                            if (editText2niña.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Por favor seleccione la cantidad", Toast.LENGTH_SHORT).show();
                            }else{
                                String ropa="niña:"+editText2niña.getText().toString();
                                Seleccionado.add(ropa);

                            }
                        }
                        if (checkBox3hombre.isChecked()) {
                            if (editText3hombre.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Por favor seleccione la cantidad", Toast.LENGTH_SHORT).show();
                            }else{
                                String ropa="hombre:"+editText3hombre.getText().toString();
                                Seleccionado.add(ropa);

                            }
                        }
                        if (checkBox4niño.isChecked()) {
                            if (editText4niño.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Por favor seleccione la cantidad", Toast.LENGTH_SHORT).show();
                            }else{
                                String ropa="niño:"+editText4niño.getText().toString();
                                Seleccionado.add(ropa);

                            }
                        }
                       // Log.e("TAG", String.valueOf(Seleccionado));
                        Intent intent= new Intent(this, Pantallarecogida.class);
                        intent.putStringArrayListExtra("Seleccionado",Seleccionado);
                        startActivity(intent);
                    }



                }
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.checkBox1:
                if (checkBox1mujer.isChecked()) {
                    editText1mujer.setEnabled(true);
                } else {
                    editText1mujer.setEnabled(false);
                }
                break;

            case R.id.checkBox2:

                if(checkBox2niña.isChecked()){
                    editText2niña.setEnabled(true);

                } else {
                    editText2niña.setEnabled(false);
                }

                break;

            case R.id.checkBox3:
                if(checkBox3hombre.isChecked()){
                    editText3hombre.setEnabled(true);

                }else {
                    editText3hombre.setEnabled(false);
                }

                break;

            case R.id.checkBox4:
                if(checkBox4niño.isChecked()){
                    editText4niño.setEnabled(true);

                } else {
                    editText4niño.setEnabled(false);
                }


                break;

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