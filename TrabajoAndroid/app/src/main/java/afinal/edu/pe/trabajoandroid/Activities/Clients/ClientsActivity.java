package afinal.edu.pe.trabajoandroid.Activities.Clients;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import afinal.edu.pe.trabajoandroid.Adapters.ClientAdapter;
import afinal.edu.pe.trabajoandroid.DAO.DAOClients;
import afinal.edu.pe.trabajoandroid.Models.Client;
import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.Util.ChildEventListenerApp;

public class ClientsActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lvclients;
    ArrayList<Client> clientes;
    DAOClients daoclients;
    Button btnclientadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        btnclientadd.findViewById(R.id.btnclientadd);
        lvclients=findViewById(R.id.lvclients);

        btnclientadd.setOnClickListener(this);

        ClientAdapter cladapter= new ClientAdapter(this,clientes);
        DAOClients.getClients().addChildEventListener(new ChildEventListenerApp(){
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String usuarioNuevo=dataSnapshot.getValue(String.class);

            }


        });
    }

    public void cargaDatos(){

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientadd){
            Intent intent=new Intent(this,ClientRegisterActivity.class);
            startActivity(intent);
        }
    }
}
