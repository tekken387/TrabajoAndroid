package afinal.edu.pe.trabajoandroid.activities.services;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.models.Service;

public class ServiceEditActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseDatabase db;
    EditText txtservicenameedit;
    EditText txtservicepriceedit;
    ImageButton btnserviceedit;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_edit);

        txtservicenameedit=findViewById(R.id.txtservicenameedit);
        txtservicepriceedit=findViewById(R.id.txtservicepriceedit);
        btnserviceedit=findViewById(R.id.btnserviceedit);
        btnserviceedit.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();

        if(extras == null) {
            id= null;
        } else {
            id= extras.getString("idservicio");
        }

        db = FirebaseDatabase.getInstance();
        DatabaseReference serviceRef = db.getReference("servicios/" + id);

        if(id != null) {
            cargaDatos(serviceRef);
        }else{
            Toast.makeText(this,"Hubo un error al consultar servicio...",Toast.LENGTH_SHORT).show();
        }
    }

    public void cerrarActivity(){
        this.finish();
    }

    public void cargaDatos(DatabaseReference serviceRef){

        serviceRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Service servicio = dataSnapshot.getValue(Service.class);
                txtservicenameedit.setText(servicio.getNombre());
                txtservicepriceedit.setText(String.valueOf(servicio.getPrecio()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        DatabaseReference serviceRef = db.getReference("servicios/");

        Service servicio=new Service();
        servicio.setIdservicio(id);
        servicio.setNombre(txtservicenameedit.getText().toString());
        servicio.setPrecio(Float.valueOf(txtservicepriceedit.getText().toString()));

        HashMap map = new HashMap();
        map.put(id,servicio);

        serviceRef.updateChildren(map);
        Toast.makeText(this,"Se actualizó correctamente...",Toast.LENGTH_SHORT).show();
        cerrarActivity();
    }
}
