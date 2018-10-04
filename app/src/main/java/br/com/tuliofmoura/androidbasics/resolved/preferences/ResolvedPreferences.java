package br.com.tuliofmoura.androidbasics.resolved.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Criado por Tulio Moura em 03/out/2018.
 */
public class ResolvedPreferences {

    private static final String GLOBAL_SETTINGS_NAME = "GlobalPreferences";
    private static final String USER_NAME = "userName";
    private static final String SHOW_HELLO = "showHello";

    public static synchronized String getUserName(Context context) {
        final SharedPreferences preferences = context.getSharedPreferences(GLOBAL_SETTINGS_NAME, Context.MODE_PRIVATE);
        return preferences.getString(USER_NAME, "");
    }

    public static synchronized void setUserName(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences(GLOBAL_SETTINGS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(USER_NAME, name);
        editor.apply();
    }

    public static synchronized boolean needToShowHello(Context context) {
        final SharedPreferences preferences = context.getSharedPreferences(GLOBAL_SETTINGS_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(SHOW_HELLO, true);
    }

    public static synchronized void setNeedToShowHello(Context context, boolean needToShowHello) {
        SharedPreferences.Editor editor = context.getSharedPreferences(GLOBAL_SETTINGS_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(SHOW_HELLO, needToShowHello);
        editor.apply();
    }
}
