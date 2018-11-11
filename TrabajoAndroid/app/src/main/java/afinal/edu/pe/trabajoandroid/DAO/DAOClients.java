package afinal.edu.pe.trabajoandroid.DAO;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOClients{

    public static Query getClients(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return database.getReference("clientes");
    }
}
