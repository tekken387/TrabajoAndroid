package afinal.edu.pe.trabajoandroid.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import afinal.edu.pe.trabajoandroid.Models.Client;
import afinal.edu.pe.trabajoandroid.R;

public class ClientAdapter extends ArrayAdapter {

    public ClientAdapter(@NonNull Context context, List<Client> clients) {
        super(context, R.layout.client_adapter, R.id.txtclientname, clients);
    }

    TextView _txtclientname;
    TextView _txtclientname2;
    TextView _txtclientemail;
    Button _btnclientedit;
    Button _btnclientshow;
    Client client;

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=super.getView(position,convertView,parent);
        _txtclientname=view.findViewById(R.id.txtclientname);
        _txtclientname2=view.findViewById(R.id.txtclientname2);
        _txtclientemail=view.findViewById(R.id.txtclientemail);
        _btnclientedit=view.findViewById(R.id.btnclientedit);
        _btnclientshow=view.findViewById(R.id.btnclientshow);

        client=(Client)getItem(position);

        _txtclientname.setText(client.getNombre());
        _txtclientname2.setText(client.getApellido());
        _txtclientemail.setText(client.getEmail());

        return view;

    }



}



