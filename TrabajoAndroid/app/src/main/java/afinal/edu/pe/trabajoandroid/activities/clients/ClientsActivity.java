package afinal.edu.pe.trabajoandroid.activities.clients;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

import afinal.edu.pe.trabajoandroid.adapters.ClientAdapter;
import afinal.edu.pe.trabajoandroid.dao.DAOClients;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.util.ChildEventListenerApp;

public class ClientsActivity extends AppCompatActivity implements View.OnClickListener {


    ListView lvclients;
    ArrayList<Client> clientes;
    DAOClients daoclients;
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
