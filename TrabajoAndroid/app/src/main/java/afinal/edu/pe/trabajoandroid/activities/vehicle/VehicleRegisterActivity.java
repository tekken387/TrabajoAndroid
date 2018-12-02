package afinal.edu.pe.trabajoandroid.activities.vehicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import afinal.edu.pe.trabajoandroid.R;

public class VehicleRegisterActivity extends AppCompatActivity {

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
        txtvehicleclientadd.setOnItemClickListener(this);
        client=null;

        txtvehicleclientadd.setThreshold(1);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnvehiclesaveadd){
            database = FirebaseDatabase.getInstance();
            DatabaseReference vehiculosRef = database.getReference("vehiculos");
            DatabaseReference vehiculoActualRef = vehiculosRef.push();


            Vehicle ve=new Vehicle();
            ve.setIdvehiculo(vehiculoActualRef.getKey());
            ve.setMarca(txtvehiclebrandadd.getText().toString());
            ve.setModelo(txtvehiclemodeladd.getText().toString());
            ve.setPlaca(txtvehicleplacaadd.getText().toString());
            ve.setTipo(txtvehicletypeadd.getText().toString());

            if(client!=null){

                vehiculosRef.child(vehiculoActualRef.getKey()).setValue(ve);
                vehiculosRef.child(vehiculoActualRef.getKey()).child("cliente").child(client.getIdcliente()).setValue(client);
                limpiar();
                this.finish();
            }else{
                Toast.makeText(this,"Hubo un error al agregar cliente...",Toast.LENGTH_SHORT).show();
                return;
            }

        }
    }

    public void limpiar(){
        txtvehiclebrandadd.setText("");
        txtvehiclemodeladd.setText("");
        txtvehicleplacaadd.setText("");
        txtvehicletypeadd.setText("");
        txtvehicleclientadd.setText("");
    }

    @SuppressWarnings("unchecked")
    public void BuscaCliente(final String documento) {

        final  ArrayList<Client> sug = new ArrayList<>();


        Query referencias =  FirebaseDatabase.getInstance().getReference("clientes").orderByChild("documento").startAt(documento).endAt((documento)+ "\uf8ff");

        referencias.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        Client cliente = ds.getValue(Client.class);
                        sug.add(cliente);
                    }

                    ArrayAdapter<Client> arrayAdapter = new ArrayAdapter<>(VehicleRegisterActivity.this, android.R.layout.simple_list_item_1, sug);
                    txtvehicleclientadd.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
            BuscaCliente((s.subSequence(0, s.length()).toString()));
        }
    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        client=(Client)parent.getAdapter().getItem(position);

    }
}
