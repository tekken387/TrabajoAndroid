package afinal.edu.pe.trabajoandroid.activities.vehicle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.models.Vehicle;

public class VehicleRegisterActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    ImageButton btnvehicleclientadd;
    ImageButton btnvehiclesaveadd;
    AutoCompleteTextView txtvehicleclientadd;
    TextView txtvehicletypeadd;
    TextView txtvehiclemodeladd;
    TextView txtvehiclebrandadd;
    TextView txtvehicleplacaadd;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_register);

        btnvehicleclientadd=findViewById(R.id.btnvehicleclientadd);
        btnvehiclesaveadd=findViewById(R.id.btnvehiclesaveadd);
        txtvehicleclientadd=findViewById(R.id.txtvehicleclientadd);
        txtvehicletypeadd=findViewById(R.id.txtvehicletypeadd);
        txtvehiclemodeladd=findViewById(R.id.txtvehiclemodeladd);
        txtvehiclebrandadd=findViewById(R.id.txtvehiclebrandadd);
        txtvehicleplacaadd=findViewById(R.id.txtvehicleplacaadd);
        btnvehiclesaveadd.setOnClickListener(this);
        btnvehicleclientadd.setOnClickListener(this);
        txtvehicleclientadd.addTextChangedListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientsaveadd){
            database = FirebaseDatabase.getInstance();
            DatabaseReference vehiculosRef = database.getReference("vehiculos");
            DatabaseReference vehiculoActualRef = vehiculosRef.push();

            Vehicle ve=new Vehicle();
            ve.setIdvehiculo(vehiculoActualRef.getKey());
            ve.setMarca(txtvehiclebrandadd.getText().toString());
            ve.setModelo(txtvehiclemodeladd.getText().toString());
            ve.setPlaca(txtvehicleplacaadd.getText().toString());
            ve.setTipo(txtvehicletypeadd.getText().toString());
            Client client=new Client();
            ve.setCliente(client);

            vehiculosRef.child(vehiculoActualRef.getKey()).setValue(ve);

            limpiar();
        }
    }

    public void limpiar(){
        txtvehiclebrandadd.setText("");
        txtvehiclemodeladd.setText("");
        txtvehicleplacaadd.setText("");
        txtvehicletypeadd.setText("");
        txtvehicleclientadd.setText("");
    }

    public void BuscaCliente(final String nombre) {

        final  ArrayList<String> sug = new ArrayList<>();

        Query referencias =  FirebaseDatabase.getInstance().getReference("clientes").child("documento").orderByKey().startAt(nombre).endAt((nombre)+ "\uf8ff");
        //database = FirebaseDatabase.getInstance();
        referencias.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (dataSnapshot != null) {

                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String name = (String) ds.getKey();
                        sug.add(name);
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(VehicleRegisterActivity.this, android.R.layout.select_dialog_item, sug);
                    txtvehicleclientadd.setAdapter(arrayAdapter);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        //This is where I do the filtering as the user types


        if (!TextUtils.isEmpty(s.subSequence(0, s.length()).toString())) {
            BuscaCliente((s.subSequence(0, s.length())).toString());
        }
    }


    @Override
    public void afterTextChanged(Editable s) {

    }
}
