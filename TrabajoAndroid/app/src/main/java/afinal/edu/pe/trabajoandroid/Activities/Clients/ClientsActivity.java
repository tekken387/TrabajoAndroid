package afinal.edu.pe.trabajoandroid.Activities.Clients;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        btnclientadd=findViewById(R.id.btnclientadd);
        lvclients=findViewById(R.id.lvclients);
        clientes=new ArrayList<Client>();

        btnclientadd.setOnClickListener(this);

        DatabaseReference clientRef = FirebaseDatabase.getInstance().getReference("clientes");
        FirebaseListOptions<Client> options =
                new FirebaseListOptions.Builder<Client>()
                        .setQuery(clientRef, Client.class)
                        .setLayout(R.layout.client_adapter)
                        .setLifecycleOwner(this)
                        .build();

        ListAdapter adapter = new FirebaseListAdapter<Client>(options) {
            @Override
            protected void populateView(View view, Client s, int i) {
                TextView text = view.findViewById(R.id.txtclientname);
                text.setText(s.getNombre() + ": " + s.getApellido() + " - "+  s.getDocumento());
            }
        };
        lvclients.setAdapter(adapter);

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
