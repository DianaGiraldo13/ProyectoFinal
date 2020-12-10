package co.diana.proyectofinal.pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import co.diana.proyectofinal.R;


public class Inicio extends AppCompatActivity implements View.OnClickListener {

    private Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signUp);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {



        switch (view.getId()){

            case R.id.login:

                Intent i = new Intent(this,Login.class);
                startActivity(i);
                finish();

                break;

            case R.id.signUp:

                Intent o = new Intent(this,SignUp.class);
                startActivity(o);
                finish();

                break;
        }

    }
}