package afinal.edu.pe.trabajoandroid.activities.services;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.models.Service;

public class ServiceDetailActivity extends AppCompatActivity implements View.OnClickListener{

    String id;
    TextView txtservicenameshow;
    TextView txtservicepriceshow;

    ImageButton btnservicebackshow;
    FirebaseDatabase db;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_detail);

        txtservicenameshow = findViewById(R.id.txtservicenameshow);
        txtservicepriceshow = findViewById(R.id.txtservicepriceshow);
        btnservicebackshow = findViewById(R.id.btnservicebackshow);
        btnservicebackshow.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            id = null;
        } else {
            id = extras.getString("idservicio");
        }
        db = FirebaseDatabase.getInstance();
        DatabaseReference serviceRef = db.getReference("servicios/" + id);

        if (id != null) {
            cargaDatos(serviceRef);
        } else {
            Toast.makeText(this, "Hubo un error al consultar servicio...", Toast.LENGTH_SHORT).show();
        }
    }
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnbackshow){
                this.finish();
            }
        }

        public void cargaDatos(DatabaseReference serviceRef){

            serviceRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Service servicio = dataSnapshot.getValue(Service.class);
                    txtservicenameshow.setText(servicio.getNombre());
                    txtservicepriceshow.setText(String.valueOf(servicio.getPrecio()));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

}
