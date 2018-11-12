package afinal.edu.pe.trabajoandroid.util;

import android.content.Context;

public class FinalSharedPreferences {

    public static final String SHARE_PREFERENCES_PROJECT="MOTOREP";
    public static final String SHARE_PREFERENCES_USUARIO="USUARIO";

    private android.content.SharedPreferences preferences;

    public FinalSharedPreferences(Context ctx){
        //construye y/u obtiene un shared preferences
        //con nombre "DELIVERY" en modo privado(solo para este apk)
        preferences=ctx.getSharedPreferences(SHARE_PREFERENCES_PROJECT, Context.MODE_PRIVATE);
    }

    public void putString(String key,String value){
        android.content.SharedPreferences.Editor editor=preferences.edit(); //setea las preferencias en modo edicion
        editor.putString(key,value); //agrega la preferencia
        editor.apply(); //aplica cambios
    }

    public String getString(String key,String defaultValue){
        return preferences.getString(key,defaultValue); //obtiene una preferencia
    }
}
