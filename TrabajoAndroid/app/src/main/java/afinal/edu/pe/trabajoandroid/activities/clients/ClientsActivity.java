package afinal.edu.pe.trabajoandroid.activities.clients;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import afinal.edu.pe.trabajoandroid.adapters.ClientAdapter;
import afinal.edu.pe.trabajoandroid.dao.DAOClients;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientsActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lvclients;
    ArrayList<Client> clientes;
    DAOClients daoclients;
    Button btnclientadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        btnclientadd=findViewById(R.id.btnclientadd);
        lvclients=findViewById(R.id.lvclients);
        clientes=new ArrayList<Client>();

        btnclientadd.setOnClickListener(this);
        //DatabaseReference clientRef = FirebaseDatabase.getInstance().getReference("clientes");
        cargaDatos();

    }

    public void cargaDatos(){

        ClientAdapter adapter = new ClientAdapter(this);

        lvclients.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientadd){
            Intent intent=new Intent(this,ClientRegisterActivity.class);
            startActivity(intent);
        }
    }
}
