package afinal.edu.pe.trabajoandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;

import afinal.edu.pe.trabajoandroid.R;
import afinal.edu.pe.trabajoandroid.activities.vehicle.VehicleDetailActivity;
import afinal.edu.pe.trabajoandroid.activities.vehicle.VehicleEditActivity;
import afinal.edu.pe.trabajoandroid.models.Vehicle;

public class VehicleAdapter extends FirebaseListAdapter<Vehicle> {

    private Context context;
    private TextView txtvehicletype;
    private TextView txtvehiclemodel;
    private TextView txtvehiclebrand;
    private TextView txtvehicleplaca;
    private ImageButton btnvehicleedit;
    private ImageButton btnvehicleshow;


    public VehicleAdapter(@NonNull AppCompatActivity context) {
        super(new FirebaseListOptions.Builder<Vehicle>()
                .setQuery(FirebaseDatabase.getInstance().getReference("vehiculos"), Vehicle.class)
                .setLayout(R.layout.vehicle_adapter)
                .setLifecycleOwner(context)
                .build());
        this.context = context;
    }


    protected void populateView(View view, final Vehicle ve, int i) {
        txtvehicletype=view.findViewById(R.id.txtvehicletype);
        txtvehiclemodel=view.findViewById(R.id.txtvehiclemodel);
        txtvehiclebrand=view.findViewById(R.id.txtvehiclebrand);
        txtvehicleplaca=view.findViewById(R.id.txtvehicleplaca);

        btnvehicleedit=view.findViewById(R.id.btnvehicleedit);
        btnvehicleshow=view.findViewById(R.id.btnvehicleshow);

        txtvehicletype.setText(ve.getTipo());
        txtvehiclemodel.setText(ve.getModelo());
        txtvehiclebrand.setText(ve.getMarca());
        txtvehicleplaca.setText(ve.getPlaca());

        btnvehicleedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,VehicleEditActivity.class);
                intent.putExtra("idvehiculo",ve.getIdvehiculo());
                context.startActivity(intent);

            }
        });

        btnvehicleshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,VehicleDetailActivity.class);
                intent.putExtra("idvehiculo",ve.getIdvehiculo());
                context.startActivity(intent);

            }
        });


    }

}
