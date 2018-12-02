package afinal.edu.pe.trabajoandroid.activities.clients;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnclientsaveadd;
    TextView txtclientnameadd;
    TextView txtclientname2add;
    TextView txtclientemailadd;
    TextView txtclientdniadd;
    TextView txtclientphoneadd;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);

        btnclientsaveadd=findViewById(R.id.btnclientsaveadd);
        txtclientdniadd=findViewById(R.id.txtclientdniadd);
        txtclientemailadd=findViewById(R.id.txtclientemailadd);
        txtclientnameadd=findViewById(R.id.txtclientnameadd);
        txtclientname2add=findViewById(R.id.txtclientname2add);
        txtclientphoneadd=findViewById(R.id.txtclientphoneadd);
        btnclientsaveadd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientsaveadd){
            database = FirebaseDatabase.getInstance();
            DatabaseReference clientsRef = database.getReference("clientes");
            DatabaseReference clientActualRef = clientsRef.push();

            Client cliente=new Client();
            cliente.setIdcliente(clientActualRef.getKey());
            cliente.setNombre(txtclientnameadd.getText().toString());
            cliente.setApellido(txtclientname2add.getText().toString());
            cliente.setDocumento(txtclientdniadd.getText().toString());
            cliente.setEmail(txtclientemailadd.getText().toString());
            cliente.setTelefono(txtclientphoneadd.getText().toString());

            clientsRef.child(clientActualRef.getKey()).setValue(cliente);

            limpiar();
        }
    }

    public void limpiar(){
        txtclientemailadd.setText("");
        txtclientdniadd.setText("");
        txtclientnameadd.setText("");
        txtclientname2add.setText("");
        txtclientphoneadd.setText("");
    }
}
