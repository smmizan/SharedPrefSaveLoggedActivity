package com.smmizan.loginactivitysavesharedpreferanceapi;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mizan on 13/02/2019.
 */

public class SharedPreferencesConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferencesConfig(Context context)
    {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_pref),Context.MODE_PRIVATE);
    }


    public void writeLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_pref_status),status);
        editor.commit();
    }


    public boolean readLoginStatus()
    {
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_pref_status),false);
        return status;
    }
}
