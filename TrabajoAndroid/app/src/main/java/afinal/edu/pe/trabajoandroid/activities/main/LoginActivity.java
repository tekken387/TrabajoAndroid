package afinal.edu.pe.trabajoandroid.activities.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import afinal.edu.pe.trabajoandroid.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth auth;
    FirebaseUser user;

    Button _btningresar;
    EditText _txtusername;
    EditText _txtpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _btningresar=findViewById(R.id.btnIngresar);
        _txtpwd=findViewById(R.id.txtPwd);
        _txtusername=findViewById(R.id.txtUsername);

        auth = auth.getInstance();
        user=auth.getCurrentUser();

        _btningresar.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (user!=null) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:
                if(_txtusername.getText().toString().equals("") || _txtpwd.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Porfavor ingrese datos....",
                            Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    login(_txtusername.getText().toString(), _txtpwd.getText().toString());
                    break;
                }
        }
    }

    public void login(String email, String password){
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override

                public void onComplete (@NonNull Task < AuthResult > task) {

                        if (task.isSuccessful()) {

                            FirebaseUser user = auth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Bienvenido",
                                    Toast.LENGTH_SHORT).show();

                            abrirmain();

                        } else Toast.makeText(LoginActivity.this, "Error en la autentificacion",
                                Toast.LENGTH_SHORT).show();

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Error en la autentificacion",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [END_EXCLUDE]
                }
        });
    }

    private void abrirmain() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
