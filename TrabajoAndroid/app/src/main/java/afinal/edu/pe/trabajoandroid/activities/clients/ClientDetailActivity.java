package afinal.edu.pe.trabajoandroid.activities.clients;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientDetailActivity extends AppCompatActivity implements View.OnClickListener {

    String id;
    TextView txtclientnameshow;
    TextView txtclientname2show;
    TextView txtclientdnishow;
    TextView txtclientphoneshow;
    TextView txtclientemailshow;
    TextView txtclientdirectionshow;
    TextView txtclientciudadshow;
    ImageButton btnclientbackshow;
    FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        txtclientnameshow=findViewById(R.id.txtclientnameshow);
        txtclientname2show=findViewById(R.id.txtclientname2show);
        txtclientdnishow=findViewById(R.id.txtclientdnishow);
        txtclientphoneshow=findViewById(R.id.txtclientphoneshow);
        txtclientemailshow=findViewById(R.id.txtclientemailshow);
        txtclientciudadshow=findViewById(R.id.txtclientciudadshow);
        btnclientbackshow=findViewById(R.id.btnclientbackshow);
        btnclientbackshow.setOnClickListener(this);

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
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientbackshow){
            this.finish();
        }
    }

    public void cargaDatos(DatabaseReference clientsRef){

        clientsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Client cliente = dataSnapshot.getValue(Client.class);
                txtclientnameshow.setText(cliente.getNombre());
                txtclientname2show.setText(cliente.getApellido());
                txtclientdnishow.setText(cliente.getDocumento());
                txtclientemailshow.setText(cliente.getEmail());
                txtclientphoneshow.setText(cliente.getTelefono());
                txtclientdirectionshow.setText(cliente.getDireccion());
                txtclientciudadshow.setText(cliente.getCiudad());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
