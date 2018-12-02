package afinal.edu.pe.trabajoandroid.activities.vehicle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
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
import afinal.edu.pe.trabajoandroid.models.Vehicle;
import afinal.edu.pe.trabajoandroid.util.FinalSharedPreferences;

public class VehicleDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnvehiclebackshow;
    TextView txtvehicleclientshow;
    TextView txtvehicletypeshow;
    TextView txtvehiclemodelshow;
    TextView txtvehiclebrandshow;
    TextView txtvehicleplacashow;
    FirebaseDatabase db;
    Client client;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

        txtvehiclebrandshow=findViewById(R.id.txtvehiclebrandshow);
        txtvehicletypeshow=findViewById(R.id.txtvehicletypeshow);
        txtvehiclemodelshow=findViewById(R.id.txtvehiclemodelshow);
        txtvehicleplacashow=findViewById(R.id.txtvehicleplacashow);
        txtvehicleclientshow=findViewById(R.id.txtvehicleclientshow);
        btnvehiclebackshow=findViewById(R.id.btnvehiclebackshow);

        btnvehiclebackshow.setOnClickListener(this);

        client=null;
        Bundle extras = getIntent().getExtras();

        if(extras == null) {
            id= null;
        } else {
            id= extras.getString("idvehiculo");
        }
        db = FirebaseDatabase.getInstance();
        DatabaseReference vehiclesRef = db.getReference("vehiculos/" + id);

        if(id != null) {
            cargaDatos(vehiclesRef);
        }else{
            Toast.makeText(this,"Hubo un error al consultar cliente...",Toast.LENGTH_SHORT).show();
        }

    }

    private void cargaDatos(DatabaseReference vehiclesRef) {
        try {
            vehiclesRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Vehicle ve = dataSnapshot.getValue(Vehicle.class);
                    txtvehiclebrandshow.setText(ve.getMarca());
                    txtvehiclemodelshow.setText(ve.getModelo());
                    txtvehicleplacashow.setText(ve.getPlaca());
                    txtvehicletypeshow.setText(ve.getTipo());

                    DataSnapshot ds = dataSnapshot.child("cliente");
                    Iterable<DataSnapshot> dslist = ds.getChildren();
                    for (DataSnapshot d : dslist) {
                        client = d.getValue(Client.class);
                    }
                    txtvehicleclientshow.setText(client.getNombre() + " " + client.getApellido());

                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch(Exception ex){
            Toast.makeText(VehicleDetailActivity.this,ex.getMessage(),Toast.LENGTH_SHORT).show();
            return;
        }
    }


    @Override
    public void onClick(View v) {
        this.finish();
    }
}
