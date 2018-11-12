package afinal.edu.pe.trabajoandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import afinal.edu.pe.trabajoandroid.activities.clients.ClientDetailActivity;
import afinal.edu.pe.trabajoandroid.activities.clients.ClientEditActivity;
import afinal.edu.pe.trabajoandroid.dao.DAOClients;
import afinal.edu.pe.trabajoandroid.models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientAdapter extends FirebaseListAdapter<Client> {

    private Context context;
    private TextView _txtclientname;
    private TextView _txtclientname2;
    private TextView _txtclientemail;
    private Button _btnclientedit;
    private Button _btnclientshow;


    public ClientAdapter(@NonNull AppCompatActivity context) {
        super(new FirebaseListOptions.Builder<Client>()
                .setQuery(DAOClients.getClients(), Client.class)
                .setLayout(R.layout.client_adapter)
                .setLifecycleOwner(context)
                .build());
        this.context = context;
    }


    protected void populateView(View view, final Client client, int i) {
        _txtclientname=view.findViewById(R.id.txtclientname);
        _txtclientname2=view.findViewById(R.id.txtclientname2);
        _txtclientemail=view.findViewById(R.id.txtclientemail);
        _btnclientedit=view.findViewById(R.id.btnclientedit);
        _btnclientshow=view.findViewById(R.id.btnclientshow);

        _txtclientname.setText(client.getNombre());
        _txtclientname2.setText(client.getApellido());
        _txtclientemail.setText(client.getEmail());

        _btnclientedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ClientEditActivity.class);
                intent.putExtra("idcliente",client.getIdcliente());
                context.startActivity(intent);

            }
        });
        _btnclientshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ClientDetailActivity.class);
                intent.putExtra("idcliente",client.getIdcliente());
                context.startActivity(intent);

            }
        });
    }


}



