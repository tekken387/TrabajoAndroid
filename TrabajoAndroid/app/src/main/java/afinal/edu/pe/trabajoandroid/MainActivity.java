package afinal.edu.pe.trabajoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import afinal.edu.pe.trabajoandroid.Util.FinalSharedPreferences;

public class MainActivity extends AppCompatActivity {

    FinalSharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=new FinalSharedPreferences(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String usuario = prefs.getString(prefs.SHARE_PREFERENCES_USUARIO,null);
        if(usuario==null){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
