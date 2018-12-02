package afinal.edu.pe.trabajoandroid.activities.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.adapters.ServiceAdapter;
import afinal.edu.pe.trabajoandroid.models.Service;

public class ServicesActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvservices;
    ArrayList<Service> servicios;
    ImageButton btnservicesadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        btnservicesadd=findViewById(R.id.btnservicesadd);
        lvservices=findViewById(R.id.lvvehicles);
        servicios=new ArrayList<>();

        btnservicesadd.setOnClickListener(this);
        cargaDatos();

    }

    public void cargaDatos(){

        ServiceAdapter adapter = new ServiceAdapter(this);
        lvservices.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnservicesadd){
            Intent intent=new Intent(this,ServiceRegisterActivity.class);
            startActivity(intent);
        }
    }
}
