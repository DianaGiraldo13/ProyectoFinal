package co.diana.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.diana.proyectofinal.Clases.User;

public class Pantallausuario extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewCel;
    private TextView textViewCorreo;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private User usuarioactivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallausuario);

        textViewNombre=findViewById(R.id.textViewNombre);
        textViewCel=findViewById(R.id.textViewCel);
        textViewCorreo=findViewById(R.id.textViewCorreo);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        database.getReference().child("users").child(auth.getCurrentUser().getUid()).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        usuarioactivo=dataSnapshot.getValue(User.class);
                        textViewNombre.setText(usuarioactivo.getNombre());
                        textViewCorreo.setText(usuarioactivo.getCorreo());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );



    }
}