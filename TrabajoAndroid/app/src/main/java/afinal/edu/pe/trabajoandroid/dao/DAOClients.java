package afinal.edu.pe.trabajoandroid.dao;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOClients{

    public static Query getClients(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return database.getReference("clientes");
    }

    public static Query getClient(String id){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return database.getReference("clientes/"+id);
    }

    public static Query updateClient(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return database.getReference("clientes");
    }


}
