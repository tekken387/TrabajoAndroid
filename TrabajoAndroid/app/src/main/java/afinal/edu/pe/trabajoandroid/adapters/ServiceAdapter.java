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
import afinal.edu.pe.trabajoandroid.activities.services.ServiceDetailActivity;
import afinal.edu.pe.trabajoandroid.activities.services.ServiceEditActivity;
import afinal.edu.pe.trabajoandroid.models.Service;

public class ServiceAdapter extends FirebaseListAdapter<Service> {

    private Context context;
    private TextView txtservicename;
    private TextView txtserviceprice;
    private ImageButton btnserviceedit;
    private ImageButton btnserviceshow;


    public ServiceAdapter(@NonNull AppCompatActivity context) {
        super(new FirebaseListOptions.Builder<Service>()
                .setQuery(FirebaseDatabase.getInstance().getReference("servicios"), Service.class)
                .setLayout(R.layout.services_adapter)
                .setLifecycleOwner(context)
                .build());
        this.context = context;
    }


    protected void populateView(View view, final Service s, int i) {
        txtservicename=view.findViewById(R.id.txtservicename);
        txtserviceprice=view.findViewById(R.id.txtclientname2);
        btnserviceedit=view.findViewById(R.id.btnserviceedit);
        btnserviceshow=view.findViewById(R.id.btnserviceshow);

        txtservicename.setText(s.getNombre());
        txtserviceprice.setText(String.valueOf(s.getPrecio()));

        btnserviceedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ServiceEditActivity.class);
                intent.putExtra("idservicio",s.getIdservicio());
                context.startActivity(intent);

            }
        });
        btnserviceshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ServiceDetailActivity.class);
                intent.putExtra("idservicio",s.getIdservicio());
                context.startActivity(intent);

            }
        });


    }


}
