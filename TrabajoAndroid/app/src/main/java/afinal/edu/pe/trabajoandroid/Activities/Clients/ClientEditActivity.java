package afinal.edu.pe.trabajoandroid.Activities.Clients;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import afinal.edu.pe.trabajoandroid.R;

public class ClientEditActivity extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            id= null;
        } else {
            id= extras.getString("idcliente");
        }
    }
}
