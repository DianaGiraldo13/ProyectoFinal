package co.diana.proyectofinal.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import co.diana.proyectofinal.R;

public class cambioContrasenna extends AppCompatActivity implements View.OnClickListener{

    private EditText correo;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_contrasenna);

        correo = findViewById(R.id.correo);
        send = findViewById(R.id.send);

        send.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Log.e("recibido","entre");
        FirebaseAuth.getInstance().sendPasswordResetEmail(correo.getText().toString()).addOnCompleteListener(

                task->{

                    if(task.isSuccessful()){

                        Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(this,task.getException().toString(),Toast.LENGTH_LONG).show();
                    }

        }
        );
    }
}