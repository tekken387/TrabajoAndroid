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
import afinal.edu.pe.trabajoandroid.activities.clients.ClientDetailActivity;
import afinal.edu.pe.trabajoandroid.activities.clients.ClientEditActivity;
import afinal.edu.pe.trabajoandroid.models.Client;

public class ClientAdapter extends FirebaseListAdapter<Client> {

    private Context context;
    private TextView _txtclientname;
    private TextView _txtclientname2;
    private TextView _txtclientemail;
    private ImageButton _btnclientedit;
    private ImageButton _btnclientshow;
    private Client c;

    public ClientAdapter(@NonNull AppCompatActivity context) {
        super(new FirebaseListOptions.Builder<Client>()
                .setQuery(FirebaseDatabase.getInstance().getReference("clientes"), Client.class)
                .setLayout(R.layout.client_adapter)
                .setLifecycleOwner(context)
                .build());
        this.context = context;
    }


    protected void populateView(View view, Client client, int i) {
        _txtclientname=view.findViewById(R.id.txtclientname);
        _txtclientname2=view.findViewById(R.id.txtclientname2);
        _txtclientemail=view.findViewById(R.id.txtclientemail);
        _btnclientedit=view.findViewById(R.id.btnclientedit);
        _btnclientshow=view.findViewById(R.id.btnclientshow);

        c=client;
        _txtclientname.setText(c.getNombre());
        _txtclientname2.setText(c.getApellido());
        _txtclientemail.setText(c.getEmail());

        _btnclientedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ClientEditActivity.class);
                intent.putExtra("idcliente",c.getIdcliente());
                context.startActivity(intent);

            }
        });
        _btnclientshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ClientDetailActivity.class);
                intent.putExtra("idcliente",c.getIdcliente());
                context.startActivity(intent);

            }
        });
    }


}



