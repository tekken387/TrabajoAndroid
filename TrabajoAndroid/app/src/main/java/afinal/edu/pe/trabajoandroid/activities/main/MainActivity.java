package afinal.edu.pe.trabajoandroid.activities.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

import afinal.edu.pe.trabajoandroid.activities.clients.ClientsActivity;
import afinal.edu.pe.trabajoandroid.activities.serviceorder.ServiceOrdersActivity;
import afinal.edu.pe.trabajoandroid.activities.services.ServicesActivity;
import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.activities.vehicle.VehiclesActivity;
import afinal.edu.pe.trabajoandroid.util.FinalSharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FinalSharedPreferences prefs;
    ImageButton btnlogout;
    ImageButton btnclients;
    ImageButton btnos;
    ImageButton btnservices;
    ImageButton btnvehicles;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=new FinalSharedPreferences(this);

        btnclients=findViewById(R.id.btnclients);
        btnos=findViewById(R.id.btnos);
        btnservices=findViewById(R.id.btnservices);
        btnvehicles=findViewById(R.id.btnvehicles);
        btnlogout=findViewById(R.id.btnLogout);

        btnlogout.setOnClickListener(this);
        btnclients.setOnClickListener(this);
        btnos.setOnClickListener(this);
        btnservices.setOnClickListener(this);
        btnvehicles.setOnClickListener(this);

        auth = auth.getInstance();
        user=auth.getCurrentUser();

    }

    @Override
    public void onBackPressed() {
        //no hace nada cuando presiona el boton de atras
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (user==null) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnLogout:
                auth.getInstance().signOut();
                abrirlogin();
                break;
            case R.id.btnclients:
                intent=new Intent(this,ClientsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnservices:
                intent=new Intent(this,ServicesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnos:
                intent=new Intent(this,ServiceOrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.btnvehicles:
                intent=new Intent(this,VehiclesActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void abrirlogin(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
