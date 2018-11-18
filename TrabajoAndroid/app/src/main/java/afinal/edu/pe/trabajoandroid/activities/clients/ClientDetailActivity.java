package afinal.edu.pe.trabajoandroid.activities.clients;

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

import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientDetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtclientnameshow2;
    TextView txtclientname2show;
    TextView txtclientdnishow;
    TextView txtclientphoneshow;
    TextView txtclientemailshow;
    ImageButton btnbackshow;
    FirebaseDatabase db;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        txtclientnameshow2=findViewById(R.id.txtclientnameshow2);
        txtclientname2show=findViewById(R.id.txtclientname2show);
        txtclientdnishow=findViewById(R.id.txtclientdnishow);
        txtclientphoneshow=findViewById(R.id.txtclientphoneshow);
        txtclientemailshow=findViewById(R.id.txtclientemailshow);
        btnbackshow=findViewById(R.id.btnbackshow);
        btnbackshow.setOnClickListener(this);
        db = FirebaseDatabase.getInstance();
        Bundle extras = getIntent().getExtras();


        String id;
        if(extras == null) {
            id= null;
        } else {
            id= extras.getString("idcliente");
        }

        if(id != null) {
            DatabaseReference clientsRef = db.getReference("clientes/" + id);
            clientsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Client cliente = dataSnapshot.getValue(Client.class);
                    txtclientnameshow2.setText(cliente.getNombre());
                    txtclientname2show.setText(cliente.getApellido());
                    txtclientdnishow.setText(cliente.getDocumento());
                    txtclientemailshow.setText(cliente.getEmail());
                    txtclientphoneshow.setText(cliente.getTelefono());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else{
            Toast.makeText(this,"Hubo un error al consultar cliente...",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnbackshow){
            this.finish();
        }
    }

    public void cerrarActivity(){
        this.finish();
    }


}
