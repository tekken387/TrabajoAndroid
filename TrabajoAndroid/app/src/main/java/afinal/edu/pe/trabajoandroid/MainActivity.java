package afinal.edu.pe.trabajoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

import afinal.edu.pe.trabajoandroid.Util.FinalSharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FinalSharedPreferences prefs;
    Button _btnlogout;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=new FinalSharedPreferences(this);

        _btnlogout=findViewById(R.id.btnLogout);

        _btnlogout.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            //se queda en la pantalla main
        } else {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

        //String usuario = prefs.getString(prefs.SHARE_PREFERENCES_USUARIO,null);
        /*if(usuario==null){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogout:
                user=auth.getInstance().getCurrentUser();
                auth.signOut();
                abrirlogin();
                break;
        }
    }

    public void abrirlogin(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
