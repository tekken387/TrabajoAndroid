package afinal.edu.pe.trabajoandroid.activities.vehicle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.adapters.VehicleAdapter;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.models.Vehicle;

public class VehiclesActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvvehicles;
    ArrayList<Vehicle> vehiculos;
    ImageButton btnvehiclesadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        btnvehiclesadd=findViewById(R.id.btnvehiclesadd);
        lvvehicles=findViewById(R.id.lvvehicles);
        vehiculos=new ArrayList<>();

        btnvehiclesadd.setOnClickListener(this);
        cargaDatos();
    }

    public void cargaDatos(){
        VehicleAdapter adapter = new VehicleAdapter(this);
        lvvehicles.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnvehiclesadd){
            Intent intent=new Intent(this,VehicleRegisterActivity.class);
            startActivity(intent);
        }
    }
}
