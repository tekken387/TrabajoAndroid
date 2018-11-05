package afinal.edu.pe.trabajoandroid.Activities.Clients;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import afinal.edu.pe.trabajoandroid.R;

public class ClientRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnclientsave;
    TextView txtclientnameadd;
    TextView txtclientnameadd2;
    TextView txtclientemailadd;
    TextView txtclientdniadd;
    TextView txtclientphoneadd;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);

        btnclientsave.findViewById(R.id.btnclientsave);
        txtclientdniadd.findViewById(R.id.txtclientdniadd);
        txtclientemailadd.findViewById(R.id.txtclientemailadd);
        txtclientnameadd.findViewById(R.id.txtclientnameadd);
        txtclientnameadd2.findViewById(R.id.txtclientnameadd2);

        btnclientsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnclientadd){
            database = FirebaseDatabase.getInstance();
            DatabaseReference mensajesRef = database.getReference("mensajes");
            DatabaseReference mensajeActualRef = mensajesRef.push();

            HashMap map=new HashMap();

            map.put("id_usuario",pf.getString(ChatkiSharedPreferences.PREF_IDUSUARIO,null));
            map.put("nombre",pf.getString(ChatkiSharedPreferences.PREF_NOMBRE_USUARIO,null));
            map.put("mensaje",txtmensaje.getText().toString());
            map.put("hora",System.currentTimeMillis());
            mensajeActualRef.updateChildren(map);

        }
    }
}
