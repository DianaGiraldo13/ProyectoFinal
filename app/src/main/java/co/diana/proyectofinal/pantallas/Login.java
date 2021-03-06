package co.diana.proyectofinal.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.diana.proyectofinal.MainActivity;
import co.diana.proyectofinal.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText email;
    private EditText password;
    private TextView signUp,forgotPassLink;
    private Button bttLogin;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailEdit);
        password = findViewById(R.id.passwordEdit);
        bttLogin = findViewById(R.id.bttLogin);
        signUp = findViewById(R.id.goSignUp);
        forgotPassLink = findViewById(R.id.olvideContrasena);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        bttLogin.setOnClickListener(this);
        signUp.setOnClickListener(this);
        forgotPassLink.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.goSignUp:

                Intent i = new Intent(this,SignUp.class);
                startActivity(i);
                finish();

                break;

            case R.id.bttLogin:

                if(password.getText().toString().equals("")  || email.getText().toString().equals("") ){

                    Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_LONG).show();

                } else {

                    auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())

                            .addOnCompleteListener(

                                    task -> {

                                        if (task.isSuccessful()) {

                                            if(auth.getCurrentUser().isEmailVerified()){

                                                Intent intent = new Intent(this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }else{

                                                Toast.makeText(this, "Tiene que verificar su correo",Toast.LENGTH_LONG).show();
                                                auth.signOut();

                                            }

                                        } else {
                                            Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }


                            );
                }

                break;

            case R.id.olvideContrasena:

                Intent next = new Intent(this,cambioContrasenna.class);
                startActivity(next);



                break;
        }



    }
}