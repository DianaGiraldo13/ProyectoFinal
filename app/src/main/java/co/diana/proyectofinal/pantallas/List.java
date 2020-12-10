package co.diana.proyectofinal.pantallas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import co.diana.proyectofinal.Adapter.AdapterEmployee;
import co.diana.proyectofinal.Clases.Trabajador;
import co.diana.proyectofinal.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class List extends AppCompatActivity {

    private FirebaseDatabase db;
    private AdapterEmployee adapter;
    private ListView ListEmployee;
    private String service;
    private TextView nameService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_service);

        ListEmployee = findViewById(R.id.ListEmployee);
        nameService = findViewById(R.id.nameService);

        db = FirebaseDatabase.getInstance();
        adapter = new AdapterEmployee();
        ListEmployee.setAdapter(adapter);

        service = getIntent().getExtras().getString("service");

        nameService.setText(service);


        loadData();

    }

    public void loadData() {


        db.getReference().child("trabajadores").child(service).addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {

                       adapter.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Trabajador tr = child.getValue(Trabajador.class);
                            adapter.addEmployee(tr);

                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );






    }


}