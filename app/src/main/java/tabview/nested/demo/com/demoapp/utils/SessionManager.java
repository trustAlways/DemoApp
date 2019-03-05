package tabview.nested.demo.com.demoapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import java.util.ArrayList;

import tabview.nested.demo.com.demoapp.MainActivity;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    public static final String PREF_NAME = "DemoAppsharedpref";
    public static final String IS_LOGIN = "IsLoggedIn";

    public static final String IS_REGISTER= "IsRegisterd";


    public static final String KEY_USER_ID = "userid";
    public static final String KEY_MOBILE = "mobile";

    public static final String KEY_ANOTHER_USER_ID = "anotheruserid";

    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_LATITUDE = "latitude";

    public static final String KEY_FIRST_NAME = "keyfirstname";
    public static final String KEY_LAST_NAME = "keylastname";
    public static final String KEY_EMAIL = "keyemail";
    public static final String KEY_USER_TYPE = "keyusertype";

    public static final String KEY_GENDER_ = "keygender";
    public static final String KEY_AGE   = "keyage";

    public static final String KEY_ZODIAC   = "keyzodiac";


    //------------------Firebase notification token
    public static final String NOTIFICATION_TOKEN= "firebasetoken";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

    public void createRegistersession(String mobile,String user_id)
    {
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_USER_ID,user_id);
        editor.putBoolean(IS_REGISTER, true);
        editor.commit();
    }

    public void createLoginsession(String mobile,String user_id)
    {
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_USER_ID,user_id);
        editor.putBoolean(IS_LOGIN,true);
        editor.commit();
    }






    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public String getData(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void setData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public boolean isRegisterdIn() {
        return sharedPreferences.getBoolean(IS_REGISTER, false);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


}
