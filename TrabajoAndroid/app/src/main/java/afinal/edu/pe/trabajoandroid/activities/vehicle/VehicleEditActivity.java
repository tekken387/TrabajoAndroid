package afinal.edu.pe.trabajoandroid.activities.vehicle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.models.Vehicle;

public class VehicleEditActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, TextWatcher {

    ImageButton btnvehicleeditsave;
    AutoCompleteTextView txtvehicleclientedit;
    TextView txtvehicletypeedit;
    TextView txtvehiclemodeledit;
    TextView txtvehiclebrandedit;
    TextView txtvehicleplacaedit;
    FirebaseDatabase db;
    Client client;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_edit);

        txtvehiclebrandedit=findViewById(R.id.txtvehiclebrandedit);
        txtvehicletypeedit=findViewById(R.id.txtvehicletypeedit);
        txtvehiclemodeledit=findViewById(R.id.txtvehiclemodeledit);
        txtvehicleplacaedit=findViewById(R.id.txtvehicleplacaedit);
        txtvehicleclientedit=findViewById(R.id.txtvehicleclientedit);
        btnvehicleeditsave=findViewById(R.id.btnvehicleeditsave);

        txtvehicleclientedit.setOnItemClickListener(this);
        txtvehicleclientedit.addTextChangedListener(this);
        btnvehicleeditsave.setOnClickListener(this);

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
                    txtvehiclebrandedit.setText(ve.getMarca());
                    txtvehiclemodeledit.setText(ve.getModelo());
                    txtvehicleplacaedit.setText(ve.getPlaca());
                    txtvehicletypeedit.setText(ve.getTipo());

                    DataSnapshot ds = dataSnapshot.child("cliente");
                    Iterable<DataSnapshot> dslist = ds.getChildren();
                    client = null;
                    for (DataSnapshot d : dslist) {
                        client = d.getValue(Client.class);
                    }
                    txtvehicleclientedit.setText(client.toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch(Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void BuscaCliente(final String documento) {

        final ArrayList<Client> sug = new ArrayList<>();


        Query referencias =  FirebaseDatabase.getInstance().getReference("clientes").orderByChild("documento").startAt(documento).endAt((documento)+ "\uf8ff");

        referencias.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Client cliente = ds.getValue(Client.class);
                    sug.add(cliente);
                }

                ArrayAdapter<Client> arrayAdapter = new ArrayAdapter<>(VehicleEditActivity.this, android.R.layout.simple_list_item_1, sug);
                txtvehicleclientedit.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        DatabaseReference vehicleRef = db.getReference("vehiculos/");

        Vehicle ve=new Vehicle();
        ve.setIdvehiculo(id);
        ve.setTipo(txtvehicletypeedit.getText().toString());
        ve.setPlaca(txtvehicleplacaedit.getText().toString());
        ve.setModelo(txtvehiclemodeledit.getText().toString());
        ve.setMarca(txtvehiclebrandedit.getText().toString());


        HashMap map = new HashMap();
        map.put(id,ve);
        map.put("vehiculos/"+id+"/cliente/"+client.getIdcliente(),client);

        vehicleRef.updateChildren(map);
        Toast.makeText(this,"Se actualizó correctamente...",Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //This is where I do the filtering as the user types
        if (!TextUtils.isEmpty(s.subSequence(0, s.length()).toString())) {
            BuscaCliente((s.subSequence(0, s.length()).toString()));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
