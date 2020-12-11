package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.R;

public class cambiarContrasenna extends AppCompatActivity {

    private EditText nuevaContrasenna;
    private Button guardar;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenna);

        nuevaContrasenna = findViewById(R.id.nuevaContrasenna);
        guardar = findViewById(R.id.guardar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        guardar.setOnClickListener(

                (v)->{



                    user.updatePassword(nuevaContrasenna.getText().toString().trim()).addOnCompleteListener(
                            task -> {
                                if(task.isSuccessful()){

                                    user.reload().addOnCompleteListener(
                                            reloadTask ->{

                                                Intent i = new Intent(this, MainActivity.class);
                                                startActivity(i);
                                                finish();

                                            }
                                    );
                                    Toast.makeText(this,"Contraseña cambiada con exito",Toast.LENGTH_LONG).show();



                                } else{

                                    Toast.makeText(this,"Error, intente más tarde"+task.getException(),Toast.LENGTH_LONG).show();


                                }
                            }
                    );


                }
        );



    }
}