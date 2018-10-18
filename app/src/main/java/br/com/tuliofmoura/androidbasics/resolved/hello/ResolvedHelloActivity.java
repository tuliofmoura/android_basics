package br.com.tuliofmoura.androidbasics.resolved.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.category.ResolvedCategoriesActivity;
import br.com.tuliofmoura.androidbasics.resolved.preferences.ResolvedPreferences;

public class ResolvedHelloActivity extends AppCompatActivity implements ResolvedHelloFragment.FragmentInteractionListener {

    private static final String EXTRA_NAME_KEY = "name";

    public static Intent newIntent(Context context, String name) {
        final Intent intent = new Intent(context, ResolvedHelloActivity.class);
        intent.putExtra(EXTRA_NAME_KEY, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_hello);
    }

    @Override
    public String getUserName() {
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString(EXTRA_NAME_KEY);
        }
        return "";
    }

    @Override
    public void onButtonClicked(boolean checked) {
        ResolvedPreferences.setNeedToShowHello(this, !checked);
        ResolvedPreferences.setUserName(this, getUserName());
        startActivity(ResolvedCategoriesActivity.newIntent(this));
        finish();
    }
}
