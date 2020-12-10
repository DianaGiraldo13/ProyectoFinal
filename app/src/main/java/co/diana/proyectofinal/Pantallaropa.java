package co.diana.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantallaropa extends AppCompatActivity {

    private Button Donar;
    private CheckBox checkBox1mujer;
    private CheckBox checkBox2niña;
    private CheckBox checkBox3hombre;
    private CheckBox checkBox4niño;
    private EditText editText1mujer;
    private EditText editText2niña;
    private EditText editText3hombre;
    private EditText editText4niño;
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
}