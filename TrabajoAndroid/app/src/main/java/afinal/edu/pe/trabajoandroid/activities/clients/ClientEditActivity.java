package afinal.edu.pe.trabajoandroid.activities.clients;

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

public class ClientEditActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase db;
    EditText txtclientnameedit;
    EditText txtclientname2edit;
    EditText txtclientdniedit;
    EditText txtclientemailedit;
    EditText txtclientphoneedit;
    ImageButton btnclientsaveedit;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit);
        txtclientnameedit=findViewById(R.id.txtclientnameedit);
        txtclientname2edit=findViewById(R.id.txtclientname2edit);
        txtclientdniedit=findViewById(R.id.txtclientdniedit);
        txtclientemailedit=findViewById(R.id.txtclientemailedit);
        txtclientphoneedit=findViewById(R.id.txtclientphoneedit);
        btnclientsaveedit=findViewById(R.id.btnclientsaveedit);
        btnclientsaveedit.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();

        if(extras == null) {
            id= null;
        } else {
            id= extras.getString("idcliente");
        }

        db = FirebaseDatabase.getInstance();
        DatabaseReference clientsRef = db.getReference("clientes/" + id);

        if(id != null) {
            cargaDatos(clientsRef);
        }else{
            Toast.makeText(this,"Hubo un error al consultar cliente...",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void cerrarActivity(){
        this.finish();
    }

    public void cargaDatos(DatabaseReference clientsRef){

        clientsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Client cliente = dataSnapshot.getValue(Client.class);
                txtclientnameedit.setText(cliente.getNombre());
                txtclientname2edit.setText(cliente.getApellido());
                txtclientdniedit.setText(cliente.getDocumento());
                txtclientemailedit.setText(cliente.getEmail());
                txtclientphoneedit.setText(cliente.getTelefono());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        DatabaseReference clientsRef = db.getReference("clientes/");
        //DatabaseReference clientsRef1 = db.getReference("vehiculos/cliente/"+id);
        //falta verificar como poder actualizar el cliente en distintos nodos

        Client cliente=new Client();
        cliente.setIdcliente(id);
        cliente.setNombre(txtclientnameedit.getText().toString());
        cliente.setApellido(txtclientname2edit.getText().toString());
        cliente.setDocumento(txtclientdniedit.getText().toString());
        cliente.setEmail(txtclientemailedit.getText().toString());
        cliente.setTelefono(txtclientphoneedit.getText().toString());

        HashMap map = new HashMap();
        map.put(id,cliente);

        clientsRef.updateChildren(map);
        //clientsRef1.updateChildren(map);
        Toast.makeText(this,"Se actualizó correctamente...",Toast.LENGTH_SHORT).show();
        cerrarActivity();
    }
}
