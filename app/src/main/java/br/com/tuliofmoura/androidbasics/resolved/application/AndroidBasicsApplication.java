package br.com.tuliofmoura.androidbasics.resolved.application;

import android.app.Application;

import io.realm.Realm;

/**
 * Criado por Tulio Moura em 17/out/2018.
 */
public class AndroidBasicsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
