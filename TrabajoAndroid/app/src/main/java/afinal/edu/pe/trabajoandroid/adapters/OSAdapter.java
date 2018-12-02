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
import afinal.edu.pe.trabajoandroid.activities.serviceorder.ServiceOrderDetailActivity;
import afinal.edu.pe.trabajoandroid.activities.serviceorder.ServiceOrderEditActivity;
import afinal.edu.pe.trabajoandroid.models.OS;

public class OSAdapter  extends FirebaseListAdapter<OS> {

    private Context context;
    private TextView txtservicename;
    private TextView txtserviceprice;
    private ImageButton btnserviceedit;
    private ImageButton btnserviceshow;


    public OSAdapter(@NonNull AppCompatActivity context) {
        super(new FirebaseListOptions.Builder<OS>()
                .setQuery(FirebaseDatabase.getInstance().getReference("OS"), OS.class)
                .setLayout(R.layout.service_order_adapter)
                .setLifecycleOwner(context)
                .build());
        this.context = context;
    }


    protected void populateView(View view, final OS s, int i) {
        txtservicename=view.findViewById(R.id.txtservicename);
        txtserviceprice=view.findViewById(R.id.txtserviceprice);
        btnserviceedit=view.findViewById(R.id.btnserviceedit);
        btnserviceshow=view.findViewById(R.id.btnserviceshow);

//        txtservicename.setText(s.getNombre());
//        txtserviceprice.setText(String.valueOf(s.getPrecio()));
//
//        btnserviceedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context,ServiceOrderEditActivity.class);
//                intent.putExtra("idos",s.getIdservicio());
//                context.startActivity(intent);
//
//            }
//        });
//        btnserviceshow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context,ServiceOrderDetailActivity.class);
//                intent.putExtra("idos",s.getIdservicio());
//                context.startActivity(intent);
//
//            }
//        });


    }
}
