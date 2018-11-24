package afinal.edu.pe.trabajoandroid.activities.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import afinal.edu.pe.trabajoandroid.R;

public class ServiceDetailActivity extends AppCompatActivity {

    String id;
    TextView txt;
    TextView txtclientname2show;

    ImageButton btnbackshow;
    FirebaseDatabase db;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_detail);
    }
}
