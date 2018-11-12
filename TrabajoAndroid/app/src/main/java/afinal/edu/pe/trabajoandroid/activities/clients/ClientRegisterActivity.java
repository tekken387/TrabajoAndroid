package afinal.edu.pe.trabajoandroid.activities.clients;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button _btnclientsave;
    TextView _txtclientnameadd;
    TextView _txtclientnameadd2;
    TextView _txtclientemailadd;
    TextView _txtclientdniadd;
    TextView _txtclientphoneadd;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);

        _btnclientsave=findViewById(R.id.btnclientsave);
        _txtclientdniadd=findViewById(R.id.txtclientdniadd);
        _txtclientemailadd=findViewById(R.id.txtclientemailadd);
        _txtclientnameadd=findViewById(R.id.txtclientnameadd);
        _txtclientnameadd2=findViewById(R.id.txtclientnameadd2);
        _txtclientphoneadd=findViewById(R.id.txtclientphoneadd);
        _btnclientsave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientsave){
            database = FirebaseDatabase.getInstance();
            DatabaseReference clientsRef = database.getReference("clientes");
            DatabaseReference clientActualRef = clientsRef.push();

            Client cliente=new Client();
            cliente.setIdcliente(clientActualRef.getKey());
            cliente.setNombre(_txtclientnameadd.getText().toString());
            cliente.setApellido(_txtclientnameadd2.getText().toString());
            cliente.setDocumento(_txtclientdniadd.getText().toString());
            cliente.setEmail(_txtclientemailadd.getText().toString());
            cliente.setTelefono(_txtclientphoneadd.getText().toString());

            clientsRef.child(clientActualRef.getKey()).setValue(cliente);

            limpiar();
        }
    }

    public void limpiar(){
        _txtclientemailadd.setText("");
        _txtclientdniadd.setText("");
        _txtclientnameadd.setText("");
        _txtclientnameadd2.setText("");
        _txtclientphoneadd.setText("");
    }
}
