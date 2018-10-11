package br.com.tuliofmoura.androidbasics.resolved;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.tuliofmoura.androidbasics.resolved.category.ResolvedFutureMainActivity;
import br.com.tuliofmoura.androidbasics.resolved.hello.ResolvedStarterActivity;
import br.com.tuliofmoura.androidbasics.resolved.preferences.ResolvedPreferences;

/**
 * Criado por Tulio Moura em 03/out/2018.
 */
public class ResolvedBrandedLaunchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final boolean needToShowHello = ResolvedPreferences.needToShowHello(this);
        final Intent intent;
        if (needToShowHello)
            intent = ResolvedStarterActivity.newIntent(this);
        else
            intent = ResolvedFutureMainActivity.newIntent(this);
        startActivity(intent);
        finish();
    }

}
