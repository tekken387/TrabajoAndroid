package afinal.edu.pe.trabajoandroid.activities.clients;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.adapters.ClientAdapter;
import afinal.edu.pe.trabajoandroid.models.Client;

public class ClientsActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lvclients;
    ArrayList<Client> clientes;
    ImageButton btnclientadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        btnclientadd=findViewById(R.id.btnclientadd);
        lvclients=findViewById(R.id.lvclients);
        clientes=new ArrayList<>();

        btnclientadd.setOnClickListener(this);
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
